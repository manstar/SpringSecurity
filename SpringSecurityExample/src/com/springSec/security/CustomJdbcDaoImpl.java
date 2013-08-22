package com.springSec.security;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.springSec.model.UserInfoVO;



@Component
public class CustomJdbcDaoImpl implements UserDetailsService {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();


	private Collection<? extends GrantedAuthority> getUserAuthorities(List<UserInfoVO> authorities) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
		int size = authorities.size();
		for (int idx = 0; idx < size; idx++) {
			authList.add(new GrantedAuthorityImpl(authorities.get(idx).getAuthority()));
		}
		return authList;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserInfoVO> authorities = new ArrayList<UserInfoVO>();
		UserInfoVO userVO = new UserInfoVO();
		userVO.setUserId(username);
		userVO = (UserInfoVO) sqlMapClientTemplate.queryForObject("login.getUserInfo", userVO);
		
		return new User(userVO.getPrinciple().toString(), userVO.getPassword(), true, true, true, true, getUserAuthorities(authorities));
	}

}
