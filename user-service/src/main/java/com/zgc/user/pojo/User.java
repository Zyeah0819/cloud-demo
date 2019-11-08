package com.zgc.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Table(name = "user")
public class User {
    // 主键
    @Id
    @KeySql(useGeneratedKeys = true)/*ID自增*/
    private Long id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 姓名
    private String name;

    @Transient/*不是数据库语段，不需要持久化到数据库。*/
    private String text;
}
