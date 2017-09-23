package com.loan.admin.controller;

import com.loan.admin.consts.Constants;
import com.loan.admin.service.hotloan.IFilesInfoService;
import com.loan.common.beans.Result;
import com.loan.common.utils.ExceptionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Description:
 * @author: shuttle
 * @date: 2017-09-23 9:43 PM
 */
@RestController
@RequestMapping(Constants.BASE_URL + "/upload")
@Api(description = "上传文件")
public class UploadImageController extends BaseController {

    @Autowired
    private IFilesInfoService filesInfoService;

    private final String IMAGE_PATH = "/www/cdn/loan/images/banner/";

    private final String SAVE_PAHT = "loan/images/banner/";

    @ApiOperation(value = "上传图片", notes = "上传图片文件到服务器", response = String.class)
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public Result<String> getHotLoanList(@RequestParam("file") MultipartFile file,
                                         @RequestParam(value = "name", required = false) String fileName) {
        if (file.isEmpty()) {
            return failResult();
        }
        try {
            String originFileName = file.getOriginalFilename();
            if (StringUtils.isBlank(fileName)) {
                fileName = originFileName;
            }
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            File dest = new File(IMAGE_PATH + fileName);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
                filesInfoService.save(originFileName, SAVE_PAHT + fileName);
                return successResult(SAVE_PAHT + fileName);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            ExceptionUtils.printException("uploadImage error：", e);
            e.printStackTrace();
            return failResult(e);
        }
        return failResult();
    }
}
