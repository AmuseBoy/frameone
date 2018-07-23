package com.amuse.frameone.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @ClassName HttpClientTest
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/18 20:39
 * @Version 1.0
 */
public class HttpClientTest {

    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "http://api.ip.data5u.com/dynamic/get.html?order=3a48a8510f34ad199d1cd4a8387d9fc4&ttl=1&json=1&sep=3";
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if(entity != null){
                String jsonString = EntityUtils.toString(entity);
                System.out.println(jsonString);
                JSONObject jsonObject = JSON.parseObject(jsonString);
                System.out.println(jsonObject.getJSONArray("data").get(0));
                return ;
            }
        } catch (Exception e){
            System.out.println("异常"+e);
        }

    }
}
