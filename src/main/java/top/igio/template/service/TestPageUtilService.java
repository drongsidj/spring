package top.igio.template.service;

import top.igio.template.Exception.ResultVO;
import top.igio.template.entity.request.PageTestRequest;

/**
 * @author ljl
 * @version V1.0
 * @data 2023/7/2 19:52
 * @description
 */
public interface TestPageUtilService {

    ResultVO testPageUtil(PageTestRequest pageTestRequest);
}
