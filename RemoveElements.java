public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        if(nums == null) return 0;
        if(nums.length == 1){
            if(nums[0] == val){
                return 0;
            }else{
                return 1;
            }
        }

        int left = 0; int right = nums.length -1;

        while(left <= right){
            if(nums[right] == val){
                right--;
                continue;
            }
            if(nums[left] == val){
                swap(nums,left,right);
                right--;
            }
            left++;
        }
        return left;
    }

    private void swap(int[] nums , int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
