package com.sakura.web.question;

import com.sakura.mapper.MquestionMapper;
import com.sakura.pojo.Fquestion;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.service.FquestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*")
public class FquestionController {
    @Autowired
    private FquestionService fquestionService;
   
    @GetMapping("/fque/page")
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname) {
        return fquestionService.gopage(pageNo, pageSize,qname,cname);
    }

    @PostMapping("/fque/add")
    public String addForm(@RequestBody Fquestion fquestion) {
        fquestionService.addmQustion(fquestion);
        return "1";
    }

    @GetMapping("/fque/getquebyid")
    public Fquestion getquebyid(Long id) {
       return fquestionService.getquebyid(id);

    }


    @DeleteMapping("/fque/delete")
    public String delete(String ids) {
       return fquestionService.delete(ids);

    }

    @PostMapping("/fque/addque")
    public String addque(@RequestBody PaperQue<Fquestion> paperQue){
        fquestionService.addque(paperQue);
        return "1";
    }
}
