package com.amuse.frameone.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SessionController
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/18 20:34
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/session")
public class SessionController {

    private final static Logger logger = LoggerFactory.getLogger(SessionController.class);

    /**
     * http://localhost:8002/session/cookie?browser=Firefox
     * @param browser
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/cookie")
    public String cookie(@RequestParam String browser, HttpSession session, HttpServletRequest request){
        Object sessionBrowser = session.getAttribute("browser");
        if(sessionBrowser == null){
            logger.info("不存在session,设置browser="+browser);
            session.setAttribute("browser",browser);
        }else {
            logger.info("存在session,browser="+sessionBrowser.toString());
        }

        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies){
                logger.info(cookie.getName()+":"+cookie.getValue());
            }
        }
        return "Hello World";
    }

    /**
     * http://localhost:8002/session/sessions
     * 不涉及session的操作，是不会产生session
     * @param request
     * @return
     */
    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    public Map<String, Object> sessions (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        //map.put("sessionId", request.getSession().getId());
        return map;
    }

    /**
     * http://localhost:8002/session/home
     * @param session
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpSession session) {
        session.setAttribute("test", new Date());
        return "Hello World!";
    }
}
