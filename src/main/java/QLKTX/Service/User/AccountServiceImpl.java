package QLKTX.Service.User;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QLKTX.Dao.UserDao;
import QLKTX.Entity.User;

@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	private UserDao userDao;

	public int AddAccount(User user) {					
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(6)));
		return userDao.AddAccount(user);					
	}

	public User CheckAccount(User user) {
		String pass = user.getPassword();
		user = userDao.GetUserByAccount(user);
		if(user != null) {
			if(BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			}
			else {
				return null;
			}			
		}	
		return null;
	}

	public List<User> GetAllUser() {
		return userDao.GetAllUser();
	}

	public int DeleteAccount(int id) {
		return userDao.DeleteAccount(id);
	}
}
