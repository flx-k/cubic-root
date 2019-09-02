package com.cubic.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServiceImp {

    boolean add(Object obj);
    boolean delete(Object delete);
    boolean update(Object update);
    List<Object> select(Object select);
    Object get(Object select);

}
