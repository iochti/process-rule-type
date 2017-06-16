package iochti.processRuleType.grpc;

import java.io.IOException;
import java.util.Properties;

import iochti.processRuleType.dto.ProcessRuleTypeDTO;
import iochti.processRuleType.grpc.ProcessRuleType.Builder;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProcessRuleTypeGrpcAdapter {
	
	/**
	 * Transform a data transfer object to a grpc object
	 * 
	 * @param dto
	 * @return
	 * @throws JsonProcessingException
	 */
	public ProcessRuleType buildGrpc(ProcessRuleTypeDTO dto) throws JsonProcessingException {
		Builder builder = ProcessRuleType.newBuilder();
		builder.setId(dto.getId() == null ? "" : dto.getId());
		builder.setName(dto.getName());
		ObjectMapper mapper = new ObjectMapper();
		String serializedParameters = mapper.writeValueAsString(dto.getParameters());
		builder.setParameters(serializedParameters);
		
		return builder.build();
	}
	
	/**
	 * Transform a grpc object to a data transfer object
	 * 
	 * @param grpc
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public ProcessRuleTypeDTO buildDto(ProcessRuleType grpc) throws JsonParseException, JsonMappingException, IOException {
		ProcessRuleTypeDTO dto = new ProcessRuleTypeDTO();
		dto.setId("".equals(grpc.getId()) ? null : grpc.getId());
		dto.setName(grpc.getName());
		ObjectMapper mapper = new ObjectMapper();
		Properties parameters = mapper.readValue(grpc.getParameters(), Properties.class);
		dto.setParameters(parameters);
		return dto;
	}
}
