package com.example.common.constant;

import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

/**
 * @author: dj
 * @create: 2021-06-23 09:54
 * @description:
 **/
public class SysConstant {

    private static final String KEY = "tdr88888la666666";

    public static final SymmetricCrypto AES = new SymmetricCrypto(SymmetricAlgorithm.AES, KEY.getBytes());

}
