package com.sedion.mynawang.common.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sedion.mynawang.common.util.MyX509TrustManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

/**
 * @auther mynawang
 * @create 2016-09-29 20:49
 */
public class HttpKit {

    // 日志文件
    protected final static Logger log = LoggerFactory.getLogger(HttpKit.class);

    /**
     * 发起https请求并获取结果
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject (通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequestToObj(String requestUrl, String requestMethod, String outputStr) {
        String getRes = httpRequestToStr(requestUrl, requestMethod, outputStr);
        JSONObject jsonObject = JSON.parseObject(getRes);
        return jsonObject;
    }

    /**
     * 发起https请求并获取结果
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject (通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static String httpRequestToStr(String requestUrl, String requestMethod, String outputStr) {
        System.out.println(requestUrl);
        String finalResult = null;
        try {
            //创建SSLContext对象，并使用我们指定的信任管理器初始化(证书过滤)
            TrustManager[] tm = { new MyX509TrustManager() };
            //取得SSL的SSLContext实例
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            //初始化SSLContext
            sslContext.init(null, tm, new java.security.SecureRandom());
            //从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn=(HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            //设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);
            //当有数据需要提交时(当outputStr不为null时，向输出流写数据)
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer=new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            System.out.println("哈哈哈： " + buffer.toString());
            //释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpUrlConn.disconnect();
            finalResult = buffer.toString();
        } catch (ConnectException ce) {
            log.error("连接超时: {}",ce);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("https请求异常: {}", e);
        }
        return finalResult;
    }



}
