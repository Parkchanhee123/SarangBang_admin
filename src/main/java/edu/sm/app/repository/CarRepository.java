package edu.sm.app.repository;

import com.github.pagehelper.Page;
import edu.sm.app.dto.CarDto;
import edu.sm.app.dto.CustDto;
import edu.sm.app.dto.Search;
import edu.sm.app.frame.SmRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CarRepository extends SmRepository<Integer, CarDto> {
    List<CarDto> findByName(String Name);
    Page<CustDto> getpage() throws Exception;
    Page<CustDto> getfindpage(Search search) throws Exception;
}
