package com.backend.boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.backend.entities.CalChickenBroiler;
import com.backend.entities.CalChickenEggs;
import com.backend.entities.User;


@Component
public interface CalChickenBroilerDAO extends CrudRepository <CalChickenBroiler, Integer> {
	Iterable<CalChickenBroiler> findAllByUser(User user);
}


