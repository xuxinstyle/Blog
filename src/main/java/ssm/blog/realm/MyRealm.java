package ssm.blog.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;
import ssm.blog.entity.Blogger;
import ssm.blog.service.BloggerService;
import ssm.blog.util.MD5Util;

import javax.annotation.Resource;

/**
 * @Author xuxin
 * @Description 自定义realm
 * @Date 
 * @
 */
public class MyRealm extends AuthorizingRealm{

	public static void main(String[] args) {
		System.out.println(MD5Util.md5("admin", "xuxin"));//设置登录密码为admin,加盐xuxin
	}
    @Resource
    private BloggerService bloggerService;


    /**
     * 为当前登陆的用户授予角色和权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //因为我们是个人博客 所以不存在角色权限
        return null;
    }

    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal(); //获取用户名
        Blogger blogger = bloggerService.getBloggerByName(username);   //重数据库查询用户信息
        
        //System.out.println(MD5Util.md5("admin", salt));
        
        if (blogger != null) {
            SecurityUtils.getSubject().getSession().setAttribute("currentUser", blogger);//把当前用户存到session中
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
                    blogger.getUserName(), blogger.getPassword(), "MyRealm");
            return authcInfo;
        } else {
            return null;
        }
    }
}
