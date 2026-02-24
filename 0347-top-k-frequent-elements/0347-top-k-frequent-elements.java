class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.val!=b.val){
                return b.val - a.val;
            }

            return a.val;
        });

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getValue(),entry.getKey()));
        }

        int[] ans= new int[k];
        int i  =0;
        while(k --> 0){
            Pair curr = pq.poll();
            int key = curr.key;

            ans[i++] = key;
        }
        return ans;
    }
}

class Pair{
    int val;
    int key;
    public Pair(int val,int key){
        this.val = val;
        this.key = key;
    }
}