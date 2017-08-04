package cn.itmuch.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.itmuch.entity.UserSpringDataJpa;

public interface UserRepositoryExtendspagingandsorting extends PagingAndSortingRepository<UserSpringDataJpa, Integer> {

}
