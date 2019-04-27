package com.taoqi.socket.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.*;

/**
 * @作者：刘时明
 * @时间：2019/4/9-16:26
 * @作用：
 */
@Service
public class SocketHandler implements WebSocketHandler
{
    /**
     * 为了保存在线用户信息，在方法中新建一个list存储
     */
    private final static List<WebSocketSession> SESSIONS = Collections.synchronizedList(new ArrayList<>());
    public final static Set<String> USER_LIST = Collections.synchronizedSet(new HashSet<>());

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception
    {
        System.out.println("连接成功");
        SESSIONS.add(webSocketSession);
        String userName = (String) webSocketSession.getAttributes().get("WEBSOCKET_USERNAME");
        USER_LIST.add(userName);
        if (userName != null)
        {
            JSONObject obj = new JSONObject();
            // 统计一下当前登录系统的用户有多少个
            obj.put("count", SESSIONS.size());
            users(obj);
            webSocketSession.sendMessage(new TextMessage(obj.toJSONString()));
        }
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception
    {
        System.out.println("处理要发送的消息");
        JSONObject msg = JSON.parseObject(webSocketMessage.getPayload().toString());
        JSONObject obj = new JSONObject();
        if (msg.getInteger("type") == 1)
        {
            //给所有人
            obj.put("msg", msg.getString("msg"));
            sendMessageToUsers(new TextMessage(obj.toJSONString()));
        } else
        {
            //给个人
            String to = msg.getString("to");
            obj.put("msg", msg.getString("msg"));
            sendMessageToUser(to, new TextMessage(obj.toJSONString()));
        }
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception
    {
        if (webSocketSession.isOpen())
        {
            webSocketSession.close();
        }
        System.out.println("链接出错，关闭链接......");
        SESSIONS.remove(webSocketSession);
        String userName = (String) webSocketSession.getAttributes().get("WEBSOCKET_USERNAME");
        USER_LIST.remove(userName);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception
    {
        System.out.println("链接关闭......" + closeStatus.toString());
        SESSIONS.remove(webSocketSession);
        String userName = (String) webSocketSession.getAttributes().get("WEBSOCKET_USERNAME");
        USER_LIST.remove(userName);
    }

    @Override
    public boolean supportsPartialMessages()
    {
        return false;
    }

    /**
     * 将系统中的用户传送到前端
     *
     * @param obj
     */
    private void users(JSONObject obj)
    {
        List<String> userNames = new ArrayList<>();
        for (WebSocketSession webSocketSession : SESSIONS)
        {
            userNames.add((String) webSocketSession.getAttributes().get("WEBSOCKET_USERNAME"));
        }
        obj.put("users", userNames);
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message)
    {
        for (WebSocketSession user : SESSIONS)
        {
            try
            {
                if (user.isOpen())
                {
                    user.sendMessage(message);
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(String userName, TextMessage message)
    {
        for (WebSocketSession user : SESSIONS)
        {
            if (user.getAttributes().get("WEBSOCKET_USERNAME").equals(userName))
            {
                try
                {
                    if (user.isOpen())
                    {
                        user.sendMessage(message);
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
