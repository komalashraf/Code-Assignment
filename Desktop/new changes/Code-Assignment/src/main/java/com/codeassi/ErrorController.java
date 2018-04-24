/**
 * 
 */
package com.codeassi;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kashraf
 *
 */
@RestController
@EnableAutoConfiguration
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {

	private static final String PATH = "/error";
	
	@RequestMapping(value="/error", method = RequestMethod.GET)
	public String error()
	{
		return "Error";
	}


	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}
