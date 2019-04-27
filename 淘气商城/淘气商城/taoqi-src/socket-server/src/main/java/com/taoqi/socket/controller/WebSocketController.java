package com.taoqi.socket.controller;

import com.taoqi.socket.websocket.SocketHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @作者：刘时明
 * @时间：2019/4/9-16:34
 * @作用：
 */
@Controller
@RequestMapping("/socket")
public class WebSocketController
{
    @GetMapping("list")
    @ResponseBody
    public Object index()
    {
        return SocketHandler.USER_LIST;
    }

    @RequestMapping("/chat/{id}")
    public String chat(HttpServletRequest request,@PathVariable String id)
    {
        request.getSession().setAttribute("WEBSOCKET_USERNAME", id);
        return "chat";
    }
}
