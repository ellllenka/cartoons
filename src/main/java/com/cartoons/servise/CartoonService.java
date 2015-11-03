package com.cartoons.servise;

import com.cartoons.domain.Cartoon;
import com.cartoons.domain.CartoonRepository;
import com.cartoons.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by MyUser on 20.10.2015.
 */
@Service
public class CartoonService {

    @Autowired
    private CartoonRepository cartoonRepository;

    public Cartoon getCartoon (long id){
        return cartoonRepository.findOne(id);
    }

    public long addCartoon(Cartoon cartoon){;
        cartoonRepository.save(cartoon);
        return cartoon.getId();
    }

    public void changeView(long id, boolean viewed){
        Cartoon cartoon = cartoonRepository.findOne(id);
        cartoon.setViewed(viewed);
        cartoonRepository.save(cartoon);
    }

    // метод findAll для категорий

    public void dellCartoon(long id){
       cartoonRepository.delete(id);
    }

    public Iterable<Cartoon> getCartoons(Sort var1){
        return cartoonRepository.findAll(var1);
    }


}
