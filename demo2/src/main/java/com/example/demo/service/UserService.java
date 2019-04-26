package com.example.demo.service;


import java.util.Map;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;

import com.example.demo.common.data.datamemory.DemoDataMemory;
import com.example.demo.common.data.dto.UserInfo;

/**
 * ログイン用のサービス.
 */
@Component
@Service
public class UserService {
    
    /**
     * ユーザ情報の取得する.
     * @param user ユーザID
     * @return ユーザ情報
     */
    public UserInfo getUserInfo(String user) {
    	
    	return DemoDataMemory.USER_INFO_MAP.get(user);
    }
    
    /**
     * 全ユーザ情報の取得する.
     * @return 全ユーザ情報
     */
    public Map<String, UserInfo> getAllUserInfo() {
    	
    	return DemoDataMemory.USER_INFO_MAP;
    }
}
