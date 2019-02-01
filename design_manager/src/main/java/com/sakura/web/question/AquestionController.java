package com.sakura.web.question;

import com.sakura.pojo.Aquestion;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.service.AquestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*")
public class AquestionController {
    @Autowired
    private AquestionService aquestionService;
   
    @GetMapping("/aque/page")
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname) {
        return aquestionService.gopage(pageNo, pageSize,qname,cname);
    }

    @PostMapping("/aque/add")
    public String addForm(@RequestBody Aquestion aquestion) {
        aquestionService.addmQustion(aquestion);
        return "1";
    }

    @GetMapping("/aque/getquebyid")
    public Aquestion getquebyid(Long id) {
       return aquestionService.getquebyid(id);

    }


    @DeleteMapping("/aque/delete")
    public String delete(String ids) {
       return aquestionService.delete(ids);

    }
    @PostMapping("/aque/addque")
    public String addque(@RequestBody PaperQue<Aquestion> paperQue){
        aquestionService.addque(paperQue);
        return "1";
    }

}
