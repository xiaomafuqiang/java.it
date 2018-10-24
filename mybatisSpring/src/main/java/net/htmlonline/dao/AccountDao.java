package net.htmlonline.dao;

import net.htmlonline.domain.Account;

public interface AccountDao {
    // 根据 id 查询用户信息
    public Account findUserById(int id);
}
