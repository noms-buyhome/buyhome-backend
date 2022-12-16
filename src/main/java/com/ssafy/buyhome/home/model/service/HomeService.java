package com.ssafy.buyhome.home.model.service;

import com.ssafy.buyhome.home.model.dao.HomeDao;
import com.ssafy.buyhome.home.model.dto.HomeInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeDao homeDao;

    public List<HomeInfo> findByDongCode(String dongCode) {
        return homeDao.findByDongCode(dongCode);
    }

    public HomeInfo getAptInfo(String aptCode){
        return homeDao.getAptInfo(aptCode);
    }
}
