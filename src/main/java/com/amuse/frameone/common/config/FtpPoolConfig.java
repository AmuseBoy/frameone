package com.amuse.frameone.common.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName FtpPoolConfig
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/9/26 13:53
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "ftp")
public class FtpPoolConfig extends GenericObjectPoolConfig {

    private String host;

    private int port;

    private String username;//用户名

    private String password;//密码

    private int connectTimeOut;//ftp 连接超时时间 毫秒

    private String controlEncoding;

    private int bufferSize;//缓冲区大小

    private int fileType;

    private int dataTimeout;

    private boolean useEPSVwithIPv4;

    private boolean passiveMode;

    private int maxTotal;

    private int maxIdle;

    private int minIdle;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getConnectTimeOut() {
        return connectTimeOut;
    }

    public void setConnectTimeOut(int connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
    }

    public String getControlEncoding() {
        return controlEncoding;
    }

    public void setControlEncoding(String controlEncoding) {
        this.controlEncoding = controlEncoding;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public int getDataTimeout() {
        return dataTimeout;
    }

    public void setDataTimeout(int dataTimeout) {
        this.dataTimeout = dataTimeout;
    }

    public boolean isUseEPSVwithIPv4() {
        return useEPSVwithIPv4;
    }

    public void setUseEPSVwithIPv4(boolean useEPSVwithIPv4) {
        this.useEPSVwithIPv4 = useEPSVwithIPv4;
    }

    public boolean isPassiveMode() {
        return passiveMode;
    }

    public void setPassiveMode(boolean passiveMode) {
        this.passiveMode = passiveMode;
    }

    @Override
    public int getMaxTotal() {
        return maxTotal;
    }

    @Override
    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    @Override
    public int getMaxIdle() {
        return maxIdle;
    }

    @Override
    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    @Override
    public int getMinIdle() {
        return minIdle;
    }

    @Override
    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }
}
