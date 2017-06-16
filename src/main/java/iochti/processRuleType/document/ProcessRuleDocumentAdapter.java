package iochti.processRuleType.document;

import iochti.processRuleType.dto.ProcessRuleTypeDTO;

import org.springframework.stereotype.Service;

@Service
public class ProcessRuleDocumentAdapter {
	
	public ProcessRuleTypeDTO buildDTO(ProcessRuleTypeDocument document) {
		ProcessRuleTypeDTO result = new ProcessRuleTypeDTO();
		result.setId(document.getId());
		result.setName(document.getName());
		result.setParameters(document.getParameters());
		
		return result;
	}
	
	public ProcessRuleTypeDocument buildDocument(ProcessRuleTypeDTO dto) {
		ProcessRuleTypeDocument result = new ProcessRuleTypeDocument();
		result.setId(dto.getId());
		result.setName(dto.getName());
		result.setParameters(dto.getParameters());
		
		return result;
	}
}
