package top.fatbird.didadi.component;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/imserver/{username}")
@Component
public class WebSocketServer {
    private static final Logger log=LoggerFactory.getLogger(WebSocketServer.class);
    public static Map<String, Session> sessionMap = new ConcurrentHashMap<>();
    @OnOpen
    public void onOpen(Session session, @PathVariable("uid") String uid){
        sessionMap.put(uid,session);
        log.info("用户ID{}上线，当前在线人数{}",uid,sessionMap.size());
        JSONObject result = new JSONObject();
        JSONArray array=new JSONArray();
        result.put("users",array);
        for(Object key : sessionMap.keySet()){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("uid",key);
            array.add(jsonObject);
        }
        sendAllMessage(JSON.toJSONString(result));
    }
    @OnClose
    public void onClose(Session session, @PathVariable("uid") String uid){
        sessionMap.remove(uid);
        log.info("ID{}用户连接关闭，移除其session，当前在线人数为{}",uid,sessionMap.size());

    }
    @OnMessage
    public void onMessage(String message, Session session, @PathVariable("uid") String uid) {
        log.info("服务端收到ID{}的消息：{}", uid, message);
        JSONObject obj = JSON.parseObject(message);
        String toUid = obj.getString("to");
        String msg = obj.getString("msg");
        Session toSession = sessionMap.get(toUid);
        if (toSession != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("from", uid);
            jsonObject.put("msg", msg);
            this.sendMessage(jsonObject.toString(), toSession);
            log.info("发送给用户ID{}，信息：{}", toUid, jsonObject.toString());
        } else {
            log.info("发送失败，未找到用户ID{}的session", toUid);
        }
    }

    @OnError
    public void onError(Session session,Throwable error){
        log.error("发生错误");
        error.printStackTrace();
    }

    private  void sendMessage(String message,Session toSession){
        try{
            log.info("服务端给客户端{}发送消息{}",toSession.getId(),message);
            toSession.getBasicRemote().sendText(message);
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败",e);
        }
    }
    private void sendAllMessage(String message){

        try{
            for (Session session : sessionMap.values()){
                log.info("服务端给客户端[{}]发送消息{}",session.getId(),message);
                session.getBasicRemote().sendText(message);
            }
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败",e);
        }
    }
}
