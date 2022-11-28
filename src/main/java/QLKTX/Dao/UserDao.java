package QLKTX.Dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import QLKTX.Entity.MapperUser;
import QLKTX.Entity.User;


@Repository
public class UserDao extends BaseDao{
	public int AddAccount(User user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO users ( ");
		sql.append("username, password, display_name, address, role ) ");
		sql.append("VALUES ( ");
		sql.append(" '"+user.getUsername()+"', '"+user.getPassword()+"', '"+user.getDisplay_name()+"', '"+user.getAddress()+"', '"+"User"+"' )");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public User GetUserByAccount(User user) {
		String sql = "SELECT * FROM users WHERE username = '"+user.getUsername()+"'";	
		User userDb = _jdbcTemplate.queryForObject(sql.toString(), new MapperUser()); 
		return userDb;
	}
	
	public List<User> GetAllUser() {
		String sql = "SELECT * FROM users ";	
		List<User> userDb = _jdbcTemplate.query(sql, new MapperUser()); 
		return userDb;
	}
	
	public int DeleteAccount(int id) {
		String sqlDelete = "DELETE FROM users WHERE users.id = " + id ;
		return _jdbcTemplate.update(sqlDelete);
	}
}
