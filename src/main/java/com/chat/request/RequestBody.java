package com.chat.request;

import com.chat.dto.Message;
import lombok.Data;

import java.util.List;

/**
 * 请求体
 *
 * @author Lance
 * @version 1.0.0
 * @data 2023-05-04 1:00
 */
@Data
public class RequestBody {

    private String model;

    private List<Message> messages;
}
