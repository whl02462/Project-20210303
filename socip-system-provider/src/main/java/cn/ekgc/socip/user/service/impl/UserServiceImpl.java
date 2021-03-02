package cn.ekgc.socip.user.service.impl;

import cn.ekgc.socip.base.util.RedisUtil;
import cn.ekgc.socip.base.util.TokenUtil;
import cn.ekgc.socip.pojo.entity.user.User;
import cn.ekgc.socip.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>智慧公务车信息平台-用户员功能业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * <b>根据 Token 获得用户信息</b>
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@Override
	public User getUserByToken(String token) throws Exception {
		// 校验用户所给定的 token 有效
		if (TokenUtil.verifyToken(token) != null) {
			// Token 信息校验成功，那么根据 Token 在 Redis 中查找对象
			return (User) redisUtil.getFromRedis(token, User.class);
		}
		return null;
	}
}
