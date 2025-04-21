package edu.sm.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private String cartUserId;
    private int cartItemId;
    private int cartCount;
    private LocalDateTime cartRegDate;

    // 이번에는 객체를 주입하지 말고 개별 컬럼 넣어줌
    // private ItemDto itemdto;
    private String itemName;
    private String itemPrice;
    private String imgName;
}