package com.loan.api.controller;

import com.loan.api.consts.Constants;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * Created by shuttle on 5/31/17.
 */
@RestController
@RequestMapping(Constants.BASE_URL + "/news")
@Api(description = "新闻相关")
public class NewsController extends BaseController {

//    @Autowired
//    private INews news;
//
//    /**
//     * 获取新闻列表
//     * @return
//     */
//    @ApiOperation(value = "获取新闻列表", notes = "获取新闻列表", response = NewsBean.class)
//    @RequestMapping(value = "/getNewsList", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
//    public Result<List<NewsBean>> getIndexModule(@ModelAttribute PageParam pageParam,
//                                                                HttpServletRequest request, HttpServletResponse response){
//        try {
//            List<NewsBean> beanList = news.getNewsByPage(pageParam.getPageNum(), pageParam.getPageSize());
//            return successResult(beanList);
//        }catch (Exception e){
//            ExceptionUtils.printException("getIndexModule controller报错：", e);
//            return failResult(e);
//
//        }
//
//    }
//
//    /**
//     * 获取某一条新闻记录
//     * @return
//     */
//    @ApiOperation(value = "根据id获取新闻内容", notes = "根据id获取新闻内容", response = NewsBean.class)
//    @RequestMapping(value = "/getNewsById/{id}", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
//    public Result<NewsBean> getIndexModule(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response){
//        try {
//            return successResult(news.getNewsById(id));
//        }catch (Exception e){
//            ExceptionUtils.printException("getIndexModule controller报错：", e);
//            return failResult(e);
//        }
//    }
}
