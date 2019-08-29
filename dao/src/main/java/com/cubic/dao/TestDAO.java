package com.cubic.dao;

import com.cubic.dao.base.BaseDAO;
import com.cubic.model.Test;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TestDAO extends BaseDAO<Test> {
}
