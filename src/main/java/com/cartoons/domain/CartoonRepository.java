package com.cartoons.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by MyUser on 20.10.2015.
 */
public interface CartoonRepository extends PagingAndSortingRepository<Cartoon, Long> {

}

