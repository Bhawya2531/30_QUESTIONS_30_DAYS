class Solution {
    public int minStartValue(int[] nums) {
        int sum=0;
        int minsum=0;
        for(int num:nums){
            sum+=num;
            minsum=Math.min(minsum,sum);
        }
        return 1-minsum;
        }
    }
