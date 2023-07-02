package top.igio.template.entity.request;

import lombok.Data;

/**
 * @author ljl
 * @version V1.0
 * @data 2023/7/2 20:08
 * @description
 */
@Data
public class PageTestRequest {

    private Integer currentPage;

    private Integer size;
}
