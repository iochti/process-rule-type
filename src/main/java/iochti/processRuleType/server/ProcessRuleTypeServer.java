package iochti.processRuleType.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import iochti.processRuleType.dto.ProcessRuleTypeDTO;
import iochti.processRuleType.grpc.ProcessRuleType;
import iochti.processRuleType.grpc.ProcessRuleTypeGrpcAdapter;
import iochti.processRuleType.grpc.ProcessRuleTypeByIdRequest;
import iochti.processRuleType.grpc.ProcessRuleTypeServiceGrpc;
import iochti.processRuleType.grpc.ProcessRuleTypeServiceGrpc.ProcessRuleTypeService;
import iochti.processRuleType.service.ProcessRuleTypeManager;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.protobuf.Empty;

@Service
public class ProcessRuleTypeServer {

	/**
	 * Process rule manager
	 */
	@Autowired
	private ProcessRuleTypeManager manager;

	@Autowired
	private ProcessRuleTypeGrpcAdapter grpcAdapter;

	private static final Logger logger = Logger
			.getLogger(ProcessRuleTypeServer.class.getName());

	/* The port on which the server should run */
	private int port = 50053;
	private Server server;

	@PostConstruct
	private void PostConstruct() throws Exception {
		start();
	}

	private void start() throws Exception {
		server = ServerBuilder
				.forPort(port)
				.addService(
						ProcessRuleTypeServiceGrpc
								.bindService(new ProcessRuleTypeServiceImpl()))
				.build().start();
		logger.info("Server started, listening on " + port);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				// Use stderr here since the logger may have been reset by its
				// JVM shutdown hook.
				System.err
						.println("*** shutting down gRPC server since JVM is shutting down");
				ProcessRuleTypeServer.this.stop();
				System.err.println("*** server shut down");
			}
		});

	}

	private void stop() {
		if (server != null) {
			server.shutdown();
		}
	}

	private class ProcessRuleTypeServiceImpl implements ProcessRuleTypeService {
		@Override
		public void getProcessRuleType(ProcessRuleTypeByIdRequest request,
				StreamObserver<ProcessRuleType> responseObserver) {

			logger.info("Requête reçue");
			String id = request.getProcessGroupTypeId();

			ProcessRuleTypeDTO dto = manager.findById(id);
			try {
				ProcessRuleType grpcResult = grpcAdapter.buildGrpc(dto);
				responseObserver.onNext(grpcResult);
			} catch (JsonProcessingException e) {
				responseObserver.onError(e);
			}

			responseObserver.onCompleted();
		}

		@Override
		public void createProcessRuleType(ProcessRuleType request,
				StreamObserver<ProcessRuleType> responseObserver) {
			
			try {
				ProcessRuleTypeDTO dto = grpcAdapter.buildDto(request);
				ProcessRuleTypeDTO savedDto = manager.save(dto);
				ProcessRuleType grpcObject = grpcAdapter.buildGrpc(savedDto);
				responseObserver.onNext(grpcObject);
			} catch (JsonParseException e) {
				responseObserver.onError(e);
			} catch (JsonMappingException e) {
				responseObserver.onError(e);
			} catch (IOException e) {
				responseObserver.onError(e);
			}

			responseObserver.onCompleted();
		}

		@Override
		public void updateProcessRuleType(ProcessRuleType request,
				StreamObserver<ProcessRuleType> responseObserver) {

			try {
				ProcessRuleTypeDTO dto = grpcAdapter.buildDto(request);
				ProcessRuleTypeDTO savedDto = manager.save(dto);
				ProcessRuleType grpcObject = grpcAdapter.buildGrpc(savedDto);
				responseObserver.onNext(grpcObject);
			} catch (JsonParseException e) {
				responseObserver.onError(e);
			} catch (JsonMappingException e) {
				responseObserver.onError(e);
			} catch (IOException e) {
				responseObserver.onError(e);
			}
			
			responseObserver.onCompleted();
		}

		@Override
		public void deleteProcessRuleType(ProcessRuleTypeByIdRequest request,
				StreamObserver<Empty> responseObserver) {
			
			String id = request.getProcessGroupTypeId();
			manager.delete(id);
			Empty empty = Empty.newBuilder().build();
			responseObserver.onNext(empty);
			responseObserver.onCompleted();
		}
	}
}
