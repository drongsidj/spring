package top.igio.template;

import cn.hutool.core.comparator.VersionComparator;

import java.util.*;

/**
 * @author ljl
 * @version V1.0
 * @data 2023/6/26 22:35
 * @description
 */
public class CompareTest {

    public static void main(String[] args) {
        List<String> versionList = new ArrayList<>();
        versionList.add("V1");
        versionList.add("V7");
        versionList.add("V3");

        // 使用Lambda表达式创建版本号比较器
        Comparator<String> versionComparator = (version1, version2) -> {
            if(VersionComparator.INSTANCE.compare(version1, version2) > 0) {
                return 1;
            } else if (VersionComparator.INSTANCE.compare(version1, version2) < 0){
                return -1;
            } else {
                return 0;
            }
        };

        System.out.println("排序前：" + versionList.toString());
        Collections.sort(versionList, versionComparator);

        System.out.println("排序后：" + versionList.toString());

        System.out.println(versionList.get(versionList.size()-1));
    }



}
