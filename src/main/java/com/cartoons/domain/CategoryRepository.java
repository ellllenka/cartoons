package com.cartoons.domain;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MyUser on 28.10.2015.
 */
public interface CategoryRepository extends CrudRepository<Category, String> {

}
