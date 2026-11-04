class Pair{
    int dis;
    int[] p;
    Pair(int dis,int[] p){
        this.dis=dis;
        this.p=p;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.dis - a.dis);
        for(int i=0;i<k;i++){
            int distance=((points[i][0])*(points[i][0]))+((points[i][1])*(points[i][1]));
            pq.add(new Pair(distance,points[i]));
        }
        for(int i=k;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            int distance1=x*x+y*y;
            Pair z=pq.peek();
            if(z.dis>distance1){
                pq.poll();
                pq.add(new Pair(distance1,points[i]));
            }
            else{
                continue;
            }
        }
        int[][] arr=new int[k][2];
        int i=0;
        while(pq.isEmpty()!=true){
            Pair x1=pq.poll();
            arr[i][0]=x1.p[0];
            arr[i][1]=x1.p[1];
            i++;
        }
        return arr;
    }
}