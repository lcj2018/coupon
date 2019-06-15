package top.juusok.couponapi.common.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import top.juusok.couponapi.common.api.JsonResult;

@ControllerAdvice("top.juusok.controller")
public class GlobalControllerExceptionHandler {
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public ResponseEntity<JsonResult<?>> handleRuntimeException(RuntimeException ex){
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new JsonResult<>(null, "操作失败", 500), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
