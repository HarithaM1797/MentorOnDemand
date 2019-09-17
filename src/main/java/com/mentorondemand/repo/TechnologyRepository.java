package com.mentorondemand.repo;

import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.Technologies;

public interface TechnologyRepository extends CrudRepository<Technologies, Long> {

}
