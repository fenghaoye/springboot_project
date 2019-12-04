package com.fh.project.algo;

public class BinarySearch {


    /*
        二分查找：
     */
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /*
    二分查找： 改为递归算法
     */
    public static int recursiveAlgorithm(int[] a, int n, int value) {
        return recursiveAlgorithm(a, 0, n - 1, value);

    }

    private static int recursiveAlgorithm(int[] a, int low, int high, int value) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return recursiveAlgorithm(a, mid + 1, high, value);
        } else {
            return recursiveAlgorithm(a, low, high - 1, value);
        }

    }


    public static int bsearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                if ((mid == 0) || (a[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;

    }


    // 查找第一个大于等于给定值的元素下标
    public static int bsearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }

    public static int bsearch4(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {
                if (mid == n - 1 || a[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {

                high = mid - 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
/*        int[] a = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
       // int bsearch = BinarySearch.bsearch(a, 10, 23);
        int bsearch = BinarySearch.recursiveAlgorithm(a, 10, 23);*/
        int[] a = {8, 11, 19, 23, 27, 33, 33, 33, 67, 98};
        int bsearch = BinarySearch.bsearch3(a, 10, 8);
        System.out.println(bsearch);

    }

}
