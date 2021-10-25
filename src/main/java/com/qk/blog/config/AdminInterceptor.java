package com.qk.blog.config;

import com.qk.blog.common.BaseController;
import com.qk.blog.service.TokenService;
import com.qk.blog.vo.LoginUserVo;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qk
 * @since 2021/10/18 17:30
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Resource
    private TokenService tokenService;

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String requestServletPath = request.getServletPath();
        Object token = request.getSession().getAttribute("token");
        if (null == token) {
            request.getSession().setAttribute("errorMsg", "请重新登陆");
            response.sendRedirect(request.getContextPath() + "/user/toLogin");
            return false;
        } else {
            LoginUserVo loginUserVo = tokenService.getLoginInfo(token.toString());
            setLoginUser((HandlerMethod) handler, loginUserVo);
            request.getSession().removeAttribute("errorMsg");
            return true;
        }
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws ServletException, IOException {
        if (response.getStatus() == 500) {
            modelAndView.setViewName("/error/error_5xx");
            request.getRequestDispatcher("500.html").forward(request, response);
        } else if (response.getStatus() == 404) {
            modelAndView.setViewName("/error/error_404");
            request.getRequestDispatcher("404.html").forward(request, response);
        } else {
            modelAndView.setViewName("/error/error_400");
            request.getRequestDispatcher("400.html").forward(request, response);
        }
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    /**
     * 设置当前登录用户
     */
    private void setLoginUser(HandlerMethod handlerMethod, LoginUserVo loginUserVo) {
        if (null == loginUserVo) {
            return;
        }
        if (handlerMethod.getBean() instanceof BaseController) {
            BaseController baseController = (BaseController) handlerMethod.getBean();
            baseController.setLoginUser(loginUserVo);
        }
    }

}
