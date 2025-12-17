class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum=0;

        List<Integer> r1=new ArrayList<>();
        List<Integer> r2=new ArrayList<>();

        for(int x:nums){
            sum+=x;
            if(x%3==1) r1.add(x);
            else if(x%3==2) r2.add(x);
        }
        r1.sort(null);
        r2.sort(null);

        int mod=sum%3;
        if(mod==0) return sum;
        int remove=Integer.MAX_VALUE;

        if(mod==1){
            if(r1.size()>=1)
            remove= r1.get(0);    //since list is sorted first element is the smallest.
            if(r2.size()>=2)
            remove=Math.min(remove, r2.get(0)+r2.get(1));
        }else{//mod 2
           if(r2.size()>=1)
           remove=r2.get(0);
           if(r1.size()>=2)
           remove=Math.min(remove,r1.get(0)+r1.get(1));
        }
        return remove== Integer.MAX_VALUE ? 0 : sum-remove;
    }
}


       