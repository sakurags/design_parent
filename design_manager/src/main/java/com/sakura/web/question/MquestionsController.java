package com.sakura.web.question;

import com.sakura.mapper.MquestionMapper;
import com.sakura.pojo.Mquestions;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*")
public class MquestionsController {
    @Autowired
    private QuestionsService questionsService;

    @GetMapping("/mques/page")
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname) {
        return questionsService.gopage(pageNo, pageSize,qname,cname);
    }

    @PostMapping("/mques/add")
    public String addForm(@RequestBody Mquestions mquestions) {
        questionsService.addmQustion(mquestions);
        return "1";
    }

    @GetMapping("/mques/getquebyid")
    public Mquestions getquebyid(Long id) {
       return questionsService.getquebyid(id);

    }


    @DeleteMapping("/mques/delete")
    public String delete(String ids) {
       return questionsService.delete(ids);

    }

    @PostMapping("/mques/addque")
    public String addque(@RequestBody PaperQue<Mquestions> paperQue){
        questionsService.addque(paperQue);
        return "1";
    }
}
