package com.usmertihsan.Homework3.usr.dao;

import com.usmertihsan.Homework3.usr.entity.UsrUser;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface UserDao extends JpaRepositoryImplementation<UsrUser,Long> {

    UsrUser findByUserNickName(String userNickName);
}
