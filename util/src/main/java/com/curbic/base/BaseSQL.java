package com.curbic.base;
import org.apache.ibatis.jdbc.SQL;
import java.lang.reflect.Field;

public class BaseSQL {
    public String buildSql(final String sql){
        return sql;
    }
    public String insert(final Object obj) throws IllegalAccessException {
        Class cla=obj.getClass();
        SQL sql=new SQL();
        sql.INSERT_INTO(StringUtil.upper2Lower(cla.getSimpleName()));
        Field[] fields=cla.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            if(null!=field.get(obj)){
                sql.VALUES(StringUtil.upper2Lower(field.getName()),"#{"+field.getName()+"}");
            }
        }
        System.out.println(sql.toString());
        return sql.toString();
    }
    public String update(final SimpleParam param){
        SQL sql=new SQL();
        sql.UPDATE(StringUtil.upper2Lower(param.getClassName()));
        for(String key:param.getSet().keySet()){
            sql.SET(key+"='"+param.getSet().get(key)+"'");
        }
        for(String key:param.getWhere().keySet()){
            sql.WHERE(key+"='"+param.getWhere().get(key)+"'");
        }
        System.out.println(sql.toString());
        return sql.toString();
    }
    public String select(final SimpleParam param) {
        SQL sql=new SQL();
        for (String str:param.getFields()){
            sql.SELECT(StringUtil.upper2Lower(str));
        }
        sql.FROM(StringUtil.upper2Lower(param.getClassName()));
        for(String key:param.getWhere().keySet()){
            if(key.equals("eq")){
                sql.WHERE(key+"='"+param.getWhere().get(key)+"'");
            }
        }
        System.out.println(sql.toString());
        return sql.toString();
    }



}
