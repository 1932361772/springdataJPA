package cn.itmuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itmuch.entity.UserSpring;

public interface UserRepositoryextendsjparepository extends JpaRepository<UserSpring, Integer> {
	

}
