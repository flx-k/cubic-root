package com.cubic.dao.base;

import com.cubic.base.BaseSQL;
import com.cubic.base.SimpleParam;
import org.apache.ibatis.annotations.*;

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
    @SelectProvider(type = BaseSQL.class, method = "buildSql")
    T get(String sql);
    @SelectProvider(type = BaseSQL.class, method = "getOne")
    T getOne(T obj);

}
