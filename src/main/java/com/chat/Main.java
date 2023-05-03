package com.chat;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.chat.dto.Message;
import com.chat.request.RequestBody;
import com.chat.response.ResponseBody;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ChatGPT test
 *
 * @author Lance
 * @version 1.0.0
 * @data 2023-05-04 0:58
 */
public class Main {

    public static final String URL = "https://api.openai.com/v1/chat/completions";
    // 你的 API KEY
    public static final String APT_KEY = "sk-xxxxxxxx";

    public static void main(String[] args) {
        ArrayList<Message> list = new ArrayList<>();

        while (true) {
            System.out.print("请输入：");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            if ("exit".equals(input)) {
                System.out.println("程序已经退出！");
                break;
            }
            Message message = new Message();
            message.setRole("user");
            message.setContent(input);
            list.add(message);

            RequestBody request = new RequestBody();
            request.setModel("gpt-3.5-turbo");

            request.setMessages(list);

            String data = JSON.toJSONString(request);

            // 封装http请求
            String response = HttpRequest.post(URL).header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + APT_KEY)
                    .body(data)
                    .execute()
                    .body();

            ResponseBody body = JSON.parseObject(response, ResponseBody.class);
            String content = body.getChoices().get(0).getMessage().getContent();
            System.out.println(content);
        }
    }
}
