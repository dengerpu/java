package com.ep.service;

import com.ep.domain.Notice;
import com.ep.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoticeService {
    /*
     * 保存文章
     * */
    public void saveNotice(Notice notice);


    /*
     * 查找所用文章
     * */
    public List<Notice> findAllNotice(String query, int pagenum, int pagesize);

    /*
     * 查询文章总数
     * */
    public int findTotalNotice(String query);

    /*
    * 根据tid查找文章
    * */
    public List<Notice> findNoticeByTid(int tid,String query, int pagenum, int pagesize);

    /*
     * 根据tid查询文章总数
     * */
    public int findTotalNoticeByTid(String query,int tid);

    /*
     * 根据id查找文章
     * */
    public Notice findNoticeById(int id);

    /*
     * 根据id删除文章
     * */
    public void deleteNoticeById(int id);

    /**
     * 更新文章
     * */
    public void updateStudentById(Notice notice);


}
