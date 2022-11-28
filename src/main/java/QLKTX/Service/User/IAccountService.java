package QLKTX.Service.User;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import QLKTX.Entity.User;

@Service
public interface IAccountService {
	
	public int AddAccount(User user);
	public User CheckAccount(User user);
	public List<User> GetAllUser();
	public int DeleteAccount(int id);
}
