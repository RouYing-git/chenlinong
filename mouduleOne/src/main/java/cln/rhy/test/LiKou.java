package cln.rhy.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/10/25
 */
public class LiKou {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int first = 0; first < length; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = length - 1;
            for (int second = first + 1; second < length; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[first] + nums[second] + nums[third] > 0) {
                    third = third - 1;
                }
                if (second == third) {
                    break;
                }
                if ((nums[first] + nums[second] + nums[third]) == 0) {
                    List<Integer> sumZero = new ArrayList<>();
                    sumZero.add(nums[first]);
                    sumZero.add(nums[second]);
                    sumZero.add(nums[third]);
                    result.add(sumZero);
                }
            }
        }
        return result;
    }


    static final int MOD = 5;

    public static int shaizi(int n, int k, int sum) {
        //当有0个骰子时 和为index（下标）时的组合数为methods[index]。
        int[] methods = new int[sum + 1];
        //当有0个骰子的时候，和为0的组合方式为1种；和为1的组合数为0种；和为2的组合数为0；..........
        methods[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int s = sum; s >= 0; --s) {
                methods[s] = 0;
                for (int j = 1; j <= k; ++j) {
                    if (s >= j) {
                        methods[s] = (methods[s] + methods[s - j]) % MOD;
                    }
                }
            }
        }
        return methods[sum];
    }

    /**
     * 获取两个正序数组的中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
       /* int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(arr);
        System.out.println(result);*/

  /*      int result = shaizi(30, 30, 500);
        System.out.println(result);*/

        String name = "123,232,456";
        String result = new StringBuilder()
                .append(",")
                .append(name)
                .append(",")
                .toString()
                .replace(",232,", ",")
                .replaceAll("^,+|,+$", "");
        System.out.println(result);


        String oldCode = "海外,中药";
        Set<String> collect = Stream.of(oldCode.split(",")).collect(Collectors.toSet());
        collect.add("电力");
        System.out.println(collect);

    }
}
