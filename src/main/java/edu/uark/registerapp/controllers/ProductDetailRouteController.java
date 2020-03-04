package edu.uark.registerapp.controllers;

import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.products.ProductQuery;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.entities.ActiveUserEntity;

@Controller
@RequestMapping(value = "/productDetail")
public class ProductDetailRouteController extends BaseRouteController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(final HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(ViewNames.PRODUCT_DETAIL.getViewName())
			.addObject(
				ViewModelNames.PRODUCT.getValue(),
				(new Product()).setLookupCode(StringUtils.EMPTY).setCount(0));
				
		final Optional<ActiveUserEntity> activeUserEntity =
			this.getCurrentUser(request);
		if (!activeUserEntity.isPresent()) {
			//No active user, Change to route to sign-in page
			//this.buildInvalidSessionResponse();
			//return this.buildNoPermissionsResponse("/productListing");
		}
	
		modelAndView.addObject(
			"isElevatedUser",
			false);
			//this.isElevatedUser(activeUserEntity.get())

		return modelAndView;		
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ModelAndView startWithProduct(@PathVariable final UUID productId, 
											final HttpServletRequest request) {
		final ModelAndView modelAndView =
			new ModelAndView(ViewNames.PRODUCT_DETAIL.getViewName());

		//Set user elevation
		final Optional<ActiveUserEntity> activeUserEntity =
			this.getCurrentUser(request);
		if (!activeUserEntity.isPresent()) {
			//No active user, Change to route to sign-in page
			//this.buildInvalidSessionResponse();
			//return this.buildNoPermissionsResponse("/productListing");
		}
	
		modelAndView.addObject(
			"isElevatedUser",
			false);
			//this.isElevatedUser(activeUserEntity.get())

		try {
			modelAndView.addObject(
				ViewModelNames.PRODUCT.getValue(),
				this.productQuery.setProductId(productId).execute());
		} catch (final Exception e) {
			modelAndView.addObject(
				ViewModelNames.ERROR_MESSAGE.getValue(),
				e.getMessage());
			modelAndView.addObject(
				ViewModelNames.PRODUCT.getValue(),
				(new Product())
					.setCount(0)
					.setLookupCode(StringUtils.EMPTY));
		}

		return modelAndView;
	}

	// Properties
	@Autowired
	private ProductQuery productQuery;
}
