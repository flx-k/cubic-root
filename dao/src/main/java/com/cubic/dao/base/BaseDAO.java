package com.cubic.dao.base;

import com.cubic.base.BaseSQL;
import com.cubic.base.SimpleParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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
    @SelectProvider(type = BaseSQL.class, method = "count")
    Long count(SimpleParam simpleParam);
    @SelectProvider(type = BaseSQL.class, method = "buildSql")
    Long sql_count(String sql);
    @SelectProvider(type = BaseSQL.class, method = "buildSql")
    List<Class<?>> sql_select(String sql);
    @SelectProvider(type = BaseSQL.class, method = "buildSql")
    T get(String sql);
    @SelectProvider(type = BaseSQL.class, method = "getOne")
    T getOne(T obj);

}
