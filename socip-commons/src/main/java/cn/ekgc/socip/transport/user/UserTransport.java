package cn.ekgc.socip.transport.user;

import cn.ekgc.socip.pojo.entity.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b>智慧公务车信息平台-用户员功能传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "socip-system-provider")
@RequestMapping("/user/transport")
public interface UserTransport {

	/**
	 * <b>根据 Token 获得当前登录用户信息</b>
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/token")
	User getUserByToken(String token) throws Exception;
}
