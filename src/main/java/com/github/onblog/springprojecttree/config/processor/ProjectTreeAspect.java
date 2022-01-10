package com.github.onblog.springprojecttree.config.processor;

import com.github.onblog.springprojecttree.core.around.AroundMethod;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Random;
@Deprecated
//@Component
//@Aspect
public class ProjectTreeAspect {

    //声明切点
    @Pointcut("")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp){
        int identify = new Random().nextInt();
        AroundMethod.playBeforeMethod(pjp,identify);
        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        AroundMethod.playAfterMethod(pjp,identify,obj);
        return obj;
    }

}
