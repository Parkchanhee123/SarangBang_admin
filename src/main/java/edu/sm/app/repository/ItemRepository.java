package edu.sm.app.repository;

import edu.sm.app.dto.ItemDto;
import edu.sm.app.frame.SmRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemRepository extends SmRepository<Integer, ItemDto> {
    List<ItemDto> findByName(String itemName);

}
