package edu.sm.app.repository;


import edu.sm.app.dto.AdminDto;
import edu.sm.app.frame.SmRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface AdminRepository extends SmRepository<String, AdminDto> {
}