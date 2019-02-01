package com.sakura.web.question;

import com.sakura.mapper.MquestionMapper;
import com.sakura.pojo.Mquestion;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*")
public class DemoController {
@GetMapping("/test")
    public String test(){
    return "ok";
}

}
