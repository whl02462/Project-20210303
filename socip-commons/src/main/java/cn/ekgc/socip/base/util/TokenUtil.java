package cn.ekgc.socip.base.util;

import cn.ekgc.socip.base.pojo.vo.PageVO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <b>系统 Token 工具类</b>
 * @version 1.0.0
 * @since 1.0.0
 */
public class TokenUtil {
	private static Properties props = new Properties();

	static {
		try {
			// 加载位于 src 下的配置文件 props/base/base.properties
			props.load(PageVO.class.getClassLoader().getResourceAsStream("props/base/base.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Algorithm algorithm = Algorithm.HMAC256(props.getProperty("base.secret.key"));

	/**
	 * <b>使用给定的数据信息创建 Token</b>
	 * @param message
	 * @return
	 */
	public static String createToken(String message) {
		try {
			// 设置头部消息
			Map<String, Object> headerMap = new HashMap<String, Object>();
			headerMap.put("Type", "jwt");
			headerMap.put("alg", "HMAC256");

			// 获得过期时间
			Integer exipreMinute = Integer.parseInt(props.getProperty("base.expire.minute"));
			// 根据过期时间，计算过期的 Date 类型
			Date expireDate = new Date(new Date().getTime() + exipreMinute * 60 * 1000);

			// 设置生成的Token信息
			return JWT.create()
					.withHeader(headerMap)
					.withClaim("message", message)
					.withExpiresAt(expireDate)
					.sign(algorithm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <b>校验Token是否正确，并且获得对应的用户id</b>
	 * @param token
	 * @return
	 */
	public static String verifyToken(String token) {
		try {
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify(token);
			return jwt.getClaim("message").asString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
