package com.amuse.frameone.test.io;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.List;

/**
 * @ClassName FileListener
 * @Description 监听目录文件的变化WatchService
 * @Author 刘培振
 * @Date 2018/8/29 16:34
 * @Version 1.0
 */
public class FileListener {

    public static void main(String[] args) throws Exception {

        URI uri = new URI("ftp://root@192.168.32.128:21/");
        //String path = "E:\\a\\b\\c";
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path p = Paths.get(uri);
        p.register(watchService,StandardWatchEventKinds.ENTRY_CREATE);
        try {
            WatchKey watchKey = watchService.take();
            List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
            for(WatchEvent<?> event : watchEvents){
                System.out.println("["+uri+"/"+event.context()+"]文件发生了["+event.kind()+"]事件");
            }
            watchKey.reset();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        watchService.close();
    }

}
