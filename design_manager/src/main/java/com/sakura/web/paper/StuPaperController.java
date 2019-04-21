package com.sakura.web.paper;

import com.sakura.pojo.Papers;
import com.sakura.pojo.Student;
import com.sakura.pojo.Stupaperdetails;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.StuView;
import com.sakura.service.PaperService;
import com.sakura.service.StupaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/stupaper")
public class StuPaperController {

    @Autowired
    private StupaperService stupaperService;

/*添加题目*/
    @PostMapping("/add")
    public String add(@RequestBody Map que){
        return stupaperService.adddetails(que);
    }

    /*查找所有学生，用于批改主观题*/
    @GetMapping("/getstu")
    public EUDataGridResult getStudent(Integer pageNo, Integer pageSize){
        return stupaperService.getstu(pageNo,pageSize);
    }
  /*查找所有学生的成绩并显示*/
    @GetMapping("/getstuRes")
    public EUDataGridResult getstuRes(Integer pageNo, Integer pageSize,Long paperid){
        return stupaperService.getstuRes(pageNo,pageSize,paperid);
    }

    @GetMapping("/getstuPaper")
    public List<Stupaperdetails> getstuPaper(long sid, long pid){
        return stupaperService.getstuPaper(sid, pid);

    }

    @GetMapping("/getscore")
    public String getScore(long id, int state) {
        return stupaperService.getScore(id, state);
    }

@PostMapping("/submitscore")
    public String submitscore(@RequestBody List<Stupaperdetails> score) {
    return stupaperService.Stupaperdetails(score);
}

    @GetMapping("/getResult")
    public List<StuView> getResult(String stuid, long pid) {
        return stupaperService.getResult(stuid,pid);
    }
}
