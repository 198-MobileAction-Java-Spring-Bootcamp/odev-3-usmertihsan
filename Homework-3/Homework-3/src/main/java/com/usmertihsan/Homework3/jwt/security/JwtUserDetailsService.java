package com.usmertihsan.Homework3.jwt.security;


import com.usmertihsan.Homework3.usr.entity.UsrUser;
import com.usmertihsan.Homework3.usr.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserEntityService userEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String userNickName = String.valueOf(username);
        UsrUser user = userEntityService.findByUserNickName(userNickName);

        return JwtUserDetails.create(user);
    }

    public UserDetails loadByUserId(Long id){

        UsrUser user = userEntityService.findByIdWithControl(id);

        return JwtUserDetails.create(user);
    }

}
