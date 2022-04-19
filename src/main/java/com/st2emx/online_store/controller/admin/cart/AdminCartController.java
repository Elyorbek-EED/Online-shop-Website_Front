package com.st2emx.online_store.controller.admin.cart;

import com.st2emx.online_store.controller.AbstractController;
import com.st2emx.online_store.service.admin.cart.AdminCartService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * created by Elyor Ergashov
 *
 * @Author : elyor
 * @Date : 02/04/22
 * @Project : CazoStoreSite
 */
@RestController
@RequestMapping(value = "/admin/cart/*")
public class AdminCartController extends AbstractController<AdminCartService> {


    public AdminCartController(AdminCartService service) {
        super(service);
    }


    @RequestMapping(value = "getCarts", method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("carts", service.getCards());
        modelAndView.addObject("sumCartPrice", service.sumCartPrice());

        modelAndView.setViewName("admin/cart/shoping_cart");
        return modelAndView;
    }

    @RequestMapping(value = "delete/{id}/{userId}", method = RequestMethod.GET)
    public ModelAndView delete( @PathVariable Long id) {
        service.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("carts", service.getCards());
        modelAndView.addObject("sumCartPrice", service.sumCartPrice());
        modelAndView.setViewName("admin/cart/shoping_cart");
        return modelAndView;
    }


}

