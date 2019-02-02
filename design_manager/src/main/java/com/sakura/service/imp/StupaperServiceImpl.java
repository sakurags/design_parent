package com.sakura.service.imp;

import com.sakura.mapper.PaperdetailsMapper;
import com.sakura.mapper.StudentMapper;
import com.sakura.mapper.StupaperdetailsMapper;
import com.sakura.pojo.*;
import com.sakura.service.StupaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class StupaperServiceImpl implements StupaperService {
    @Autowired
    private PaperdetailsMapper paperdetailsMapper;
    @Autowired
    private StupaperdetailsMapper stupaperdetailsMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String adddetails(Map que) {
//        得到试卷的id
        Long paperid = Long.parseLong((String) que.get("paperid"));
//        根据id得到试卷详情
        PaperdetailsExample paperdetailsExample = new PaperdetailsExample();
        paperdetailsExample.createCriteria().andPidEqualTo(paperid);
        List<Paperdetails> paperdetailsList = paperdetailsMapper.selectByExample(paperdetailsExample);


//      得到用户
        String uid = (String) que.get("uid");
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStudentidEqualTo(uid);
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        Student student = studentList.get(0);


//       得到单选题
        Map quemap= (Map) que.get("que");
        Set<String> set = quemap.keySet();
        for (String s : set) {
            long id = Long.parseLong(s);
            String answer = (String) quemap.get(s);

            Stupaperdetails stupaperdetails = new Stupaperdetails();
            for (Paperdetails paperdetail:paperdetailsList) {
                if (id == paperdetail.getId()) {
                    if (answer.equals(paperdetail.getTanswer())) {
                        stupaperdetails.setScore(paperdetail.getScore());
                    }
                }

            }

        }






       /* Set<String> set = que.keySet();
        for (String s : set) {

            String value = (String) que.get(s);
            System.out.println(s);
        }*/
        return "ok";
    }
}
