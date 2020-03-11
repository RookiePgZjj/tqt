package com.yaorange.tqt.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replace {
    public static String tagfilter(String str){
        final String regxpForHtml = "<([^>]*)>"; // 过滤所有以<开头以>结尾的标签
        Pattern pattern = Pattern.compile(regxpForHtml);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        boolean result1 = matcher.find();
        int i = 0;
        while (result1) {
            //除以2==1 表示  2 4 6<p></p>
            matcher.appendReplacement(sb, "");
            if (i%2==1){
                sb.append('-');
            }
            i++;
            result1 = matcher.find();
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
