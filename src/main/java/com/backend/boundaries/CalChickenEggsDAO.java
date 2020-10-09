package com.backend.boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.backend.entities.CalChickenEggs;


@Component
public interface CalChickenEggsDAO extends CrudRepository <CalChickenEggs, Integer> {

}


