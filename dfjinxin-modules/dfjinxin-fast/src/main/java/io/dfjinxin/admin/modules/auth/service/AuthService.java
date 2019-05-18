package io.dfjinxin.admin.modules.auth.service;

import com.dfjinxin.auth.common.util.jwt.JwtAuthenticationRequest;

public interface AuthService {

    String userAuth(JwtAuthenticationRequest authReq);
}
