package com.dfjinxin.admin.modules.auth.service;

import com.dfjinxin.auth.common.util.jwt.JwtAuthenticationRequest;
import com.dfjinxin.common.exception.auth.UserInvalidException;

public interface AuthService {

    String userAuth(JwtAuthenticationRequest authReq);

}
