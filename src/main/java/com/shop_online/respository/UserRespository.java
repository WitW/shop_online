package com.shop_online.respository;

import com.shop_online.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRespository extends JpaRepository<User, String> {
    /**
     * 通过email和密码查询是否存在用户
     * @param email
     * @param password
     * @return
     */
    public User findUserByEmailAndPassword(String email, String password);
    public List<User> findUserByEmail(String email);
}
