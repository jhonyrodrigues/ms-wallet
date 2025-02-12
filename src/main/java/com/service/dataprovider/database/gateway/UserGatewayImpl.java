package com.service.dataprovider.database.gateway;

import com.service.core.domain.UserDomain;
import com.service.core.gateway.UserGateway;
import com.service.dataprovider.database.entity.UserEntity;
import com.service.dataprovider.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;

    public UserGatewayImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDomain register(final UserDomain userDomain) {
        var user = userRepository.save(new UserEntity(userDomain.getLogin(), userDomain.getPassword(), userDomain.getRole()));
        return new UserDomain(user.getUsername(), user.getRole());
    }

    @Override
    public UserDomain findByLogin(final String login) {
        var user = userRepository.findByEmail(login);
        if (user != null) {
            return new UserDomain(user.getUsername(), user.getRole());
        }
        return null;
    }
}
