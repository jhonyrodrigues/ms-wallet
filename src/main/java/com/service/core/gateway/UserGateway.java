package com.service.core.gateway;

import com.service.core.domain.UserDomain;

public interface UserGateway {

    UserDomain register(UserDomain userDomain);

    UserDomain findByLogin(String login);

}
