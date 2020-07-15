package cn.dingdong.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RequestUtil {

    /**
     * 发送POST请求
     *
     * @param path
     * @param requestData
     * @return
     * @throws IOException
     */
    public static String sendPOSTRequest(String path, Map<String, String> requestData,Map<String, String> header) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(path);
//        httpPost.setHeader("Authorization","Bearer {"+token+"}");
        if (header !=null && !header.isEmpty()){
            header.forEach((key,value)-> httpPost.setHeader(key,value));
        }
        CloseableHttpResponse execute;
        List<NameValuePair> params = new ArrayList<>();
        for (String key : requestData.keySet()) {
            params.add(new BasicNameValuePair(key, requestData.get(key)));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        execute = httpClient.execute(httpPost);
        return EntityUtils.toString(execute.getEntity());
    }

    /**
     * 发送POST请求
     *
     * @param path
     * @param requestData
     * @return
     * @throws IOException
     */
    public static String sendPOSTPayloadRequest(String path, JSONObject requestData, Map<String, String> header) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(path);
//        httpPost.setHeader("Authorization","Bearer {"+token+"}");
        if (header !=null && !header.isEmpty()){
            header.forEach((key,value)-> httpPost.setHeader(key,value));
        }
        CloseableHttpResponse execute;
        StringEntity stringEntity = new StringEntity((requestData.toJSONString()), "utf-8");
        httpPost.setEntity(stringEntity);
        execute = httpClient.execute(httpPost);
        return EntityUtils.toString(execute.getEntity());
    }
    /**
     * 发送PUT请求
     *
     * @param path
     * @param requestData
     * @return
     * @throws IOException
     */
    public static String sendPUTRequest(String path, Map<String, String> requestData,Map<String, String> header) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(path);
//        httpPut.setHeader("Authorization","Bearer {"+token+"}");
        if (header !=null && !header.isEmpty()){
            header.forEach((key,value) -> httpPut.setHeader(key,value));
        }
        CloseableHttpResponse execute;
        List<NameValuePair> params = new ArrayList<>();
        for (String key : requestData.keySet()) {
            params.add(new BasicNameValuePair(key, requestData.get(key)));
        }
        httpPut.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        execute = httpClient.execute(httpPut);
        return EntityUtils.toString(execute.getEntity());
    }

    /**
     * 发送PUT请求
     *
     * @param path
     * @param requestData
     * @return
     * @throws IOException
     */
    public static String sendPUTPayloadRequest(String path, JSONObject requestData, Map<String, String> header) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(path);
//        httpPut.setHeader("Authorization","Bearer {"+token+"}");
        if (header !=null && !header.isEmpty()){
            header.forEach((key,value) -> httpPut.setHeader(key,value));
        }
        CloseableHttpResponse execute;
        StringEntity stringEntity = new StringEntity((requestData.toJSONString()), "utf-8");
        httpPut.setEntity(stringEntity);
        execute = httpClient.execute(httpPut);
        return EntityUtils.toString(execute.getEntity());
    }
    /**
     * 发送请求GET
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static String sendGETRequest(String path,Map<String, String> header) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(path);
        if (header !=null && !header.isEmpty()){
            header.forEach((key,value) -> httpGet.setHeader(key,value));
        }
        CloseableHttpResponse execute;
        execute = httpClient.execute(httpGet);
        return EntityUtils.toString(execute.getEntity());
    }




}
