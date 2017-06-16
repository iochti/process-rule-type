package iochti.processRuleType.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import iochti.processRuleType.dto.ProcessRuleTypeDTO;
import iochti.processRuleType.grpc.ProcessRuleType;
import iochti.processRuleType.grpc.ProcessRuleTypeByIdRequest;
import iochti.processRuleType.grpc.ProcessRuleTypeGrpcAdapter;
import iochti.processRuleType.grpc.ProcessRuleTypeServiceGrpc;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Timestamp;

public class ProcessRuleTypeClient {
	private static final Logger logger = Logger
			.getLogger(ProcessRuleTypeClient.class.getName());

	private final ManagedChannel channel;
	private final ProcessRuleTypeServiceGrpc.ProcessRuleTypeServiceBlockingStub blockingStub;

	/** Construct client connecting to HelloWorld server at {@code host:port}. */
	public ProcessRuleTypeClient(String host, int port) {
		channel = ManagedChannelBuilder.forAddress(host, port)
				.usePlaintext(true).build();
		blockingStub = ProcessRuleTypeServiceGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void createProcessRuleType(ProcessRuleTypeDTO dto) {
		try {
			logger.info("Will try to create a process rule type "
					+ dto.getName() + " ...");
			ProcessRuleType.Builder builder = ProcessRuleType.newBuilder();
			if (dto.getId() != null) {
				builder.setId(dto.getId());
			}
			builder.setName(dto.getName());
			ObjectMapper objectMapper = new ObjectMapper();
			builder.setParameters(objectMapper.writeValueAsString(dto
					.getParameters()));
			ProcessRuleType request = builder.build();
			blockingStub.createProcessRuleType(request);
			logger.info("Data sent");
		} catch (RuntimeException | JsonProcessingException e) {
			logger.log(Level.WARNING, "RPC failed", e);
			return;
		}
	}
	
	public ProcessRuleTypeDTO getProcessRuleType(String id) throws JsonParseException, JsonMappingException, IOException {
		try {
			logger.info("Will try to get the process rule type "
					+ id + " ...");
			ProcessRuleTypeByIdRequest.Builder builder = ProcessRuleTypeByIdRequest.newBuilder();
			builder.setProcessGroupTypeId(id != null ? id : "");
			ProcessRuleTypeByIdRequest request = builder.build();
			logger.info("Data received");
			ProcessRuleType processRuleType = blockingStub.getProcessRuleType(request);
			
			ProcessRuleTypeDTO dto = new ProcessRuleTypeDTO();
			dto.setId("".equals(processRuleType.getId()) ? null : processRuleType.getId());
			dto.setName(processRuleType.getName());
			ObjectMapper mapper = new ObjectMapper();
			Properties parameters = mapper.readValue(processRuleType.getParameters(), Properties.class);
			dto.setParameters(parameters);
			
			return dto;
		} catch (RuntimeException e) {
			logger.log(Level.WARNING, "RPC failed", e);
			throw e;
		}
	}

	/**
	 * Greet server. If provided, the first element of {@code args} is the name
	 * to use in the greeting.
	 */
	public static void main(String[] args) throws Exception {
		ProcessRuleTypeClient client = new ProcessRuleTypeClient("localhost",
				50053);
		try {
			ProcessRuleTypeDTO dto = client.getProcessRuleType("5942440764296f1656746a06");
			logger.info("Received process rule type : " + dto.getName());
		} finally {
			client.shutdown();
		}
	}
}
