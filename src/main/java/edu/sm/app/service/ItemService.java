package edu.sm.app.service;

import edu.sm.app.dto.ItemDto;
import edu.sm.app.frame.SmService;
import edu.sm.app.repository.ItemRepository;
import edu.sm.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements SmService<Integer, ItemDto> {

    final ItemRepository itemRepository;

    @Value("${app.dir.uploaddir}")
    String imgdir;

    @Override
    public void add(ItemDto itemDto) throws Exception {
        FileUploadUtil.saveFile(itemDto.getImage(), imgdir);
        itemRepository.insert(itemDto);
    }

    @Override
    public void modify(ItemDto itemDto) throws Exception {
        if (itemDto.getImage().isEmpty()) {
            itemRepository.update(itemDto);
        } else {
            String oldimg = itemDto.getImgName();
            itemDto.setImgName(itemDto.getImage().getOriginalFilename());
            itemRepository.update(itemDto);

            FileUploadUtil.saveFile(itemDto.getImage(), imgdir);
            FileUploadUtil.deleteFile(oldimg, imgdir);
        }
    }

    @Override
    public void delete(Integer integer) throws Exception {
        // 이미지 삭제 이후 (로컬 디렉토리)
        String imgname =itemRepository.selectOne(integer).getImgName();
        FileUploadUtil.deleteFile(imgname, imgdir);
        // db에서 삭제
        itemRepository.delete(integer);
    }

    @Override
    public ItemDto get(Integer integer) throws Exception {
        return itemRepository.selectOne(integer);
    }

    @Override
    public List<ItemDto> get() throws Exception {
        return itemRepository.select();
    }
}
