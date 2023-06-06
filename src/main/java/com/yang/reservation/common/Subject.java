package com.yang.reservation.common;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @description: 课程类型
 * @author：杨超
 * @date: 2023/6/5
 * @Copyright：
 */
@Component
public class Subject {

    private static final HashMap<Integer,String> HASH_MAP = new HashMap<Integer,String>();

    @PostConstruct
    public void init () {
        //任课科目 0：其他 1:语文 2：数学 3：外语 4：物理 5：化学 6：生物 7：政治 8：历史 9：地理 10：技术
        HASH_MAP.put(0,"其他");
        HASH_MAP.put(1,"语文");
        HASH_MAP.put(2,"数学");
        HASH_MAP.put(3,"外语");
        HASH_MAP.put(4,"物理");
        HASH_MAP.put(5,"化学");
        HASH_MAP.put(6,"生物");
        HASH_MAP.put(7,"政治");
        HASH_MAP.put(8,"历史");
        HASH_MAP.put(9,"地理");
        HASH_MAP.put(10,"技术");
    }

    public static String getSubject(Integer num) {
        return HASH_MAP.get(num);
    }
}

