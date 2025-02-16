package com.backend.boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.backend.entities.CalChickenEggs;
import com.backend.entities.User;


@Component
public interface CalChickenEggsDAO extends CrudRepository <CalChickenEggs, Integer> {
	Iterable<CalChickenEggs> findAllByUser(User user);
}


