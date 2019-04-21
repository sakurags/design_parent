package com.sakura.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sakura.mapper.PaperdetailsMapper;
import com.sakura.mapper.StudentMapper;
import com.sakura.mapper.StupaperdetailsMapper;
import com.sakura.pojo.*;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.StuView;
import com.sakura.service.StupaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                    }else {
                        stupaperdetails.setScore(0.0);
                    }
                    stupaperdetails.setQid(paperdetail.getQid());
                    stupaperdetails.setQname(paperdetail.getName());
                    stupaperdetails.setTanswer(paperdetail.getTanswer());
                    stupaperdetails.setFanswer(paperdetail.getFanswer());
                    stupaperdetails.setSanswer(answer);
                    stupaperdetails.setSid(student.getId());
                    stupaperdetails.setSname(student.getName());
                    stupaperdetails.setState(paperdetail.getState());
                    stupaperdetails.setPid(paperdetail.getPid());

                    System.out.println("得到单选题");
                    stupaperdetailsMapper.insert(stupaperdetails);

                }

            }

        }



//       得到多选题
        Map quesmap= (Map) que.get("ques");
        Set<String> quesset = quesmap.keySet();
        for (String s : quesset) {
            long id = Long.parseLong(s);
            List<String> answerList = (List) quesmap.get(s);//得到当前题目答案集合
            StringBuffer stringBuffer = new StringBuffer();
            String answer = "";
            for (String s1 : answerList) {
                stringBuffer.append(s1 + "&");
            }
            answer = stringBuffer.substring(0,stringBuffer.length()-1).toString();
            Stupaperdetails stupaperdetails = new Stupaperdetails();
            for (Paperdetails paperdetail:paperdetailsList) {
                if (id == paperdetail.getId()) {

                    String tanswer = paperdetail.getTanswer();
                    String[] split = tanswer.split("&");
                    stupaperdetails.setScore(paperdetail.getScore());
                    for (String s1 : split) {
                        if (!answerList.contains(s1)) {
                            stupaperdetails.setScore(0.0);
                            break;
                        }
                    }
                    stupaperdetails.setQid(paperdetail.getQid());
                    stupaperdetails.setQname(paperdetail.getName());
                    stupaperdetails.setTanswer(paperdetail.getTanswer());
                    stupaperdetails.setFanswer(paperdetail.getFanswer());
                    stupaperdetails.setSanswer(answer);
                    stupaperdetails.setSid(student.getId());
                    stupaperdetails.setSname(student.getName());
                    stupaperdetails.setState(paperdetail.getState());
                    stupaperdetails.setPid(paperdetail.getPid());

                    System.out.println("得到多选题");
                    stupaperdetailsMapper.insert(stupaperdetails);
                }

            }
        }

       Map tfquemap= (Map)que.get("tfque");
        Set<String> tfque= tfquemap.keySet();
        for (String key : tfque) {
            long id = Long.parseLong(key);
            String answer = (String) tfquemap.get(key);

            Stupaperdetails stupaperdetails = new Stupaperdetails();
            for (Paperdetails paperdetail:paperdetailsList) {
                if (id == paperdetail.getId()) {
                    if (answer.equals(paperdetail.getTanswer())) {
                        stupaperdetails.setScore(paperdetail.getScore());
                    }else {
                        stupaperdetails.setScore(0.0);
                    }
                    stupaperdetails.setQid(paperdetail.getQid());
                    stupaperdetails.setQname(paperdetail.getName());
                    stupaperdetails.setTanswer(paperdetail.getTanswer());
                    stupaperdetails.setFanswer(paperdetail.getFanswer());
                    stupaperdetails.setSanswer(answer);
                    stupaperdetails.setSid(student.getId());
                    stupaperdetails.setSname(student.getName());
                    stupaperdetails.setState(paperdetail.getState());
                    stupaperdetails.setPid(paperdetail.getPid());

                    System.out.println("得到判断题");
                    stupaperdetailsMapper.insert(stupaperdetails);

                }

            }

        }

/*得到填空题*/
        Map fquemap= (Map)que.get("fque");
        Set<String> fque= fquemap.keySet();
        for (String key : fque) {
            long id = Long.parseLong(key);
            String answer = (String) fquemap.get(key);

            Stupaperdetails stupaperdetails = new Stupaperdetails();
            for (Paperdetails paperdetail:paperdetailsList) {
                if (id == paperdetail.getId()) {
                    if (answer.equals(paperdetail.getTanswer())) {
                        stupaperdetails.setScore(paperdetail.getScore());
                    }else {
                        stupaperdetails.setScore(0.0);
                    }
                    stupaperdetails.setQid(paperdetail.getQid());
                    stupaperdetails.setQname(paperdetail.getName());
                    stupaperdetails.setTanswer(paperdetail.getTanswer());
                    stupaperdetails.setFanswer(paperdetail.getFanswer());
                    stupaperdetails.setSanswer(answer);
                    stupaperdetails.setSid(student.getId());
                    stupaperdetails.setSname(student.getName());
                    stupaperdetails.setState(paperdetail.getState());
                    stupaperdetails.setPid(paperdetail.getPid());

                    System.out.println("得到填空题题");
                    stupaperdetailsMapper.insert(stupaperdetails);

                }

            }

        }

        /*得到简答题*/
        Map saquemap= (Map)que.get("saque");
        Set<String> saquekey= saquemap.keySet();
        for (String key : saquekey) {
            long id = Long.parseLong(key);
            String answer = (String) saquemap.get(key);

            Stupaperdetails stupaperdetails = new Stupaperdetails();
            for (Paperdetails paperdetail:paperdetailsList) {
                if (id == paperdetail.getId()) {
                    stupaperdetails.setQid(paperdetail.getQid());
                    stupaperdetails.setQname(paperdetail.getName());
                    stupaperdetails.setTanswer(paperdetail.getTanswer());
                    stupaperdetails.setFanswer(paperdetail.getFanswer());
                    stupaperdetails.setSanswer(answer);
                    stupaperdetails.setSid(student.getId());
                    stupaperdetails.setSname(student.getName());
                    stupaperdetails.setState(paperdetail.getState());
                    stupaperdetails.setPid(paperdetail.getPid());

                    System.out.println("得到简答题题");
                    stupaperdetailsMapper.insert(stupaperdetails);
                }
                }

            }

        /*得到应用题*/
        Map aquemap= (Map)que.get("aque");
        Set<String> aquekey= aquemap.keySet();
        for (String key :aquekey) {
            long id = Long.parseLong(key);
            String answer = (String) aquemap.get(key);

            Stupaperdetails stupaperdetails = new Stupaperdetails();
            for (Paperdetails paperdetail:paperdetailsList) {
                if (id == paperdetail.getId()) {
                    stupaperdetails.setQid(paperdetail.getQid());
                    stupaperdetails.setQname(paperdetail.getName());
                    stupaperdetails.setTanswer(paperdetail.getTanswer());
                    stupaperdetails.setFanswer(paperdetail.getFanswer());
                    stupaperdetails.setSanswer(answer);
                    stupaperdetails.setSid(student.getId());
                    stupaperdetails.setSname(student.getName());
                    stupaperdetails.setState(paperdetail.getState());
                    stupaperdetails.setPid(paperdetail.getPid());

                    System.out.println("得到应用题");
                    stupaperdetailsMapper.insert(stupaperdetails);
                }
            }

        }


        return "ok";
    }

    @Override
    public EUDataGridResult getstu(Integer pageNo, Integer pageSize) {
        EUDataGridResult result = new EUDataGridResult();
        StudentExample studentExample = new StudentExample();
        PageHelper.startPage(pageNo, pageSize);
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        PageInfo pageInfo = new PageInfo<>(studentList);
        result.setData(studentList);
        result.setCount(pageInfo.getTotal());
        return result;
    }
    @Override
    public EUDataGridResult getstuRes(Integer pageNo, Integer pageSize, Long paperid) {
        EUDataGridResult result = new EUDataGridResult();
        PageHelper.startPage(pageNo, pageSize);
        List<StudentResult> studentList = studentMapper.selectResult(paperid);
        PageInfo pageInfo = new PageInfo<>(studentList);
        result.setData(studentList);
        result.setCount(pageInfo.getTotal());
        return result;
    }

    @Override
    public List<Stupaperdetails> getstuPaper(long sid, long pid) {
        StupaperdetailsExample example = new StupaperdetailsExample();
        StupaperdetailsExample.Criteria criteria = example.createCriteria();
        criteria.andStateGreaterThan(4);
        criteria.andSidEqualTo(sid);
        criteria.andPidEqualTo(pid);
        List<Stupaperdetails> stupaperdetails = stupaperdetailsMapper.selectByExample(example);

        return stupaperdetails;
    }

    @Override
    public String getScore(long id, int state) {
        PaperdetailsExample example = new PaperdetailsExample();
        PaperdetailsExample.Criteria criteria = example.createCriteria();
        criteria.andQidEqualTo(id);
        criteria.andStateEqualTo(state);
        List<Paperdetails> paperdetailsList = paperdetailsMapper.selectByExample(example);

        return paperdetailsList.get(0).getScore()+"";
    }

    @Override
    public String Stupaperdetails(List<Stupaperdetails> score) {
        for (Stupaperdetails stupaperdetails : score) {
            stupaperdetailsMapper.updateByPrimaryKeySelective(stupaperdetails);

        }
        return "ok";
    }


    @Override
    public List<StuView> getResult(String stuid, long pid) {
        StudentExample example = new StudentExample();
        example.createCriteria().andStudentidEqualTo(stuid);
        List<Student> studentList = studentMapper.selectByExample(example);
        if (studentList == null || studentList.size() > 1) {
            return null;
        }
        Student student = studentList.get(0);


        StupaperdetailsExample stupaperdetailsExample = new StupaperdetailsExample();
        StupaperdetailsExample.Criteria criteria = stupaperdetailsExample.createCriteria();
        criteria.andSidEqualTo(student.getId());
        criteria.andPidEqualTo(pid);
        List<Stupaperdetails> stupaperdetails = stupaperdetailsMapper.selectByExample(stupaperdetailsExample);

        List<StuView> list = new ArrayList<>();
        double allscore=0;
        for (Stupaperdetails studetails : stupaperdetails) {
            StuView stuView = new StuView();
            allscore = allscore + studetails.getScore();
            stuView.setId(studetails.getId());
            stuView.setQid(studetails.getQid());
            stuView.setQname(studetails.getQname());

            if (studetails.getState()==6){
                stuView.setTanswer("http://pp6b13psf.bkt.clouddn.com/"+studetails.getTanswer());
                stuView.setSanswer("http://pp6b13psf.bkt.clouddn.com/"+studetails.getSanswer());
            }else {
                stuView.setTanswer(studetails.getTanswer());
                stuView.setSanswer(studetails.getSanswer());
            }

            stuView.setSid(studetails.getSid());
            stuView.setSname(studetails.getSname());
            stuView.setScore(studetails.getScore());
            stuView.setState(studetails.getState());
            stuView.setPid(studetails.getPid());
            String fanswer = studetails.getFanswer();
            if (fanswer != null && !"".equals(fanswer)) {
                String[] split = fanswer.split("&");
                stuView.setAnswer1(split[0]);
                stuView.setAnswer2(split[1]);
                stuView.setAnswer3(split[2]);
                stuView.setAnswer4(split[3]);
            }
            list.add(stuView);
        }
        list.get(0).setAllScore(allscore);
        return list;
    }
}
