package edu.sm.app.repository;

import edu.sm.app.dto.CustDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustRepository extends MongoRepository<CustDto, String> {
    List<CustDto> findByUserUuid(String user_uuid);
    List<CustDto> findByUserFamilyEmail(String user_family_email);
}
