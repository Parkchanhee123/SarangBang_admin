package edu.sm.app.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.sm.app.dto.CustDto;
import edu.sm.app.dto.Search;
import edu.sm.app.frame.SmService;
import edu.sm.app.repository.CustRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustService implements SmService<String, CustDto> {

    final CustRepository custRepository;

    @Override
    public void add(CustDto custDto) throws Exception {
        custRepository.insert(custDto);
    }

    @Override
    public void modify(CustDto custDto) throws Exception {
        custRepository.update(custDto);
    }

    @Override
    public void delete(String s) throws Exception {
        custRepository.delete(s);
    }

    @Override
    public CustDto get(String s) throws Exception {
        return custRepository.selectOne(s);
    }

    @Override
    public List<CustDto> get() throws Exception {
        return custRepository.select();
    }

    public List<CustDto> findByName(String name) throws Exception {
        return custRepository.findByName(name);
    }

    // pagehelper
    public Page<CustDto> getPage(int pageNo) throws Exception {
        PageHelper.startPage(pageNo, 5); // 3: 한화면에 출력되는 개수
        return custRepository.getpage();    // custdto를 page에 담아오는거
    }

    // pagehelper
    public Page<CustDto> getFindPage(int pageNo, Search search) throws Exception {
        PageHelper.startPage(pageNo, 3); // 3: 한화면에 출력되는 개수
        return custRepository.getfindpage(search);
    }
}
