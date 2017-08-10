package cn.itmuch.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.itmuch.entity.UserSpring;

public interface UserRepositoryExtendspagingandsorting extends PagingAndSortingRepository<UserSpring, Integer> {

}
