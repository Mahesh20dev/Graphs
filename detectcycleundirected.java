import java.util.ArrayList;

public class detectcycleundirected {
    //cycle detection in undirected graph
    public static boolean detectcycle(ArrayList<Edge>[] ed){   // O(E+V)
        boolean[] visited=new boolean[ed.length];
        for (int i = 0; i < ed.length; i++) {
            if(!visited[i]){
                if(detectcycleUtil(ed, visited, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectcycleUtil(ArrayList<Edge>[] ed,boolean[] visited,int curr ,int par){
        visited[curr]=true;

        for (int i = 0; i < ed[curr].size(); i++) {
            Edge e=ed[curr].get(i);
            if(!visited[e.dest]){
                // case 3
                if(detectcycleUtil(ed, visited, e.dest, curr)){
                    return true;
                }
            }
            else if(visited[e.dest] && e.dest!=par){ //case 1
                return true;
            }

            //case 2 -> do nothing

        }

        return false;

    }
}
