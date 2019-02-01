package com.sakura.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sakura.mapper.PapersMapper;
import com.sakura.mapper.ScmidMapper;
import com.sakura.mapper.StudentMapper;
import com.sakura.pojo.*;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PapersView;
import com.sakura.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaperServiceimpl implements PaperService {
    @Autowired
    private PapersMapper papersMapper;
    @Autowired
    private ScmidMapper scmidMapper;
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname) {
        EUDataGridResult result = new EUDataGridResult();
        PapersExample example = new PapersExample();
        PapersExample.Criteria criteria = example.createCriteria();
        if (!"".equals(qname)&&qname!=null)
            criteria.andNameLike("%"+qname+"%");
        if (!"".equals(cname)&&cname!=null)
            criteria.andCnameLike("%"+cname+"%");
        PageHelper.startPage(pageNo,pageSize);
        List<Papers> list = papersMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo<>(list);
        result.setData(list);
        result.setCount(pageInfo.getTotal());
        return result;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void addpapers(Papers papers) {
        papers.setState(1);
        if (papers.getId()!=null){
            papersMapper.updateByPrimaryKeySelective(papers);
        }else {
            papers.setAdddate(new Date());
            papersMapper.insert(papers);
        }
    }

    @Override
    public Papers getquebyid(Long id) {
        Papers papers = papersMapper.selectByPrimaryKey(id);

        return papers;
    }

    @Override
    public String delete(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            if (!"".equals(s))
            papersMapper.deleteByPrimaryKey(Long.parseLong(s));

        }
        return "1";
    }


    @Override
    public List getAllPaper() {
        List<PapersView> list = new ArrayList<>();
        PapersExample example = new PapersExample();
        List<Papers> papersList = papersMapper.selectByExample(example);
        for (Papers papers : papersList) {
            PapersView papersView = new PapersView();
            papersView.setValue(papers.getId());
            papersView.setLabel(papers.getName());
            list.add(papersView);
        }
        return list;

    }

    @Override
    public List searchpaper(String user) {
        List list = new ArrayList();
        StudentExample studentExample = new StudentExample();
        if (user!=null&&"".equals(user))
            studentExample.createCriteria().andStudentidEqualTo(user);
        List<Student> students = studentMapper.selectByExample(studentExample);
        Student student = students.get(0);
        ScmidExample scmidExample = new ScmidExample();
        scmidExample.createCriteria().andSidEqualTo(student.getId());
        List<Scmid> scmids = scmidMapper.selectByExample(scmidExample);
        for (Scmid scmid : scmids) {
            PapersExample example = new PapersExample();
            PapersExample.Criteria criteria = example.createCriteria();
            criteria.andCidEqualTo(scmid.getCid());
            criteria.andStateEqualTo(2);
            List<Papers> papers = papersMapper.selectByExample(example);
            list.addAll(papers);

        }
        return list;
    }
}
