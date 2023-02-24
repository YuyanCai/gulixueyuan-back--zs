package cn.xiaocaicoding.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: xiaocai
 * @since: 2023/02/23/21:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guliexception extends RuntimeException {
    private Integer code;//状态码
    private String msg;//异常信息
}

