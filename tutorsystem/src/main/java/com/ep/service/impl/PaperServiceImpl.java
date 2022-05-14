package com.ep.service.impl;

import com.ep.domain.Paper;
import com.ep.mapper.PaperMapper;
import com.ep.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    /*
    * 保存论文
    * */
    @Override
    public void savePaper(Paper paper) {
        paperMapper.savePaper(paper);
    }

    /*
    * 查找所有论文
    * */
    @Override
    public List<Paper> findAllPaper(String query, int pagenum, int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<Paper> paper = paperMapper.findPaper(query, start, pagesize);
        return paper;
    }

    /*
    * 查找论文数量
    * */
    @Override
    public int findTotalPaper(String query) {
        int totalPaper = paperMapper.findTotalPaper(query);
        return totalPaper;
    }

    /*
    * 根据sid查找论文
    * */
    @Override
    public List<Paper> findPaperBySid(int sid, String query, int pagenum, int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<Paper> paperBySid = paperMapper.findPaperBySid(sid, query, start, pagesize);
        return paperBySid;
    }

    /*
    * 查找sid论文的总数量
    * */
    @Override
    public int findTotalPaperBySid(String query, int sid) {
        int totalPaperBySid = paperMapper.findTotalPaperBySid(query, sid);
        return totalPaperBySid;
    }

    /*
    * 根据id查找论文
    * */
    @Override
    public Paper findPaperById(int id) {
        Paper paperById = paperMapper.findPaperById(id);
        return paperById;
    }

    /*
    * 根据id删除论文
    * */
    @Override
    public void deletePaperById(int id) {
        paperMapper.deletePaperById(id);
    }

    /*
    * 更新论文
    * */
    @Override
    public void updatePaperById(Paper paper) {
        paperMapper.updatePaperById(paper);
    }

    /*
    * 根据tid查找论文
    * */
    @Override
    public List<Paper> findPaperByTid(String query, int pagenum, int pagesize, int tid) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<Paper> paperBytid = paperMapper.findPaperBytid(query, pagenum, pagesize, tid);
        return paperBytid;
    }

    @Override
    public int findTotalByTid(String query, int tid) {
        int totalBytid = paperMapper.findTotalBytid(query, tid);
        return totalBytid;
    }
}
