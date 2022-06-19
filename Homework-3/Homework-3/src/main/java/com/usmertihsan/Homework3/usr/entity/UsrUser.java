package com.usmertihsan.Homework3.usr.entity;

import com.usmertihsan.Homework3.gen.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "USR_USER")
public class UsrUser extends BaseEntity {

    @Id
    @SequenceGenerator(name ="UsrUser", sequenceName = "USR_USER_ID_SEQ")
    @GeneratedValue(generator = "UsrUser")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_LAST_NAME")
    private String userLastName;

    @Column(name = "USER_NICK_NAME")
    private String userNickName;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "USER_TELEPHONE_NUMBER")
    private String userTelephoneNumber;


}
