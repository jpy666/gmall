package com.bupt.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>Title:UploadUtil</p>
 * <p>Description:</P>
 * <p>Company:hhu.edu.cn</p>
 *
 * @Author 北京邮电大学.金培源
 * @Date 2020/10/17 16:49
 * Version 1.0
 */
public class UploadUtil {
    public static String uploadImage(MultipartFile multipartFile) {
        String path = UploadUtil.class.getResource("/tracker.conf").getPath();

        try {
            ClientGlobal.init(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getTrackerServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StorageClient storageClient = new StorageClient(trackerServer,null);
        String[] jpgs = new String[0];
        try {
            jpgs = storageClient.upload_file(multipartFile.getBytes(),multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1), null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        String url = "http://10.108.114.135";
        for (String jpg : jpgs) {
            url = url + "/" + jpg;
        }
        System.out.println(url);
        return url;
    }
}
