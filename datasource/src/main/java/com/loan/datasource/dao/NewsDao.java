package com.loan.datasource.dao;

import com.loan.datasource.entities.News;
import com.loan.datasource.mappers.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shuttle on 5/31/17.
 */
@Repository
public class NewsDao {
    @Autowired
    public NewsMapper newsMapper;

    public List<News> getNewsByPager(int limit, int page){
        return newsMapper.selectByPage(limit, page);
    }

    public News getNewsDetail(long id){
        return newsMapper.selectById(id);
    }
}
