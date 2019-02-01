package com.sakura.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sakura.mapper.PaperdetailsMapper;
import com.sakura.mapper.TfquestionMapper;
import com.sakura.pojo.Paperdetails;
import com.sakura.pojo.Tfquestion;
import com.sakura.pojo.TfquestionExample;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.service.TfquestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TfquestionServiceimpl implements TfquestionService {
    @Autowired
    private TfquestionMapper tfquestionMapper;
    @Autowired
    private PaperdetailsMapper paperdetailsMapper;
    @Override
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname) {
        EUDataGridResult result = new EUDataGridResult();
        TfquestionExample example = new TfquestionExample();
        TfquestionExample.Criteria criteria = example.createCriteria();
        if (!"".equals(qname)&&qname!=null)
            criteria.andNameLike("%"+qname+"%");
        if (!"".equals(cname)&&cname!=null)
            criteria.andCnameLike("%"+cname+"%");
        PageHelper.startPage(pageNo,pageSize);
        List<Tfquestion> list = tfquestionMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo<>(list);
        result.setData(list);
        result.setCount(pageInfo.getTotal());
        return result;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void addmQustion(Tfquestion mquestion) {
        if (mquestion.getId()!=null){
            tfquestionMapper.updateByPrimaryKeySelective(mquestion);
        }else {
            mquestion.setAdddate(new Date());
            tfquestionMapper.insert(mquestion);
        }
    }

    @Override
    public Tfquestion getquebyid(Long id) {
        Tfquestion mquestion = tfquestionMapper.selectByPrimaryKey(id);

        return mquestion;
    }

    @Override
    public String delete(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            if (!"".equals(s))
            tfquestionMapper.deleteByPrimaryKey(Long.parseLong(s));

        }
        return "1";
    }

    @Override
    public void addque(PaperQue<Tfquestion> paperQue) {
        List<Tfquestion> list = paperQue.getList();
        for (Tfquestion mquestion : list) {
            Paperdetails paperdetails = new Paperdetails();
            paperdetails.setQid(mquestion.getId());
            paperdetails.setName(mquestion.getName());
            paperdetails.setTanswer(mquestion.getTanswer());
            paperdetails.setCid(mquestion.getCid());
            paperdetails.setCname(mquestion.getCname());
            paperdetails.setScore(mquestion.getScore());
            paperdetails.setAdddate(mquestion.getAdddate());
            paperdetails.setState(3);
            paperdetails.setPid(paperQue.getPid());
            paperdetails.setPname(paperQue.getPname());
            paperdetailsMapper.insert(paperdetails);

        }

    }

}
