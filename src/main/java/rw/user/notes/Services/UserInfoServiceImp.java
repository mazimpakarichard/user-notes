package rw.user.notes.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rw.user.notes.dao.UserInfoDao;
import rw.user.notes.model.UserInfo;

@Service(UserInfoService.NAME)
public class UserInfoServiceImp implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;
	private final PasswordEncoder passwordEncoder;


	public UserInfoServiceImp(UserInfoDao userInfoDao, PasswordEncoder passwordEncoder) {
		super();
		this.userInfoDao = userInfoDao;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<UserInfo> getAllUserInfo() {
		try {
		return userInfoDao.findAll();
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public UserInfo getUserInfoById(UUID id) {
		try {
	
			return userInfoDao.getById(id);
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	@Override
	public UserInfo AddNewUserInfo(UserInfo userInfo) { try {
		String encodedPassword = passwordEncoder.encode(userInfo.getPassword());
		userInfo.setPassword(encodedPassword);
		return userInfoDao.save(userInfo);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	
	}

	@Override
	public void deleteUserInfo(UUID id) {
		try {
			userInfoDao.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public UserInfo updateUserInfo(UserInfo updatedUserInfo) {
		try {
			
			return userInfoDao.save(updatedUserInfo);
		} catch (Exception e) {
			throw e;
		}
		
		 
	}


}
