package nuudelchin.club.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import nuudelchin.club.web.dto.JoinDTO;
import nuudelchin.club.web.entity.UserEntity;
import nuudelchin.club.web.repository.UserRepository;

@Service
public class JoinService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public void joinProc(JoinDTO dto) {


    	UserEntity userEntity = userRepository.findByUsername(dto.getUsername());
        if (userEntity == null) {
        	
        	userEntity = new UserEntity();

        	userEntity.setUsername(dto.getUsername());
        	userEntity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        	userEntity.setRole("ROLE_ADMIN");

            userRepository.save(userEntity);
        }
    }
}
