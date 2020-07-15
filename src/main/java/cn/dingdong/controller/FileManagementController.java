package cn.dingdong.controller;

import cn.dingdong.dto.CommonResponse;
import cn.dingdong.dto.ResponseCode;
import cn.dingdong.service.FileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传服务
 */
@RestController
@RequestMapping("/api/v1/pic")
public class FileManagementController {

    @Autowired
    FileManagementService fileManagementService;

    @RequestMapping("/upload")
    public CommonResponse fileUpload(@RequestParam("picfile") MultipartFile[] picfile) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            List<String> urls = new ArrayList<>();
            for (int i = 0; i < picfile.length; i++) {
                String suffix = picfile[i].getOriginalFilename().substring(picfile[i].getOriginalFilename().lastIndexOf(".") + 1);
                File temp = File.createTempFile("datasource", suffix);
                picfile[i].transferTo(temp);
                String url = fileManagementService.fileUpload(temp, suffix);
                urls.add(url);
                temp.delete();
            }
            commonResponse.setData(urls);
            return commonResponse;
        } catch (IOException e) {
            e.printStackTrace();
            commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                    .setMsg("上传失败");
            return commonResponse;
        }
    }
}
