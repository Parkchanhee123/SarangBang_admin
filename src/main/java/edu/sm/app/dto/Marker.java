package edu.sm.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data                   // getter, setter, tostring 작성해줌
@AllArgsConstructor
@Slf4j
@Builder
public class Marker {
    private double lat;
    private double lng;
    private String title;
    private String img;
    private int code;
}
