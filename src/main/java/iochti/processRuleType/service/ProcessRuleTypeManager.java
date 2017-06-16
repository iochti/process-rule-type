package iochti.processRuleType.service;

import iochti.processRuleType.document.ProcessRuleDocumentAdapter;
import iochti.processRuleType.document.ProcessRuleTypeDocument;
import iochti.processRuleType.dto.ProcessRuleTypeDTO;
import iochti.processRuleType.repository.ProcessRuleTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessRuleTypeManager {

	@Autowired
	ProcessRuleTypeRepository repository;

	@Autowired
	ProcessRuleDocumentAdapter documentAdapter;

	/**
	 * Find a process rule type by its id
	 * 
	 * @param id
	 *            The process rule type id
	 * @return The process rule type
	 */
	public ProcessRuleTypeDTO findById(String id) {
		ProcessRuleTypeDocument document = repository.findOne(id);
		ProcessRuleTypeDTO dto = documentAdapter.buildDTO(document);

		return dto;
	}

	/**
	 * Create or update a process rule type
	 * 
	 * @param dto
	 *            The data transfer object to save or update
	 * @return The saved or updated data transfer object
	 */
	public ProcessRuleTypeDTO save(ProcessRuleTypeDTO dto) {
		ProcessRuleTypeDocument document = documentAdapter.buildDocument(dto);
		ProcessRuleTypeDocument savedDocument = repository.save(document);
		ProcessRuleTypeDTO savedDto = documentAdapter.buildDTO(savedDocument);

		return savedDto;
	}

	/**
	 * Delete a process rule type
	 * 
	 * @param id
	 *            The id a the process rule type to delete
	 */
	public void delete(String id) {
		repository.delete(id);
	}
}
