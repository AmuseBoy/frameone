package com.amuse.frameone.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @ClassName WechatController
 * @Description TODO
 * @Author 刘培振
 * @Date 2019/1/30 17:46
 * @Version 1.0
 */
@RestController
public class WechatController {

    private static final String token = "liupeizhen";


    @RequestMapping(value = "/wechat", method = RequestMethod.GET)
    public String wechat(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        boolean bool = checkSignature(signature, timestamp, nonce);
        if (bool) {
            return echostr;
        }
        return null;
    }



    /***
     * @Description: 校验签名
     * @Param:  [signature, timestamp, nonce]
     * @Return: boolean
     * @Author: 刘培振
     * @Date:   2019/1/31 15:00
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[]{token, timestamp, nonce};
        //排序
        Arrays.sort(arr);
        //生成字符串
        StringBuilder content = new StringBuilder();
        for (String str : arr) {
            content.append(str);
        }
        //sha1加密
        String temp = SHA1(content.toString());
        //比较微信签名和我们自己算的签名
        return temp.equals(signature);
    }


    //sha1加密
    public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
