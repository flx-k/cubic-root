package com.cubic.dao.game;

import com.cubic.dao.base.BaseDAO;
import com.cubic.model.Test;
import com.cubic.model.game.Monster;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MonsterDAO extends BaseDAO<Monster> {
}
