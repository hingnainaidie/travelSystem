package com.cqu.travelsystem.exception;

import com.cqu.travelsystem.utils.result.DataResult;
import com.cqu.travelsystem.utils.result.code.Code;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("com.cqu.travelsystem")
public class GlobalExceptionHandler {

    /**
     * 出现异常返回错误提示, 并且回滚事务
     * @param e
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public DataResult exceptionHandler(Exception e){
        System.out.println("抓到异常");
        e.printStackTrace();
        //手动事务回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return DataResult.errByErrCode(Code.ERROR);
    }
}
