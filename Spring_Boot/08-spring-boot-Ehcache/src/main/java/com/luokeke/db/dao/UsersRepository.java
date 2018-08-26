package com.luokeke.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luokeke.db.entity.Users;
/**
 * 参数一 T :当前需要映射的实体
 * 参数二 ID :当前映射的实体中的OID的类型
 *
 */
public interface UsersRepository extends JpaRepository<Users,Integer>{

}
