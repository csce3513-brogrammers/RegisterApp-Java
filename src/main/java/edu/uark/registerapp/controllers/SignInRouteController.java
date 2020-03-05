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

import edu.uark.registerapp.commands.employees.helpers.ActiveEmployeeExistsQuery;
import edu.uark.registerapp.commands.employees.helpers.EmployeeSignInCommand;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.EmployeeSignIn;
import edu.uark.registerapp.models.entities.ActiveUserEntity;

@Controller
@RequestMapping(value = "/")
public class SignInRouteController extends BaseRouteController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(@RequestParam Map<String, String> signIn) {
		
		ModelAndView modelAndView = new ModelAndView(ViewNames.SIGN_IN.getViewName());

		ActiveEmployeeExistsQuery activeEmp = new ActiveEmployeeExistsQuery();
		boolean active = activeEmp.query();

		if (!active) {

			return new ModelAndView(
			REDIRECT_PREPEND.concat(
				ViewNames.MAIN_MENU.getRoute()));
		}

		else {

			return modelAndView;
		}

	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView performSignIn(EmployeeSignIn employee, HttpServletRequest request ) {

		// TODO: Use the credentials provided in the request body
		//  and the "id" property of the (HttpServletRequest)request.getSession() variable
		//  to sign in the user
		EmployeeSignInCommand empSignIn = new EmployeeSignInCommand(employee, request.getRequestedSessionId());
		if (!empSignIn.validate()) {
			ModelAndView signInError = new ModelAndView(ViewNames.SIGN_IN.getViewName());
			return signInError.addObject("errorMessage", true);
		}

		else {
			empSignIn.createActiveUser();
		
		return new ModelAndView(
			REDIRECT_PREPEND.concat(
				ViewNames.MAIN_MENU.getRoute()));
		}
	}


	
}
