package iochti.processRuleType.repository;

import iochti.processRuleType.document.ProcessRuleTypeDocument;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcessRuleTypeRepository extends MongoRepository<ProcessRuleTypeDocument, String> {
	
}
