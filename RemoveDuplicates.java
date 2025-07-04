public class RemoveDuplicates {


    public static int removeDuplicates(int arr[]){
        if(arr == null) return 0;
        if(arr.length == 1) return 1;
        int left = 1;
        int right = 1;

        while(right < arr.length){
            if(arr[right] != arr[right-1]){
                arr[left] = arr[right];
                left++;
            }
            right++;
        }

        for(int i=0; i<left; i++){
            System.out.println("The unique values are "+arr[i]);
        }
        return left;
    }



    public static void main(String args[]){
            int arr[] = {1,1,1,2,2,2,2,2};
            int unique = removeDuplicates(arr);
        System.out.printf("unique vals are "+unique);
    }
}
