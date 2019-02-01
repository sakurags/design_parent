package com.sakura.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sakura.mapper.FquestionMapper;
import com.sakura.mapper.PaperdetailsMapper;
import com.sakura.pojo.Fquestion;
import com.sakura.pojo.FquestionExample;
import com.sakura.pojo.Paperdetails;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.service.FquestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class FquestionServiceimpl implements FquestionService {
    @Autowired
    private FquestionMapper fquestionMapper;
    @Autowired
    private PaperdetailsMapper paperdetailsMapper;
    @Override
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname) {
        EUDataGridResult result = new EUDataGridResult();
        FquestionExample example = new FquestionExample();
        FquestionExample.Criteria criteria = example.createCriteria();
        if (!"".equals(qname)&&qname!=null)
            criteria.andNameLike("%"+qname+"%");
        if (!"".equals(cname)&&cname!=null)
            criteria.andCnameLike("%"+cname+"%");
        PageHelper.startPage(pageNo,pageSize);
        List<Fquestion> list = fquestionMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo<>(list);
        result.setData(list);
        result.setCount(pageInfo.getTotal());
        return result;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void addmQustion(Fquestion fquestion) {
        if (fquestion.getId()!=null){
            fquestionMapper.updateByPrimaryKeySelective(fquestion);
        }else {
            fquestion.setAdddate(new Date());
            fquestionMapper.insert(fquestion);
        }
    }

    @Override
    public Fquestion getquebyid(Long id) {
        Fquestion fquestion = fquestionMapper.selectByPrimaryKey(id);

        return fquestion;
    }

    @Override
    public String delete(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            if (!"".equals(s))
            fquestionMapper.deleteByPrimaryKey(Long.parseLong(s));

        }
        return "1";
    }

    @Override
    public void addque(PaperQue<Fquestion> paperQue) {
        List<Fquestion> list = paperQue.getList();
        for (Fquestion mquestion : list) {
            Paperdetails paperdetails = new Paperdetails();
            paperdetails.setQid(mquestion.getId());
            paperdetails.setName(mquestion.getName());
            paperdetails.setTanswer(mquestion.getTanswer());

            paperdetails.setCid(mquestion.getCid());
            paperdetails.setCname(mquestion.getCname());
            paperdetails.setScore(mquestion.getScore());
            paperdetails.setAdddate(mquestion.getAdddate());
            paperdetails.setState(4);
            paperdetails.setPid(paperQue.getPid());
            paperdetails.setPname(paperQue.getPname());
            paperdetailsMapper.insert(paperdetails);

        }

    }

}
