package com.cartoons.controller;

import com.cartoons.domain.Cartoon;
import com.cartoons.domain.Category;
import com.cartoons.servise.CartoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by MyUser on 20.10.2015.
 */

@Controller
public class CartoonController {

    @Autowired
    private CartoonService cartoonService;

    @RequestMapping(value = "/cartoon", method = RequestMethod.GET)
    @ResponseBody
    public Cartoon getCartoon (long id){
        return cartoonService.getCartoon(id);
    }

    @RequestMapping(value = "/cartoon", method = RequestMethod.POST)
    @ResponseBody
    public long addCartoon(@RequestBody Cartoon cartoon){
        return cartoonService.addCartoon(cartoon);
    }

    @RequestMapping(value = "/cartoon", method = RequestMethod.DELETE)
    @ResponseBody
    public void dellCartoon (long id) {
        cartoonService.dellCartoon(id);
    }

    @RequestMapping(value = "/cartoon/viewed", method = RequestMethod.PUT)
    @ResponseBody
    public void changeView(long id, boolean viewed){
        cartoonService.changeView(id, viewed);
    }

    @RequestMapping(value = "/cartoons", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Cartoon> getCartoons(Sort var1){
        return cartoonService.getCartoons(var1);
    }
}

