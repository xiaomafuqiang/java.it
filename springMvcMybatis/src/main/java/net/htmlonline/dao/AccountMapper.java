package net.htmlonline.dao;

import net.htmlonline.domain.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    // Account selectAccount(Integer id);
    Account selectAccount(@Param("id") int id);
}
