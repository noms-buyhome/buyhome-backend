package com.ssafy.buyhome.home.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@Data
public class HomeInfo {
    private int aptCode;
    private String AptName;
    private int buildYear;
    private String dongCode;
    private String dongName;
    private String img;
    private String jibun;
    private String lat;
    private String lng;

}
