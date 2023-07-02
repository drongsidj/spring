package top.igio.template.Exception;

import lombok.Data;

/**
 * @author ljl
 * @version V1.0
 * @data 2023/7/2 19:50
 * @description
 */
@Data
public class ResultVO {
    private Integer code;
    private String msg;
    private Object data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResultVO(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
