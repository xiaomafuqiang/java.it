package net.htmlonline.mapper;

import net.htmlonline.domain.Account;
import net.htmlonline.domain.AccountProxy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    // Account selectAccount(Integer id);
    Account selectAccount(@Param("id") int id);
    List<Account> selectAccountProxyList(@Param("proxy") AccountProxy proxy);

    List<Account> selectList();

    Integer insertAccount(Account account);

    Integer updateAccount(@Param("name") String name,@Param("money") Double money, @Param("id") int id);
}
