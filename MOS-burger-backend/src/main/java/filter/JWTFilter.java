package filter;

import edu.icet.ecom.entity.UserEntity;
import edu.icet.ecom.repository.UserDao;
import edu.icet.ecom.service.jwt.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@Slf4j
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final UserDao userDao;

    @Override
    protected void  doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (authorization == null){
            log.debug("authorization was null");
            filterChain.doFilter(request,response);
            return;
        }

        if (!authorization.startsWith("Bearer ")){
            log.info("{} 's request was not Bearer is was {}",request.getRemoteAddr(),authorization);
            filterChain.doFilter(request,response);
            return;
        }

        String token = authorization.split(" ")[1];
        String username = jwtService.getUsername(token);
        if (username == null){
            filterChain.doFilter(request,response);
            return;
        }

        UserEntity user = userDao.findByUsername(username);

        if(user == null){
            filterChain.doFilter(request,response);
            return;
        }

        if(SecurityContextHolder.getContext().getAuthentication() != null){
            filterChain.doFilter(request,response);
        }

        UserDetails build = User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(build, null, build.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request,response);
    }
}
