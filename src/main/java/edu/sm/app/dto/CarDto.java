package edu.sm.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CarDto {

    private int carId;           // 차 ID (자동 증가)
    private String carName;       // 차 이름 (필수 입력)
    private String carModel;      // 차 모델 (선택 입력)
    private long carPrice;        // 차 가격 (선택 입력)
    private LocalDateTime regDate;       // 등록 일자 (필수 입력)

    public String getFormattedRegDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return regDate.format(formatter);
    }
}
