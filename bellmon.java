import java.util.ArrayList;

public class bellmon {
    //Bellmon ford algorithm O(V*E)
    public static void bellman(ArrayList<Edge>[] ed,int src){
        int[] dist=new int[ed.length];
        for(int i=0;i<dist.length;i++){
            if(i!=0){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        int V=ed.length-1;
        // O(V)
        for(int i=0;i<V;i++){
            // O(E)
            for(int j=0;j<ed.length;j++){
                for(int k=0;k<ed[j].size();k++){
                    Edge e=ed[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    // relaxation
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] +" ");
        }
        System.out.println();

    }
}
