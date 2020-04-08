package club.huangliang.service.impl;

import club.huangliang.dao.DeptDao;
import club.huangliang.entities.Dept;
import club.huangliang.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept getDept(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> getAll() {
        return deptDao.findAll();
    }
}
