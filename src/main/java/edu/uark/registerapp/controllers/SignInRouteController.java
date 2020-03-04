package edu.uark.registerapp.controllers;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.EmployeeSignIn;
import edu.uark.registerapp.models.entities.ActiveUserEntity;

@Controller
@RequestMapping(value = "/")
public class SignInRouteController extends BaseRouteController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(@RequestParam Map<String, String> signIn,  HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(ViewNames.SIGN_IN.getRoute());
				
		final Optional<ActiveUserEntity> activeUserEntity =
			this.getCurrentUser(request);
		if (!activeUserEntity.isPresent()) {
			ModelAndView modelAndView2 = new ModelAndView(ViewNames.SIGN_IN.getRoute());
			//this.buildInvalidSessionResponse();
			//return this.buildNoPermissionsResponse("/signIn");
		}
	
		modelAndView.addObject(
			"isElevatedUser",
			false);
			//this.isElevatedUser(activeUserEntity.get())

		return modelAndView;		
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView performSignIn(EmployeeSignIn employee, 
		// TODO: Define an object that will represent the sign in request and add it as a parameter here
		HttpServletRequest request 
	) {

		// TODO: Use the credentials provided in the request body
		//  and the "id" property of the (HttpServletRequest)request.getSession() variable
		//  to sign in the user

		return new ModelAndView(
			REDIRECT_PREPEND.concat(
				ViewNames.MAIN_MENU.getRoute()));
	}
}
