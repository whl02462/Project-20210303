package cn.ekgc.socip.user.service;

import cn.ekgc.socip.pojo.entity.user.User;

/**
 * <b>智慧公务车信息平台-用户员功能业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UserService {
	/**
	 * <b>根据 Token 获得用户信息</b>
	 * @param token
	 * @return
	 * @throws Exception
	 */
	User getUserByToken(String token) throws Exception;
}
