class Solution {
    public static int[] mergeProcedure(int[] arr, int l, int m, int r){
        int i,j,k;
        int n1 = m-l+1;
        int n2 = r-m;         //r-(m+1)+1

        int[] larr = new int[n1];
        int[] rarr = new int[n2];

        //copy elemnets in respective arrays
        for(i = 0; i < n1; i++){
            larr[i] = arr[l+i];
        }
        for(j = 0; j < n2; j++){
            rarr[j] = arr[m+1+j];
        }

        //compare elements between larr an raar
        i=0; j= 0; k = l;
        while(i < n1 && j < n2){
            if(larr[i] <= rarr[j]){
                arr[k] = larr[i];
                i++;
            }else{
                arr[k] = rarr[j];
                j++;
            }
            k++;
        }

        //copying the remaining elements
        while(i < n1){
            arr[k] = larr[i];
            k =k+1;
            i =i+1;
        }
        while(j < n2){
            arr[k] = rarr[j];
            k =k+1;
            j = j+1; 
        }
        return arr;
    }
    public static int[] mergeSort(int[] arr, int l, int r){
        if(l == r){
            int[] result = new int[1];
            result[0] = arr[l];
            return result;
        }
        //divide and conquer
        //divide
        
        int m = l + (r - l)/2;
            
        //Conquer
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);

        //Combine
        return mergeProcedure(arr, l, m, r);
        
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        return mergeSort(nums,0,n-1);
    }
}