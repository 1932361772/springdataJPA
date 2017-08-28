package cn.itmuch.repository;

import org.springframework.data.repository.CrudRepository;

import cn.itmuch.entity.IdCard;
import cn.itmuch.entity.Person;

public interface PersonRepositoryExtCRUD extends CrudRepository<Person,Integer> {
	

}
