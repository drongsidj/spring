package top.igio.template.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.igio.template.service.TestAopService;

/**
 * @author ljl
 * @version V1.0
 * @data 2023/6/16 22:09
 * @description
 */
@Service
public class TestAopServiceImpl implements TestAopService {

    private final static Logger logger = LoggerFactory.getLogger(TestAopServiceImpl.class);


    @Override
    public void testAop() {
        logger.info("-----开始执行测试方法了-----");
        System.out.println("-------test------aop------");
        logger.info("-----结束执行测试方法了-----");
    }
}
