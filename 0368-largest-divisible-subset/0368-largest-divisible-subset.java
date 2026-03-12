class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] list=new int[n];
        list[0]=0;
        List<Integer> list1=new ArrayList<>();
        for(int i=1;i<n;i++){
            list[i]=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp[i]<1+dp[j]){
                        dp[i]=1+dp[j];
                        list[i]=j;
                    }
                }
            }
        }
        int max=0,maxindex=0;
        for(int i=0;i<n;i++){
       if(max<dp[i]){
        max=dp[i];
        maxindex=i;
       }
        }
        list1.add(nums[maxindex]);
        while(maxindex!=list[maxindex]){
            maxindex=list[maxindex];
            list1.add(nums[maxindex]);
        }

        return list1;
    }
}