import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstras {
     //dijkstra's Algorithm  TC= V+Elogn

    public static class pair implements Comparable<pair>{
        int node;
        int path;
        pair(int node,int path){
            this.node=node;
            this.path=path;
        }

        @Override
        public  int compareTo(pair p2){
            return this.path-p2.path;
        }
    }

    public static void djk(ArrayList<Edge>[] ed,int src){
        int[] dist=new int[ed.length];
        boolean[] visited=new boolean[ed.length];
        PriorityQueue<pair> pq=new PriorityQueue<>();

        for (int i = 0; i < dist.length; i++) {
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        pq.add(new pair(src,0));

        while(!pq.isEmpty()){
            pair curr=pq.remove();
            if(!visited[curr.node]){
                visited[curr.node]=true;
                // neighbours
                for(int i=0;i<ed[curr.node].size();i++){
                    Edge e=ed[curr.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]+wt<dist[v]){  //update dist from src to v
                        dist[v]=dist[u]+wt;
                        pq.add(new pair(v, dist[v]));
                    }
                }
            }

        }
        int min=Integer.MAX_VALUE;
        for (int i = 1; i < dist.length-1; i++) {
            System.out.print(dist[i]+" ");
            if(dist[i]<dist[i+1]){
                min=Math.min(min,dist[i]);
            }
        }
        System.out.println(min);
    }

}
