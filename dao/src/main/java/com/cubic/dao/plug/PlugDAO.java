package com.cubic.dao.plug;

import com.cubic.util.base.BaseSQL;
import com.cubic.util.base.SimpleParam;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
import java.util.Map;

public interface PlugDAO {
    @InsertProvider(type = BaseSQL.class, method = "insert")
    void insert(Object obj);
    @InsertProvider(type = BaseSQL.class, method = "buildSql")
    void sql_insert(String sql);

    @UpdateProvider(type = BaseSQL.class, method = "update")
    void update(SimpleParam simpleParam);
    @UpdateProvider(type = BaseSQL.class, method = "buildSql")
    void sql_update(String sql);

    @SelectProvider(type = BaseSQL.class, method = "select")
    List<Map<String,Object>> select(SimpleParam simpleParam);
    @SelectProvider(type = BaseSQL.class, method = "count")
    Long count(SimpleParam simpleParam);
    @SelectProvider(type = BaseSQL.class, method = "buildSql")
    Long sql_count(String sql);
    @SelectProvider(type = BaseSQL.class, method = "buildSql")
    List<Map<String,Object>> sql_select(String sql);

    @SelectProvider(type = BaseSQL.class, method = "buildSql")
    Map<String,Object> get(String sql);

    @SelectProvider(type = BaseSQL.class, method = "getOne")
    Object getOne(Object obj);
}
