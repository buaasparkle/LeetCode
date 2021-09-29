package fun.sure.leetcode.easy;

import fun.sure.leetcode.Topics;

/**
 * Created by wangshuo on 2016/6/19.
 */
public abstract class FirstBadVersion implements Topics.BinarySearch {

    /**
     * You are a product manager and currently leading a team to develop a new product. Unfortunately,
     * the latest version of your product fails the quality check. Since each version is developed based on the previous version,
     * all the versions after a bad version are also bad.
     * <p/>
     * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
     * <p/>
     * You are given an API bool isBadVersion(version) which will return whether version is bad.
     * Implement a function to find the first bad version. You should minimize the number of calls to the API.
     */

    /* The isBadVersion API is defined in the parent class VersionControl.*/
    abstract boolean isBadVersion(int version);

    // 二分查找？
    // [PASS] 开始踩了个坑，mid = (low + high) / 2; 但是low + high可能导致越界，要分开除2
    public int firstBadVersion(int n) {
        int lowVersion = 1;
        int highVersion = n;
        int midVersion;
        while (lowVersion <= highVersion) {
            midVersion = lowVersion + (highVersion - lowVersion) / 2;
            if (isBadVersion(midVersion)) {
                highVersion = midVersion - 1;
            } else {
                lowVersion = midVersion + 1;
            }
        }
        return lowVersion;
    }

    public static void main(String[] args) {
        System.out.print(new FirstBadVersion() {
            @Override
            boolean isBadVersion(int version) {
                return version >= 1702766719;
            }
        }.firstBadVersion(2126753390));
    }
}
