package com.andrezorek.forumhub.infra;

import com.andrezorek.forumhub.model.UsuarioForum;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.jwt.token.secret}")
    private String tokenGenerationSecret;

    public String gerarToken(UsuarioForum user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(tokenGenerationSecret);
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

    public String validateTokenReturnSubject(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(tokenGenerationSecret);
            return JWT.require(algorithm)
                    .withIssuer("com.ForumHub")
                    // reusable verifier instance
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou expirado : ", exception);

        }
    }

    private static Instant expireDate() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
