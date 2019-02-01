package com.sakura.service;

import com.sakura.pojo.Mquestion;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;

import java.util.List;

public interface QuestionService {
    EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname);

    void addmQustion(Mquestion mquestion);

    Mquestion getquebyid(Long id);

    String delete(String ids);

    void addque(PaperQue<Mquestion> paperQue);
}
