package com.cubic.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class PlugService {
    public abstract Object create(Object t);
    public abstract Object getOne(Object o);
    public abstract List sql_select(Object t);
    public abstract Boolean update(Object t);
}
