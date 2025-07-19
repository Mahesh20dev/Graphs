import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class topoKhan {
    //topological sort using bfs Kahn's algorithm

    //calculation of indegree
    public static void calculate(ArrayList<Edge>[] ed,int[] indegree){
        for (int i = 0; i < ed.length; i++) {
            int vertex=i;
            for (int j = 0; j < ed[vertex].size(); j++) {
                Edge e=ed[vertex].get(j);
                indegree[e.dest]++;
            }
        }
    }
    public static void topkahn(ArrayList<Edge>[] ed){
        int[] indegree=new int[ed.length];
        calculate(ed,indegree);
        Queue<Integer> q=new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }

        //bfs
        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr+" ");
            for (int i = 0; i < ed[curr].size(); i++) {
                Edge e=ed[curr].get(i);
                indegree[e.dest]--;
                if(indegree[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
    }
}
