package com.sedion.mynawang.qiniu;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.sedion.mynawang.constant.QiniuCons;

import java.io.IOException;

/**
 * 七牛上传文件
 *
 * @auther mynawang
 * @create 2016-10-09 16:47
 */
public class UploadFile {

    //密钥配置
    Auth auth = Auth.create(QiniuCons.ACCESS_KEY, QiniuCons.SECRET_KEY);

    //创建上传对象
    UploadManager uploadManager = new UploadManager();

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(){
        return auth.uploadToken(QiniuCons.BUCKET_NAME);
    }

    public void upload(String filePath, String fileName) throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(filePath, fileName, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

    public static void main(String args[]) throws IOException{
        new UploadFile().upload("F:\\logs\\test.jpg", "test.jpg");
    }
}
