package edu.sm.app.service;

import edu.sm.app.dto.AdminDto;
import edu.sm.app.frame.SmService;
import edu.sm.app.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService implements SmService<String, AdminDto> {

    private final AdminRepository adminRepository;

    @Override
    public void add(AdminDto adminDto) throws Exception {

    }

    @Override
    public void modify(AdminDto adminDto) throws Exception {

    }

    @Override
    public void delete(String string) throws Exception {

    }

    @Override
    public AdminDto get(String string) throws Exception {
        return adminRepository.selectOne(string);
    }

    @Override
    public List<AdminDto> get() throws Exception {
        return adminRepository.select();
    }
}
