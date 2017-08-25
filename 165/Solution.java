class Solution {
    public static int compareVersion(String version1, String version2) {
        String[] vers1 = version1.concat(".").split("\\.");
        String[] vers2 = version2.concat(".").split("\\.");
        int flag = 0;
        for (int i = 0; i<Math.max(vers1.length, vers2.length); i++) {
            int ver1 = (i<vers1.length) ? Integer.parseInt(vers1[i]) : 0;
            int ver2 = (i<vers2.length) ? Integer.parseInt(vers2[i]) : 0;
            if (ver1<ver2) {
                flag = -1;
                break;
            }
            if (ver1>ver2) {
                flag = 1;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int res = compareVersion("1.1", "1");
        System.out.println(res);
    }
}
