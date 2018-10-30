
/**
 * 给定一个无序的数值数组中，查找给定第K小的数值， 如给定数组[1,3,5,6], 查找第二小的数字是3
 * 查找数组排序后索引为k-1的数值
 */
public class FindKthMinNumber {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(findKth(nums, 2));

        int[] nums2 = {5, 2, 4, 1, 9};
        System.out.println(findKth(nums2, 3));
    }

    private static int findKth(int[] nums, int k) {
        return findKthImpl(nums, 0, nums.length - 1, k - 1);
    }

    private static int findKthImpl(int[] nums, int lower, int upper, int k) {
        int i = partition(nums, lower, upper);
        int n = i - lower; //n是分区下半部分数组的元素统计
        if (n > k) {
            //在下半部分数组中，保持K
           return findKthImpl(nums, lower, i - 1, k);
        } else if (n == k) {
            //数量等于K说明i正好是第K小的值
            return nums[i];
        } else {
            //在上半部分数组中，K值要减去已经检查的元素数量
           return findKthImpl(nums, i + 1, upper, k - n - 1);
        }
    }

    /**
     * 在指定的上界与下界范围内为数组分组，返回选定分组值的索引值
     */
    private static int partition(int[] nums, int lower, int upper) {
        int pivot = nums[lower];
        while (lower < upper){
            while (lower < upper && nums[upper] >= pivot){
                --upper;
            }
            nums[lower] = nums[upper];  //将比基准小的元素移动到左端
            while (lower < upper && nums[lower] <= pivot){
                ++lower;
            }
            nums[upper] = nums[lower];  //将比基准大的元素移动到右端
        }
        nums[lower] = pivot;
        return lower;
    }
}
