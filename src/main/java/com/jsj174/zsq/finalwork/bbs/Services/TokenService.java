package com.jsj174.zsq.finalwork.bbs.Services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jsj174.zsq.finalwork.bbs.Models.User;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(user.getUserID() + "")
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public int decodeToken(String token) {

        return Integer.parseInt(JWT.decode(token).getAudience().get(0));

    }
}
