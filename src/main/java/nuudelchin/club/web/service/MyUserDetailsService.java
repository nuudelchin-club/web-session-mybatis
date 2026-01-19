package nuudelchin.club.web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nuudelchin.club.web.dto.MyUserDetails;
import nuudelchin.club.web.entity.UserEntity;
import nuudelchin.club.web.mapper.UserMapper;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private final UserMapper userMapper;
	
	public MyUserDetailsService(UserMapper userMapper) {

        this.userMapper = userMapper;
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity userEntity = userMapper.selectByUsername(username);
		
		if (userEntity != null) {
			
			return new MyUserDetails(userEntity);
		}
		
		return null;
	}

}
