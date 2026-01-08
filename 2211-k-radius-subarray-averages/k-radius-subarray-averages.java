class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        int[]ans=new int[n];
        Arrays.fill(ans,-1);
        int windowsize=2*k+1;
        long windowsum=0;
        int left=0;
        for(int right=0;right<n;right++){
            windowsum+=nums[right];
            if(right-left+1>windowsize){
                windowsum-=nums[left];
                left++;
            }
            if(right-left+1==windowsize){
                int center=left+k;
                ans[center]=(int)(windowsum/windowsize);
            }
        }
        return ans;
            }

            }
        