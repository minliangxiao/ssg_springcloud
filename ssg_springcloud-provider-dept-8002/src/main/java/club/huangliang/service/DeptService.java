package club.huangliang.service;

import club.huangliang.entities.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeptService {
    boolean add(Dept dept);

    Dept getDept(Long id);

    List<Dept> getAll();

}
