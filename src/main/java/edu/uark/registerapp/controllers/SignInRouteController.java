package edu.uark.registerapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.employees.helpers.ActiveEmployeeExistsQuery;
import edu.uark.registerapp.commands.employees.helpers.EmployeeSignInCommand;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.EmployeeSignIn;

@Controller
@RequestMapping(value = "/")
public class SignInRouteController extends BaseRouteController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(@RequestParam final Map<String, String> signIn) {
		
		final ModelAndView modelAndView = new ModelAndView(ViewNames.SIGN_IN.getRoute());

		ActiveEmployeeExistsQuery activeEmp = new ActiveEmployeeExistsQuery();
		boolean active = activeEmp.query();

		if (active) {

			return modelAndView;
		}

		else {

			return new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getRoute());
		}

	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView performSignIn(final EmployeeSignIn employee, final HttpServletRequest request ) {

		final EmployeeSignInCommand empSignIn = new EmployeeSignInCommand(employee, request.getRequestedSessionId());

		if (!empSignIn.validate()) {

			final ModelAndView signInError = new ModelAndView(ViewNames.SIGN_IN.getViewName());
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
