package com.ep.service.impl;

import com.ep.domain.Notice;
import com.ep.mapper.NoticeMapper;
import com.ep.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    /*
    * 保存文章
    * */
    @Override
    public void saveNotice(Notice notice) {
        noticeMapper.saveNotice(notice);
    }
    /*
    * 查找文章
    * */
    @Override
    public List<Notice> findAllNotice(String query, int pagenum, int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<Notice> notice = noticeMapper.findNotice(query, start, pagesize);
        return notice;
    }

    /*
    * 查找文章总数
    * */
    @Override
    public int findTotalNotice(String query) {
        int totalNotice = noticeMapper.findTotalNotice(query);
        return totalNotice;
    }

    /*
    * 根据tid查找文章
    * */
    @Override
    public List<Notice> findNoticeByTid(int tid,String query, int pagenum, int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<Notice> noticeByTid = noticeMapper.findNoticeByTid(tid,query, start, pagesize);
        return noticeByTid;
    }

    /*
    * 根据tid查找文章总数
    * */
    @Override
    public int findTotalNoticeByTid(String query, int tid) {
        int totalNoticeByTid = noticeMapper.findTotalNoticeByTid(query, tid);
        return totalNoticeByTid;
    }

    /*
    * 根据id查找文章
    * */
    @Override
    public Notice findNoticeById(int id) {
        Notice noticeById = noticeMapper.findNoticeById(id);
        return noticeById;
    }

    /*
    * 根据id文章
    * */
    @Override
    public void deleteNoticeById(int id) {
        noticeMapper.deleteNoticeById(id);
    }

    /*
    * 根据id更新文章
    * */
    @Override
    public void updateStudentById(Notice notice) {
        noticeMapper.updateNoticeById(notice);
    }
}
