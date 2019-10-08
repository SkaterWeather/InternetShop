package internetshop.controller.filter;

import static internetshop.model.Role.RoleName.ADMIN;
import static internetshop.model.Role.RoleName.USER;

import internetshop.annotation.Inject;
import internetshop.model.Role;
import internetshop.model.User;
import internetshop.service.UserService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationFilter implements Filter {
    @Inject
    private static UserService userService;
    private Map<String, Role.RoleName> protectedUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        protectedUrls = new HashMap<>();
        protectedUrls.put("/users", ADMIN);

        protectedUrls.put("/bucket", USER);
        protectedUrls.put("/add-to-bucket", USER);
        protectedUrls.put("/delete-from-bucket", USER);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI().replace(req.getContextPath(), "");
        Role.RoleName roleName = protectedUrls.get(url);
        if (roleName == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("mate")) {
                Optional<User> user = userService.getByToken(cookie.getValue());
                if (user.isPresent()) {
                    if (verifyRole(user.get(), roleName)) {
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        processDenied(req, resp);
                    }
                    return;
                }
            }
        }
        processDenied(req, resp);
    }

    private boolean verifyRole(User user, Role.RoleName roleName) {
        return user.getRoles().stream().anyMatch(s -> s.getRoleName().equals(roleName));
    }

    private void processDenied(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/view/denied.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {}
}
