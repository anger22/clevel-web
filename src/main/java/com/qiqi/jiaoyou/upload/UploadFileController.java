package com.qiqi.jiaoyou.upload;


import com.qiqi.jiaoyou.constants.PathParam;
import com.qiqi.jiaoyou.mapper.PlatformParameterSettingMapper;
import com.qiqi.jiaoyou.util.ResultUtils;
import com.qiqi.jiaoyou.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/jiaoyou/file")
@CrossOrigin(allowCredentials = "true")
public class UploadFileController {
    @Autowired
    private PlatformParameterSettingMapper platformParameterSettingMapper;

    @PostMapping("/UploadFile")
    public ResultUtils UploadPicture(HttpServletResponse response, HttpServletRequest request, @RequestParam("file") MultipartFile files) throws IOException {
        ResultUtils resultUtils = new ResultUtils();
        //遍历并保存文件
        try {
            String filename = files.getOriginalFilename();
            String fileExt = filename.substring(filename.lastIndexOf(".")).toLowerCase();
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String newFileName = df.format(new Date());
            String fileNames = newFileName + new Random().nextInt(1000) + fileExt;
            if ("apk".equals(fileExt)){
                System.err.println("删除以往Apk 开始");
                FileUtil.delApk(1,"");
                System.err.println("删除以往Apk 结束");
            }
            // 获得文件上传日期,作为目录名一部分
            String suffix = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String filePath = PathParam.uploadpath + suffix + "/" + fileNames;
            String filepaths ="/upload/" + suffix + "/" + fileNames;
            System.out.println("filePath:" + filePath);
            File localFile = new File(filePath);
            if (!localFile.getParentFile().exists()) {
                localFile.getParentFile().mkdirs();
            }
            files.transferTo(localFile);
            resultUtils.setStatus(200);
            resultUtils.setMessage("上传成功");
            resultUtils.setData(filepaths);
            resultUtils.setCode(2);
        } catch (Exception e) {
            e.printStackTrace();
            resultUtils.setStatus(500);
            resultUtils.setMessage("上传文件失败");
            resultUtils.setCode(1);
        }
        return resultUtils;
    }



    @PostMapping("/UploadFile1")
    public ResultUtils UploadPicture1(HttpServletResponse response, HttpServletRequest request, @RequestParam("file") MultipartFile files) throws IOException {
        ResultUtils resultUtils = new ResultUtils();
        //遍历并保存文件
        try {
            String filename = files.getOriginalFilename();
            String fileExt = filename.substring(filename.lastIndexOf(".")).toLowerCase();
            if ("apk".equals(fileExt)){
                System.err.println("删除以往Apk 开始");
                FileUtil.delApk(1,"");
                System.err.println("删除以往Apk 结束");
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String newFileName = df.format(new Date());
            String fileNames = newFileName + new Random().nextInt(1000) + fileExt;
            // 获得文件上传日期,作为目录名一部分
            String suffix = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String filePath = PathParam.uploadpath + suffix + "/" + fileNames;
            String filepaths ="/upload/" + suffix + "/" + fileNames;
            System.out.println("filePath:" + filePath);
            File localFile = new File(filePath);
            if (!localFile.getParentFile().exists()) {
                localFile.getParentFile().mkdirs();
            }
            files.transferTo(localFile);
            resultUtils.setStatus(200);
            resultUtils.setMessage("上传成功");
            resultUtils.setData(PathParam.onlinepath + filepaths);
            resultUtils.setCode(2);
        } catch (Exception e) {
            e.printStackTrace();
            resultUtils.setStatus(500);
            resultUtils.setMessage("上传文件失败");
            resultUtils.setCode(1);
        }
        return resultUtils;
    }
}
