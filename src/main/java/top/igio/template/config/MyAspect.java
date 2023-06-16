package top.igio.template.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author ljl
 * @version V1.0
 * @data 2023/6/16 22:14
 * @description
 */
@Aspect
@Component
public class MyAspect {

        private final static Logger logger = LoggerFactory.getLogger(MyAspect.class);

        @Pointcut("execution(public * top.igio.template.service.impl.*.*(..))")
        public void pointCut() {
        }

        @Before("pointCut()")
        public void before(JoinPoint joinPoint) {
            logger.info("-----开始执行" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "-----");
            logger.info("请求方法：{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            logger.info("请求参数：{}", Arrays.toString(joinPoint.getArgs()));
        }

        @AfterReturning(returning = "ret", pointcut = "pointCut()")
        public void afterReturning(Object ret) {
            logger.info("-----开始执行后置通知-----");
            logger.info("返回参数：{}", ret);
            logger.info("-----后置通知结束-----");
        }

        @AfterThrowing(pointcut = "pointCut()", throwing = "e")
        public void afterThrowing(JoinPoint joinPoint, Exception e) {
            logger.info("-----开始执行异常通知-----");
            logger.info("请求方法：{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            logger.info("异常信息：{}", e.getMessage());
            logger.info("-----异常通知结束-----");
        }

        @After("pointCut()")
        public void after(JoinPoint joinPoint) {
            logger.info("-----开始执行最终通知-----");
            logger.info("请求方法：{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            logger.info("-----最终通知结束-----");
        }
}
