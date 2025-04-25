package com.zzm.jpa.bean;

import com.zzm.jpa.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName: UserEntity
 * @Description: TODO
 * @Author: 邹智敏
 * @Date: 2018/8/13   15:02
 * @Version: 1.0
 */
@Data
@Entity
@Table(name = "user_info")
public class UserEntity extends BaseEntity implements Serializable {
    /**
     * 用户编号
     */
    @Id
    @GenericGenerator(name = "user-uuid", strategy = "uuid")
    @GeneratedValue(generator = "user-uuid")
    @Column(name = "UI_ID")
    private String id;

    /**
     * 用户名称
     */
    @Column(name = "UI_USER_NAME")
    private String userName;

    /**
     * 姓名
     */
    @Column(name = "UI_NAME")
    private String name;

    /**
     * 年龄
     */
    @Column(name = "UI_AGE")
    private int age;

    /**
     * 余额
     */
    @Column(name = "UI_BALANCE")
    private BigDecimal balance;
}
