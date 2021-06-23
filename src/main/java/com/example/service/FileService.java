package com.example.service;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.example.common.constant.SysConstant;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author: dj
 * @create: 2021-06-23 10:03
 * @description:
 **/
@Service
public class FileService {

    public String getFileEncryptHex(String content) {
        return SysConstant.AES.encryptHex(content);
    }

    /**
     * 解密数据获取文件地址
     *
     * @param encryptHex 加密数据
     * @return 文件地址
     */
    public String getFilePath(String encryptHex) {
        return SysConstant.AES.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
    }

}
