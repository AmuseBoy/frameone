package com.amuse.frameone.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.amuse.frameone.service.HttpService;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @ClassName HttpServiceImpl
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/27 19:40
 * @Version 1.0
 */
@Service
public class HttpServiceImpl implements HttpService {

    private static final Logger logger = LoggerFactory.getLogger(HttpServiceImpl.class);



    public void httpClient(){
        CloseableHttpClient client = httpClientConfig();
        //String url = "http://api.ip.data5u.com/dynamic/get.html?order=3a48a8510f34ad199d1cd4a8387d9fc4&ttl=1&json=1&sep=3";
        String url = "https://www.baidu.com/v2/login";
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if(entity != null){
                String jsonString = EntityUtils.toString(entity,"UTF-8");
                logger.info("httpClient返回:"+jsonString);
            }
        } catch (Exception e){
            System.out.println("异常"+e);
        }
    }


    /**
     * 返回HttpClient
     * @return
     */
    public CloseableHttpClient httpClientConfig(){
        try {
            //SSL安全协议
            SSLContext sslContext = new SSLContextBuilder().useProtocol("TLS").loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            }).build();
            //httpClient  SSL
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
            //httpClient重试机制false
            HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {
                @Override
                public boolean retryRequest(IOException e, int i, HttpContext httpContext) {
                    return false;
                }
            };
            //httpClient超时配置
            RequestConfig globalconfig = RequestConfig
                    .custom()
                    .setConnectionRequestTimeout(10000)
                    .setConnectTimeout(10000)
                    .setSocketTimeout(10000)
                    .setRedirectsEnabled(true)
                    .setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY).build();
            //此番遭劫，定要好好学学httpClient
            SocketConfig socketConfig = SocketConfig
                    .custom()
                    .setSoTimeout(10000).build();
            //cookie
            CookieStore cookieStore = new BasicCookieStore();
            //httpClient配置
            HttpClientBuilder httpClientBuilder = HttpClients
                    .custom()
                    .setRetryHandler(myRetryHandler)
                    .setSSLSocketFactory(sslsf)
                    .setDefaultCookieStore(cookieStore)
                    .setDefaultSocketConfig(socketConfig)
                    .setDefaultRequestConfig(globalconfig);
            return httpClientBuilder.build();
        } catch (Exception e) {
            logger.info("生成CloseableHttpClient异常");
        }
        return null;
    }


}
