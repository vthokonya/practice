import java.util.ArrayList;

public class SumOfSubArray {
    public static void main(String[] args) {

        SumOfSubArray sum = new SumOfSubArray();
        int[] arr = new int[]{1,2,3,4};
        ArrayList<Integer> solution = sum.subarraySum(arr, 4,0);
        for(Integer i : solution){
            System.out.print(i + " ");
        }
    }
    ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> solution = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            int sum = arr[i];
            if(sum>s){
                continue;
            }
            for(int j=i+1;j<n;j++){
                sum+=arr[j];
                while(sum>s){
                    sum-=arr[i];
                    i=i+1;
                }
                if(sum == s){
                    solution.add(i+1);
                    solution.add(j+1);
                    return solution;
                }
            }
        }
        solution.add(-1);
        return solution;
    }
}
