package com.cubic.dao.game;

import com.cubic.dao.base.BaseDAO;
import com.cubic.model.Test;
import com.cubic.model.game.Player;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlayerDAO extends BaseDAO<Player> {
    @Select("select * from player where account = #{account}")
    List<Player> getByAccount(String account);
}
