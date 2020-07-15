package cn.dingdong.service.impl;

import cn.dingdong.service.FileManagementService;
import cn.dingdong.utils.FileManagementUtils;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileManagementServiceImpl implements FileManagementService {


    @Override
    public String fileUpload(File file,String suffix) {

        return FileManagementUtils.fileUpload(file, suffix);
    }
}
