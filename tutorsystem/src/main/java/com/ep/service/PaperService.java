package com.ep.service;

import com.ep.domain.Notice;
import com.ep.domain.Paper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaperService {
    /*
     * 保存论文
     * */
    public void savePaper(Paper paper);


    /*
     * 查找所用论文
     * */
    public List<Paper> findAllPaper(String query, int pagenum, int pagesize);

    /*
     * 查询论文总数
     * */
    public int findTotalPaper(String query);

    /*
     * 根据sid查找论文
     * */
    public List<Paper> findPaperBySid(int sid,String query, int pagenum, int pagesize);

    /*
     * 根据sid查询论文总数
     * */
    public int findTotalPaperBySid(String query,int sid);

    /*
     * 根据id查找论文
     * */
    public Paper findPaperById(int id);

    /*
     * 根据id删除文章
     * */
    public void deletePaperById(int id);

    /**
     * 更新论文
     * */
    public void updatePaperById(Paper paper);

    /*
    * 根据tid查找论文
    * */
    public List<Paper> findPaperByTid(String query, int pagenum, int pagesize,int tid);

    /*
    * 根据tid查找论文总数
    * */
    public int findTotalByTid(String query,int tid);
}
