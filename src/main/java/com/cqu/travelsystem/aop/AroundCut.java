package com.cqu.travelsystem.aop;


import com.cqu.travelsystem.utils.result.DataResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Component
@Aspect
public class AroundCut {
    public static final String POINT_CUT = "execution(* com.cqu.travelsystem.controller.CaseEventController.*(..)) || " +
            "execution(* com.cqu.travelsystem.controller.ComplaintEventController.*(..)) || " +
            "execution(* com.cqu.travelsystem.controller.EmergencyController.*(..)) || " +
            "execution(* com.cqu.travelsystem.controller.HotelController.*(..)) || " +
            "execution(* com.cqu.travelsystem.controller.MonitorController.*(..)) || " +
            "execution(* com.cqu.travelsystem.controller.ParkingController.*(..)) || " +
            "execution(* com.cqu.travelsystem.controller.ScenicController.*(..)) || " +
            "execution(* com.cqu.travelsystem.controller.TicketController.*(..)) || " +
            "execution(* com.cqu.travelsystem.controller.TripEventController.*(..)) || " +
            "execution(* com.cqu.travelsystem.controller.TripInfoController.*(..)) || " +
            "execution(* com.cqu.travelsystem.controller.UserController.*(..))";

    @Around(AroundCut.POINT_CUT)
    public DataResult checkSession(ProceedingJoinPoint pjp) throws Throwable{
        //获取session
        HttpSession session=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        return (DataResult) pjp.proceed();
    }
}
