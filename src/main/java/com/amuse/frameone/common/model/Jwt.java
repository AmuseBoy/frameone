package com.amuse.frameone.common.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName Audience
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/29 10:37
 * @Version 1.0
 */

@ConfigurationProperties(prefix = "jwt")
@Component
public class Jwt {

    private String clientId;
    private String base64Secret;
    private String name;
    private int expiresSecond;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBase64Secret() {
        return base64Secret;
    }

    public void setBase64Secret(String base64Secret) {
        this.base64Secret = base64Secret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpiresSecond() {
        return expiresSecond;
    }

    public void setExpiresSecond(int expiresSecond) {
        this.expiresSecond = expiresSecond;
    }
}
