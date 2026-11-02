class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=Integer.MIN_VALUE;
        int high=0;
        int low=0;
        HashMap<Character,Integer> map= new HashMap<>();
        if(s.length()==0){
            return 0;
        }
        for(high=0;high<s.length();high++){
                char c=s.charAt(high);
                map.put(c,map.getOrDefault(c,0)+1);
                int length=high-low+1;
                while(length>map.size()){
                    char c1=s.charAt(low);
                    map.put(c1,map.get(c1)-1);
                    if(map.get(c1)==0){
                        map.remove(c1);
                    }
                    low++;
                    length=high-low+1;
                }
                ans=Math.max(ans,length);
        }
        if(ans==Integer.MIN_VALUE){
            return -1;
        }
        else{
        return ans;
        }
    }
}