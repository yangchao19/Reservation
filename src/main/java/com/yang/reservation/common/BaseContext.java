package com.yang.reservation.common;

/**
 * @description: 用户保存当前用户的id（ThreadLocal）
 * @author：杨超
 * @date: 2023/6/2
 * @Copyright：
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
