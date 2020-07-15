package cn.dingdong.utils;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 图片上传服务
 */
public class FileManagementUtils {
    // 文件服务appId
    public static String appId = "lenovo";
    // 文件服务授权密钥 appKey
    public static String appKey = "6LHBi2HWB3DdoMFb";
    // 文件上传服务 上传地址
    public static String uploadBaseUrl = "http://up.lefile.cn/image/upload";
    // 文件上传服务 保存相对路径
    public static String uploadExPath = "http://lenovo.app.lefile.cn/";

    public static String fileUpload(File file, String suffix) {
        String filePath = file.toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); //设置格式
        String newFileName = format.format(new Date()) + "." + suffix;
        //用日期拼成文件名
        Date date = new Date();
        String path = new SimpleDateFormat("yyyy/MM/dd/").format(date);
        //文件存储在文件服务器中的路径和文件名
        String newFileNamePath = "/livePlatForm/" + path + newFileName;
        //是否强制覆盖服务器已有文件
        boolean upDate = false;

        /*UploadResponse response = UploadManager.uploadFile(appId, appKey, uploadBaseUrl, newFileNamePath, filePath, upDate);
        if ("001".equals(response.getStatus())) {
            return uploadExPath + response.getFilename();
        } else {
            return null;
        }*/
        return null;
    }
}
