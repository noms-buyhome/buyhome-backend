package com.ssafy.buyhome.home.model.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Deal {
    private int dealYear;
    private int dealMonth;
    private int dealDay;
    private String dealAmount;
    private String floor;
    private String area;
}
