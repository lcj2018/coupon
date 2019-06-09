package top.juusok.couponapi.common.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import top.juusok.couponapi.common.api.JsonResult;
import top.juusok.couponapi.common.exception.def.ProjectException;
import top.juusok.couponapi.controller.StoreController;

@ControllerAdvice(assignableTypes = {StoreController.class})
public class StoreControllerExceptionHandler {

		@ExceptionHandler({ProjectException.class})
		@ResponseBody
		public ResponseEntity<JsonResult<?>> handleProjectException(ProjectException ex)
		{
			return new ResponseEntity<>(new JsonResult<>(null, ex.getMessage()), HttpStatus.BAD_REQUEST);
		}
		
}

