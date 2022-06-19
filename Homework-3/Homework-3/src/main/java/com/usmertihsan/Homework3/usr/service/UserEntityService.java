package com.usmertihsan.Homework3.usr.service;

import com.usmertihsan.Homework3.gen.service.BaseEntityService;
import com.usmertihsan.Homework3.usr.dao.UserDao;
import com.usmertihsan.Homework3.usr.entity.UsrUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service

public class UserEntityService extends BaseEntityService<UsrUser, UserDao> {


    public UserEntityService(UserDao userDao) {
        super(userDao);
    }

    public UsrUser findByUserNickName(String userNickName)

    {
        return getDao().findByUserNickName(userNickName);
    }



}
