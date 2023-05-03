package com.chat.response;

import com.chat.dto.Choices;
import lombok.Data;

import java.util.List;

/**
 * 响应
 *
 * @author Lance
 * @version 1.0.0
 * @data 2023-05-04 1:16
 */
@Data
public class ResponseBody {

    private List<Choices> choices;

}
