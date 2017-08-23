package com.loan.api.service.auth;

/**
 * Created by shuttle on 6/28/17.
 */
public interface IAuthGenerator {
    public String JwtGenerate(long id);

    public String validJwt(String token);
}
