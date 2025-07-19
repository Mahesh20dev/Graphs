import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bipartite {
    //Bipartite graph detection  O(V+E)

    public static boolean isbipartite(ArrayList<Edge>[] ed){
        int[] color=new int[ed.length];
        for (int i = 0; i < color.length; i++) {
            color[i]=-1;
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < ed.length; i++) {
            if(color[i]==-1){
                q.add(i);
                color[i]=0;
                while (!q.isEmpty()) {
                    int curr =q.remove();
                    for (int j = 0; j < ed[curr].size(); j++) {
                        Edge e=ed[curr].get(j);

                        if(color[e.dest]==color[curr]){ //case 1
                            return false;
                        }else if(color[e.dest]==-1){   //case 3 no color
                            int nextcolor=color[curr]==0?1:0;
                            color[e.dest]=nextcolor;
                            q.add(e.dest);
                        }

                    }
                }
            }
        }
        return true;
    }
}
