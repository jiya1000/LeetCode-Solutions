class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> m=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            m.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]>m.peek()){
                m.poll();
                m.add(nums[i]);
            }
            else{
            continue;
            }
        }
        return m.peek();
    }
}