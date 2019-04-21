package com.sakura.service;

import com.sakura.pojo.Stupaperdetails;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.StuView;

import java.util.List;
import java.util.Map;

public interface StupaperService {
    String adddetails(Map que);

    EUDataGridResult getstu(Integer pageNo, Integer pageSize);

    List<Stupaperdetails> getstuPaper(long sid, long pid);

    String getScore(long id, int state);

    String Stupaperdetails(List<Stupaperdetails> score);

    EUDataGridResult getstuRes(Integer pageNo, Integer pageSize, Long paperid);

    List<StuView> getResult(String stuid, long pid);
}
