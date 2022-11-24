package com.ssafy.buyhome.home.model.dao;

import com.ssafy.buyhome.home.model.dto.HomeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeDao {

    List<HomeInfo> findByDongCode(String dongCode);
    HomeInfo getAptInfo(String aptCode);
}
