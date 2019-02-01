package com.sakura.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sakura.mapper.PaperdetailsMapper;
import com.sakura.pojo.Mquestion;
import com.sakura.pojo.Paperdetails;
import com.sakura.pojo.PaperdetailsExample;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.pojo.utils.Paperstu;
import com.sakura.service.PaperDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaperDetailServiceimpl implements PaperDetailService {
    @Autowired
    private PaperdetailsMapper paperdetailsMapper;
    @Override
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize, String qname, String state, Long pid) {
        EUDataGridResult result = new EUDataGridResult();
        PaperdetailsExample example = new PaperdetailsExample();
        PaperdetailsExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("state asc");
       if (pid!=null&&!"".equals(pid))
           criteria.andPidEqualTo(pid);
        if (!"".equals(qname)&&qname!=null)
            criteria.andNameLike("%"+qname+"%");
        if (!"".equals(state)&&state!=null)
            criteria.andStateEqualTo(Integer.parseInt(state));
        PageHelper.startPage(pageNo,pageSize);
        List<Paperdetails> list = paperdetailsMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo<>(list);
        result.setData(list);
        result.setCount(pageInfo.getTotal());
        return result;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void addpaperdetails(Paperdetails mquestion) {
        if (mquestion.getId()!=null){
            paperdetailsMapper.updateByPrimaryKeySelective(mquestion);
        }else {
            mquestion.setAdddate(new Date());
            paperdetailsMapper.insert(mquestion);
        }
    }

    @Override
    public Paperdetails getquebyid(Long id) {
        Paperdetails mquestion = paperdetailsMapper.selectByPrimaryKey(id);

        return mquestion;
    }

    @Override
    public String delete(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            if (!"".equals(s))
            paperdetailsMapper.deleteByPrimaryKey(Long.parseLong(s));
        }
        return "1";
    }

    @Override
    public List getpaperdetaile(Long paperid) {
        List list = new ArrayList();
        PaperdetailsExample example = new PaperdetailsExample();
        example.createCriteria().andPidEqualTo(paperid);
        List<Paperdetails> paperdetailsList = paperdetailsMapper.selectByExample(example);
        for (Paperdetails paperdetails : paperdetailsList) {
            Paperstu paperstu = new Paperstu();
            String fanswer = paperdetails.getFanswer();
            if (fanswer != null && !"".equals(fanswer)) {
                String[] split = fanswer.split("&");
                paperstu.setAnswer1(split[0]);
                paperstu.setAnswer2(split[1]);
                paperstu.setAnswer3(split[2]);
                paperstu.setAnswer4(split[3]);
            }
            paperstu.setId(paperdetails.getId());
            paperstu.setQid(paperdetails.getQid());
            paperstu.setName(paperdetails.getName());
            paperstu.setTanswer(paperdetails.getTanswer());

            paperstu.setCid(paperdetails.getCid());
            paperstu.setCname(paperdetails.getCname());
            paperstu.setScore(paperdetails.getScore());
            paperstu.setAdddate(paperdetails.getAdddate());
            paperstu.setState(paperdetails.getState());
            paperstu.setPid(paperdetails.getPid());
            paperstu.setPname(paperdetails.getPname());

            list.add(paperstu);
        }
        return list;
    }
}
