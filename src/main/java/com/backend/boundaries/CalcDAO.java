package com.backend.boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.backend.entities.Calculator;
//import com.backend.entities.User;


@Component
public interface CalcDAO extends CrudRepository <Calculator, Integer> {
//	Iterable<Calculator> findAllByUser(User user);
}


