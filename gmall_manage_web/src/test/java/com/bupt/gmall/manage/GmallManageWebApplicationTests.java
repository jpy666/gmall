package com.bupt.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class GmallManageWebApplicationTests {

    @Test
    void contextLoads() throws IOException, MyException {
        String path = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();

        ClientGlobal.init(path);

        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        //切记启动nginx
        StorageClient storageClient = new StorageClient(trackerServer,null);
        String[] jpgs = storageClient.upload_file("C:\\Users\\17987\\Desktop\\timg.jpg", "jpg", null);
        String url = "http://10.108.114.135";
        for (String jpg : jpgs) {
            url = url + "/" + jpg;
        }
        System.out.println(url);
    }

}
