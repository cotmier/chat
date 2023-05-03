package com.chat.dto;

import lombok.Data;

/**
 * 消息内容
 * @author Lance
 * @version 1.0.0
 * @data 2023-05-04 1:01
 */
@Data
public class Message {

    private String role;
    private String content;
}
