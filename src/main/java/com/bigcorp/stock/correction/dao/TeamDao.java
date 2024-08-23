package com.bigcorp.stock.correction.dao;

import com.bigcorp.stock.correction.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamDao extends CrudRepository<Team,Long> {
}
