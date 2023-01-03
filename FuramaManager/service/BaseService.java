package m2_case_study.FuramaManager.service;

import java.util.List;

public interface BaseService<T> {
    void save(T t);
    List<T> findAll();
}