package QLKTX.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUser implements RowMapper<User>{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setDisplay_name(rs.getString("display_name"));
		user.setAddress(rs.getString("address"));
		user.setRole(rs.getString("role"));
		return user;
	}
}
