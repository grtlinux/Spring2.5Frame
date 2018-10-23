package kame.spring.store.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kame.spring.store.domain.PlaceOrderService;
import kame.spring.store.domain.PurchaseOrderRequest;
import kame.spring.store.domain.PurchaseOrderResult;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class PlaceOrderController extends SimpleFormController {

	private PlaceOrderService placeOrderService;

	public void setPlaceOrderService(PlaceOrderService placeOrderService) {
		this.placeOrderService = placeOrderService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		PurchaseOrderRequest orderRequest = (PurchaseOrderRequest) command;
		PurchaseOrderResult orderResult = placeOrderService.order(orderRequest);

		ModelAndView mav = new ModelAndView();
		mav.setViewName(getSuccessView());
		mav.addAllObjects(errors.getModel());
		mav.addObject("orderResult", orderResult);
		return mav;
	}

}
