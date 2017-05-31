package com.loan.api.service.News;

import com.loan.common.beans.NewsBean;

import java.util.List;

/**
 * Created by shuttle on 5/31/17.
 */
public interface INews {
    /**
     * 分页获取新闻列表
     * @param limit
     * @param page
     * @return
     */
    public List<NewsBean> getNewsByPage(int limit, int page);

    /**
     * 根据id获取新闻信息
     * @param id
     * @return
     */
    public NewsBean getNewsById(long id);
}
