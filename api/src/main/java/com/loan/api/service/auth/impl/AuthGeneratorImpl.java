package com.loan.api.service.auth.impl;

import com.loan.api.service.auth.IAuthGenerator;
import com.loan.common.Constants.Keys;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by shuttle on 6/28/17.
 */
public class AuthGeneratorImpl implements IAuthGenerator {

    public String JwtGenerate(long id){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256 ;
        long nowMillis = System. currentTimeMillis();
        Date now = new Date( nowMillis);
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts. builder()
                .setId(id + "")
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, key);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 3);
        builder.setExpiration(c.getTime());
        return builder.compact();
    }

    /**
     * 由字符串生成加密key
     * @return
     */
    private SecretKey generalKey(){
        String stringKey = Keys.JWT_KEY;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public String validJwt(String token){
        return null;
    }
}
