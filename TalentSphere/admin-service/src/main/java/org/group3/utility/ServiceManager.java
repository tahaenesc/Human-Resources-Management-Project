package org.group3.utility;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ServiceManager<T, ID> implements IService<T, ID>{

    private final JpaRepository<T, ID> jpaRepository;

    public ServiceManager(JpaRepository<T, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }



    @Override
    public T save(T t) {
        Long time=System.currentTimeMillis();
//        t.setCreatedDate(time);
//        t.setUpdateAt(time);
//        t.setState(true);
        return jpaRepository.save(t);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> t) {
        Long time=System.currentTimeMillis();
//        t.forEach(x->{
//            x.setCreateAt(time);
//            x.setUpdateAt(time);
//            x.setState(true);
//        });
        return jpaRepository.saveAll(t);
    }

    @Override
    public T update(T t) {
//        t.setUpdateAt(System.currentTimeMillis());
        return jpaRepository.save(t);
    }

    @Override
    public void delete(T t) {
        jpaRepository.delete(t);
    }

    @Override
    public void deleteById(ID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }
}
