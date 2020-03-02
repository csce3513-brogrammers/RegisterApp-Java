package edu.uark.registerapp.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.registerapp.commands.products.ProductCreateCommand;
import edu.uark.registerapp.commands.products.ProductDeleteCommand;
import edu.uark.registerapp.commands.products.ProductUpdateCommand;
import edu.uark.registerapp.models.api.ApiResponse;
import edu.uark.registerapp.models.api.Product;

@RestController
@RequestMapping(value = "/api/product")
public class ProductRestController {
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody ApiResponse createProduct(
		@RequestBody final Product product
	) {

<<<<<<< HEAD
		final ApiResponse elevatedUserResponse =
			this.redirectUserNotElevated(
				request,
				response,
				ViewNames.PRODUCT_LISTING.getRoute());

		// if (!elevatedUserResponse.getRedirectUrl().equals(StringUtils.EMPTY)) {
		// 	return elevatedUserResponse;
		// }

=======
>>>>>>> parent of 2078ed9... Elevation Checks
		return this.productCreateCommand
			.setApiProduct(product)
			.execute();
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
	public @ResponseBody ApiResponse updateProduct(
		@PathVariable final UUID productId,
		@RequestBody final Product product
	) {

<<<<<<< HEAD
		// TODO: Verify that the user associated with the current session is elevated
		final ApiResponse elevatedUserResponse =
		this.redirectUserNotElevated(
			request,
			response,
			ViewNames.PRODUCT_LISTING.getRoute());

		// if (!elevatedUserResponse.getRedirectUrl().equals(StringUtils.EMPTY)) {
		// 	return this.productUpdateCommand
		// 	.setProductId(productId)
		// 	.setApiProduct(product)
		// 	.execute();
		// }
		
		return new ApiResponse();

=======
		return this.productUpdateCommand
			.setProductId(productId)
			.setApiProduct(product)
			.execute();
>>>>>>> parent of 2078ed9... Elevation Checks
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	public @ResponseBody ApiResponse deleteProduct(
		@PathVariable final UUID productId
	) {

<<<<<<< HEAD
		// TODO: Verify that the user associated with the current session is elevated
		final ApiResponse elevatedUserResponse =
		this.redirectUserNotElevated(
			request,
			response,
			ViewNames.PRODUCT_LISTING.getRoute());

		// if (!elevatedUserResponse.getRedirectUrl().equals(StringUtils.EMPTY)) {
		// 	this.productDeleteCommand
		// 	.setProductId(productId)
		// 	.execute();
		// }
=======
		this.productDeleteCommand
			.setProductId(productId)
			.execute();
>>>>>>> parent of 2078ed9... Elevation Checks

		return new ApiResponse();
	}

	// Properties
	@Autowired
	private ProductCreateCommand productCreateCommand;
	
	@Autowired
	private ProductDeleteCommand productDeleteCommand;
	
	@Autowired
	private ProductUpdateCommand productUpdateCommand;
}
