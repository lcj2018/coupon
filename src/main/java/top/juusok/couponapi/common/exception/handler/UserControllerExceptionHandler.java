package top.juusok.couponapi.common.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.*;

import top.juusok.couponapi.common.api.JsonResult;
import top.juusok.couponapi.common.exception.def.ProjectException;
import top.juusok.couponapi.controller.UserController;

@ControllerAdvice(assignableTypes = {UserController.class})
public class UserControllerExceptionHandler {

	@ExceptionHandler({ProjectException.class})
	@ResponseBody
	public ResponseEntity<JsonResult<?>> handleProjectException(ProjectException ex)
	{
		return new ResponseEntity<>(new JsonResult<>(null, ex.getMessage(), 400), HttpStatus.BAD_REQUEST);
	}
	
}
