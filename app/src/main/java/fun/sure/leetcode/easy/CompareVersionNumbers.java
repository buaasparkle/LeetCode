package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/19.
 */
public class CompareVersionNumbers {

    /**
     * Compare two version numbers version1 and version2.
     If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

     You may assume that the version strings are non-empty and contain only digits and the . character.
     The . character does not represent a decimal point and is used to separate number sequences.
     For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

     Here is an example of version numbers ordering:

     0.1 < 1.1 < 1.2 < 13.37
     */

    // [PASS]
    public int compareVersion(String version1, String version2) {
        String[] vs1 = (version1 + ".0").split("\\.");
        String[] vs2 = (version2 + ".0").split("\\.");
        int minLength = Math.min(vs1.length, vs2.length);
        for (int i = 0; i < minLength; i++) {
            int v1 = Integer.valueOf(vs1[i]);
            int v2 = Integer.valueOf(vs2[i]);
            if (v1 == v2) {
                continue;
            } else {
                return v1 > v2 ? 1 : -1;
            }
        }
        if (vs1.length == vs2.length) {
            return 0;
        } else if (vs1.length > vs2.length) {
            for (int i = minLength; i < vs1.length; i++) {
                if (Integer.valueOf(vs1[i]) > 0) {
                    return 1;
                }
            }
            return 0;
        } else {
            for (int i = minLength; i < vs2.length; i++) {
                if (Integer.valueOf(vs2[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.print(new CompareVersionNumbers().compareVersion("1", "0"));
    }
}
