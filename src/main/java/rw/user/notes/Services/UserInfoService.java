package rw.user.notes.Services;

import java.util.List;
import java.util.UUID;

import rw.user.notes.model.UserInfo;

public interface UserInfoService {
	
	String NAME = "UserInfoServiceImp";
	
	
	public List<UserInfo> getAllUserInfo();
    public UserInfo getUserInfoById(UUID id);
    public UserInfo AddNewUserInfo(UserInfo userInfo);
    public UserInfo updateUserInfo(UserInfo updatedUserInfo);
    public void deleteUserInfo(UUID id);
}
