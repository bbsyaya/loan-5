package com.loan.api.service.News.impl;

import com.loan.api.service.News.INews;
import com.loan.common.beans.NewsBean;
import com.loan.common.utils.CopyBeanUtils;
import com.loan.common.utils.ExceptionUtils;
import com.loan.datasource.dao.NewsDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shuttle on 5/31/17.
 */
@Service
public class NewsImpl implements INews {

    @Autowired
    private NewsDao newsDao;

    @Override
    public List<NewsBean> getNewsByPage(int limit, int page) {
        CopyBeanUtils<NewsBean> copyBeanUtils = new CopyBeanUtils<NewsBean>();
        try {
            return copyBeanUtils.copyBeanUtils(NewsBean.class, newsDao.getNewsByPager(limit, page));
        } catch (IllegalAccessException e) {
            ExceptionUtils.printException("getNewsByPage出错：", e);
        } catch (InstantiationException e) {
            ExceptionUtils.printException("getNewsByPage出错：", e);
        }
        return null;
    }

    @Override
    public NewsBean getNewsById(long id) {
        NewsBean bean = new NewsBean();
        BeanUtils.copyProperties(newsDao.getNewsDetail(id), bean);
        return bean;
    }
}
