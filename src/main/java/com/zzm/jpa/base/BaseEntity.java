package com.zzm.jpa.base;

import lombok.Data;

/**
 * @ClassName: BaseEntity
 * @Description: TODO
 * @Author: 邹智敏
 * @Date: 2018/8/13   15:07
 * @Version: 1.0
 */
@Data
public class BaseEntity {
    /**
     * <p>
     * 分页页码,默认页码为1
     * <p>
     */
    protected int page = 1;

    /**
     * <p>
     * 分页每页数量,默认20条
     * <p>
     */
    protected int size = 20;

    /**
     * <p>
     * 排序列名称,默认为id
     * <p>
     */
    protected String sidx = "id";

    /**
     * <p>
     * 排序正序
     * <p>
     */
    protected String sord = "asc";
}
