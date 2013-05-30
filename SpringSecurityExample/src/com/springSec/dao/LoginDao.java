package com.springSec.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LoginDao {

	@Autowired
	private JdbcDaoSupport daoSupport;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	private void insertUser(String userId, String password) {
		String sql="use praline " +
				"INSERT INTO UserTable(userId, password, permit) "+
				"VALUES(?, ?, 1)";
		daoSupport.getJdbcTemplate().update(sql, userId, passwordEncoder.encodePassword(password, null));
	}

	private void insertAuthority(String userId) {
		String sql="use praline " +
				"INSERT INTO Authorities(userid, authority) "+
				"VALUES(?, ?)";
		daoSupport.getJdbcTemplate().update(sql.toString(), userId, "ROLE_USER");
	}
	
	@Transactional
	public void makeAccount(String userId, String password) {
		insertUser(userId, password);
		insertAuthority(userId);
	}
}
