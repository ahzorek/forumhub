package com.andrezorek.forumhub.infra;

import com.andrezorek.forumhub.model.UsuarioForum;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    public String gerarToken(UsuarioForum user){
        try {
            Algorithm algorithm = Algorithm.HMAC256("senhaAlgoHMAC");
            return JWT.create()
                    .withIssuer("com.ForumHub")
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    .withExpiresAt(expireDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar jwt token: ", exception);
        }

    }

    private static Instant expireDate() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
