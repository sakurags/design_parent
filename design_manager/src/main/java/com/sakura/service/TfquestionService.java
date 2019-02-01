package com.sakura.service;

import com.sakura.pojo.Tfquestion;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;

public interface TfquestionService {
    EUDataGridResult gopage(Integer pageNo, Integer pageSize, String qname, String cname);

    void addmQustion(Tfquestion tfquestion);

    Tfquestion getquebyid(Long id);

    String delete(String ids);
    void addque(PaperQue<Tfquestion> paperQue);

}
