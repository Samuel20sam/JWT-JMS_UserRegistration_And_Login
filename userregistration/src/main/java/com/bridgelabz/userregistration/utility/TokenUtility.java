package com.bridgelabz.userregistration.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.stereotype.Component;

@Component
public class TokenUtility {
    private static final String TOKEN_SECRET = "Administrator";

    public String createToken(int userId) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            return JWT.create().withClaim("user_Id", userId).sign(algorithm);
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
// Log Token Signing Failed
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Long decodeToken(String token) {
        Long user_Id;
//For Verification Algorithm
        Verification verification = null;
        try {
            verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        assert verification != null;
        JWTVerifier jwtverifier = verification.build();
//To Decode token
        DecodedJWT decodedjwt = jwtverifier.verify(token);
        Claim claim = decodedjwt.getClaim("user_Id");
        user_Id = claim.asLong();
        return user_Id;
    }
}