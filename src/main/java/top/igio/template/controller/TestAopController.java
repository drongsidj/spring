package top.igio.template.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.igio.template.entity.request.TestAopRequest;
import top.igio.template.service.TestAopService;

import javax.annotation.Resource;

/**
 * @author ljl
 * @version V1.0
 * @data 2023/6/16 22:23
 * @description
 */
@RestController
@RequestMapping("/testAop")
public class TestAopController {

    private final static Logger logger = LoggerFactory.getLogger(TestAopController.class);

    @Resource
    private TestAopService testAopService;

    @RequestMapping(value = "/first", method = RequestMethod.POST)
    public String testAop(@RequestBody TestAopRequest testAopRequest) {
        logger.info("-----开始执行controller方法了-----");
        System.out.println(testAopRequest.getName());
        System.out.println(testAopRequest.getAge());
        testAopService.testAop();
        return "ok";
    }
}
