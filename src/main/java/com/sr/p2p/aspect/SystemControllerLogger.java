package com.sr.p2p.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * Created by wangpengfei on 2015/9/28.
 */
@Aspect
@Component
public class SystemControllerLogger {

    //本地异常日志记录对象
    private  static  final Logger logger = LoggerFactory.getLogger(SystemControllerLogger.class);

    //Controller层切点
    @Pointcut("execution(* com.sr.p2p.controller.*.*(..))")
    public  void controllerAspect() {}

    //@Before("controllerAspect()")
    public  void doBefore(JoinPoint joinPoint) {}

    //@After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {}

    //@AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {}

    //@AfterReturning("controllerAspect()")
    public void readAfterReturning(){}

    @Around("controllerAspect()")
    public Object readAround(ProceedingJoinPoint joinPoint) {
        Date start = new Date();
        Object result = null;
        try {
            result = joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable e) {
            e.printStackTrace();
        }finally{
            Date end = new Date();
            String params = "";
            if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
                for ( int i = 0; i < joinPoint.getArgs().length; i++) {
                    params += JSON.toJSON(joinPoint.getArgs()[i]) + ";";
                }
            }
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String ip = request.getRemoteAddr();
            logger.info("startTime:" + start.getTime());
            logger.info("method:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            logger.info("params:" + params);
            logger.info("iP:" + ip);
            logger.info("endTime:" + end.getTime());
            logger.info("costTime:" +(end.getTime()-start.getTime())+" ms");
        }
        return result;
    };

}
