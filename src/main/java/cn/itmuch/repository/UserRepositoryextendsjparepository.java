package cn.itmuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itmuch.entity.UserSpringDataJpa;

public interface UserRepositoryextendsjparepository extends JpaRepository<UserSpringDataJpa, Integer> {
	

}
