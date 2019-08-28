package com.cubic.dao;

import com.curbic.base.BaseSQL;
import com.curbic.base.SimpleParam;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface BaseDAO<T> {
    @InsertProvider(type = BaseSQL.class, method = "insert")
    void insert(T obj);
    @InsertProvider(type = BaseSQL.class, method = "buildSql")
    void sql_insert(String sql);

    @UpdateProvider(type = BaseSQL.class, method = "update")
    void update(SimpleParam simpleParam);
    @UpdateProvider(type = BaseSQL.class, method = "buildSql")
    void sql_update(String sql);

    @SelectProvider(type = BaseSQL.class, method = "select")
    List<T> select(SimpleParam simpleParam);
    @SelectProvider(type = BaseSQL.class, method = "buildSql")
    List<T> sql_select(String sql);
}
