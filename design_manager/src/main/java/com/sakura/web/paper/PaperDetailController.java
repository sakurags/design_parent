package com.sakura.web.paper;

import com.sakura.pojo.Mquestion;
import com.sakura.pojo.Paperdetails;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.service.PaperDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class PaperDetailController {
    @Autowired
    private PaperDetailService paperDetailService;
   
    @GetMapping("/pdet/page")
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname,Long pid) {
        return paperDetailService.gopage(pageNo, pageSize,qname,cname,pid);
    }

    @PostMapping("/pdet/add")
    public String addForm(@RequestBody Paperdetails paperdetails) {
        paperDetailService.addpaperdetails(paperdetails);
        return "1";
    }

    @GetMapping("/pdet/getquebyid")
    public Paperdetails getquebyid(Long id) {
       return paperDetailService.getquebyid(id);

    }


    @DeleteMapping("/pdet/delete")
    public String delete(String ids) {
       return paperDetailService.delete(ids);

    }

    @GetMapping("/pdet/getpaperdetaile")
    public List getpaperdetaile(String paperid) {
        return paperDetailService.getpaperdetaile(Long.parseLong(paperid));
    }


}
