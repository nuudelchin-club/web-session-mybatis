package nuudelchin.club.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import nuudelchin.club.web.dto.JoinDTO;
import nuudelchin.club.web.entity.UserEntity;
import nuudelchin.club.web.mapper.UserMapper;

@Service
public class JoinService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public void joinProc(JoinDTO dto) {


    	UserEntity userEntity = userMapper.selectByUsername(dto.getUsername());
        if (userEntity == null) {
        	
        	userEntity = new UserEntity();

        	userEntity.setUsername(dto.getUsername());
        	userEntity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        	userEntity.setRole("ROLE_ADMIN");

            userMapper.insert(userEntity);
        }
    }
}
