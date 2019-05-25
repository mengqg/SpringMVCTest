package com.springmvc04.part1.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.springmvc04.part1.entity.User;
import com.springmvc04.part1.service.NameOrPwdException;
import com.sun.istack.internal.logging.Logger;


@Repository("userDAO")
public class OracleUserDAO implements UserDAO, Serializable{
	private Logger mLogger = Logger.getLogger(OracleUserDAO.class);
	private JDBCDataSource dataSource;
	
	public OracleUserDAO() {
		mLogger.info("初始化OracleUserDAO");
	}

	public OracleUserDAO(JDBCDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Autowired
	public void setDataSource(@Qualifier("jdbcDataSource") JDBCDataSource dataSource) {
		mLogger.info("setDataSource");
		this.dataSource = dataSource;
	}
	public JDBCDataSource getDataSource() {
		return this.dataSource;
	}
	
	@Override
	public User findByName(String name) throws Exception {
		mLogger.info("利用JDBC技术查找User信息");
		Connection conn = null;
		StringBuffer pSql = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		pSql.append(" SELECT * FROM USERS WHERE NAME = ? ");
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(pSql.toString());
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("ID"));
				user.setName(rs.getString("NAME"));
				user.setPhone(rs.getString("PHONE"));
				user.setPwd(rs.getString("PWD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				dataSource.close(conn);
			}
		}
		return user;
	}
	
}
