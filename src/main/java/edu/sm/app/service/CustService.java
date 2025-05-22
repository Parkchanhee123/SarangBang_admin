package edu.sm.app.service;

import edu.sm.app.dto.CustDto;
import edu.sm.app.repository.CustRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustService {

    final CustRepository custRepository;

    public CustDto add(CustDto custDto) {
        return custRepository.save(custDto);
    }

    public CustDto modify(CustDto custDto) {
        return custRepository.save(custDto); // save()는 존재하면 update로 작동
    }

    public void delete(String id) {
        custRepository.deleteById(id);
    }

    public CustDto get(String id) {
        Optional<CustDto> result = custRepository.findById(id);
        return result.orElse(null);
    }

    public List<CustDto> getAll() {
        List<CustDto> list = custRepository.findAll();
        System.out.println("========== [MongoDB 조회 결과] ==========");
        System.out.println("총 사용자 수: " + list.size());
        for (CustDto dto : list) {
            System.out.println(dto.toString());
        }
        System.out.println("=========================================");
        return list;
    }


    public List<CustDto> findByUserFamilyEmail(String email) {
        return custRepository.findByUserFamilyEmail(email);
    }

    public Page<CustDto> getPage(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return custRepository.findAll(pageable);
    }

}
