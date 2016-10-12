package com.xiaodong.verification.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Description:
 * @Author: lixiaodong@souyidai.com
 * @CreateDate: 2016/9/27
 */
public class StringTokenizerUtil {
    private static final String TEST_STR = "这，只 是   一个\r测\n试";

    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer(TEST_STR);
        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String next = tokenizer.nextToken();
            list.add(next);
            System.out.println(next);
        }
        System.out.println(list);
    }
}
