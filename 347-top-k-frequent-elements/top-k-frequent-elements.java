class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->
        {if(a.first!=b.first){
            return a.first-b.first;
        }
        else{
            return a.second-b.second;
        }});
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int num:map.keySet()){
            if(pq.size()<k){
                pq.add(new Pair(map.get(num),num));
            }
            else{
                int freq=map.get(num);
                Pair p=pq.peek();
                if(freq>p.first || freq==p.first && num>p.second){
                    pq.poll();
                    pq.add(new Pair(map.get(num),num));
                }
                else{
                    continue;
                }
            } 
        }
        int[] arr=new int[k];
            int i=0;
            while(pq.isEmpty()!=true){
                Pair x=pq.poll();
                arr[i]=x.second;
                i++;
            }
         return arr;
}
}