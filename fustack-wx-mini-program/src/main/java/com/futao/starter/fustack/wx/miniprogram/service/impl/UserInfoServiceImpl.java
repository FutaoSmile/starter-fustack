//package com.futao.starter.fustack.wx.miniprogram.service.impl;
//
//import cn.hutool.crypto.SecureUtil;
//import cn.hutool.crypto.symmetric.AES;
//import com.futao.starter.fustack.wx.miniprogram.exception.WxMiniProgramException;
//import com.futao.starter.fustack.wx.miniprogram.service.UserInfoService;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
///**
// * @author futao
// * @date 2020/12/2
// */
//@Service
//public class UserInfoServiceImpl implements UserInfoService {
//
//    public void a(String rawData, String sessionKey, String signature) {
//        String s = SecureUtil.sha1(rawData + sessionKey);
//        System.out.println(s);
//        if (!s.equals(signature)) {
//            throw new WxMiniProgramException("检测到微信返回数据被篡改!");
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        String rawData = Files.readAllLines(Paths.get("/Users/futao/src/backend/my/starter-fustack/fustack-wx-mini-program/src/main/java/com/futao/starter/fustack/wx/miniprogram/service/impl/a.txt")).get(0);
//        System.out.println(rawData);
//        new UserInfoServiceImpl().a(rawData,
//                "75e81ceda165f4ffa64f4068af58c64b8f54b88c",
//                "");
//
//        new AES()
//    }
//}
