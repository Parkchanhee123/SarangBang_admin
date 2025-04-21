package edu.sm.app.repository;

import edu.sm.app.dto.CartDto;
import edu.sm.app.frame.SmRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CartRepository extends SmRepository<CartDto, CartDto> {
//    List<CartDto> findByName(String itemName);
}
