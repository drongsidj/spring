package top.igio.template.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.igio.template.Exception.ResultVO;
import top.igio.template.entity.PageTest;
import top.igio.template.entity.request.PageTestRequest;
import top.igio.template.service.TestPageUtilService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ljl
 * @version V1.0
 * @data 2023/7/2 19:53
 * @description
 */
@Service
public class TestPageUtilServiceImpl implements TestPageUtilService {

    private final static Logger logger = LoggerFactory.getLogger(TestPageUtilServiceImpl.class);

    public ResultVO testPageUtil(PageTestRequest pageTestRequest) {
        List<PageTest> pages = buildEntity();
        int total = pages.size();

        int totalPage = PageUtil.totalPage(pages.size(), pageTestRequest.getSize()); // 计算总页数
        List<PageTest> pageData = CollUtil.page(pageTestRequest.getCurrentPage(), pageTestRequest.getSize(), pages); // 截取当前页的数据

        Map<String, Object> result = new HashMap<>();
        result.put("totalPage", totalPage);
        result.put("pageData", pageData);


        System.out.println(pageData.size());
        System.out.println(totalPage);
        return new ResultVO(200, "ok", result);
    }


    public List<PageTest> buildEntity() {
        List<PageTest> pages = new ArrayList<>();

        for(int i=0;i<25;i++) {
            PageTest pageTest = new PageTest();
            pageTest.setName("张三");
            pageTest.setSchool("清华大学");
            pageTest.setAge(i);
            pages.add(pageTest);
        }
        return pages;
    }
}
