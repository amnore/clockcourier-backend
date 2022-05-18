package com.edu.nju.clockcourier.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONUtil;
import com.edu.nju.clockcourier.po.LogPO;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
@Order(1)
public class RequestLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLogger.class);

    @Pointcut("execution(public * com.edu.nju.clockcourier.controller.*.*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();

        //获取当前请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) return result;
        HttpServletRequest request = attributes.getRequest();

        //记录请求信息
        LogPO log = new LogPO();

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method.isAnnotationPresent(ApiOperation.class)) {
            ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
            log.setDescription(apiOperation.value());
        }

        long endTime = System.currentTimeMillis();

        String urlStr = request.getRequestURL().toString();

        log.setBasePath(StrUtil.removeSuffix(urlStr, URLUtil.url(urlStr).getPath()));
        log.setIp(request.getRemoteUser());
        log.setMethod(request.getMethod());
        log.setParameter(Reflector.getParameter(method, joinPoint.getArgs()));
        log.setResult(result);
        log.setSpendTime((int) (endTime - startTime));

        Date time = new Date(startTime);
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdFormatter.format(time);

        log.setStartTime(now);
        log.setUri(request.getRequestURI());
        log.setUrl(request.getRequestURL().toString());

        LOGGER.info("{}", JSONUtil.parse(log));
        return result;
    }

}
