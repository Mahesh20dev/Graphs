import java.util.ArrayList;

public class detectcycledirected {
     //cycle detection in directed graph using modified dfs
    public static boolean directedcycle(ArrayList<Edge>[] ed){ // O(E+V)
        boolean[] visited=new boolean[ed.length];
        boolean[] stack=new boolean[ed.length];

        for (int i = 0; i < ed.length; i++) {
            if(!visited[i]){
                if(directedcycleUtil(ed,visited,stack,i)){
                    return true;
                }
            }

        }
        return false;

    }

    public static boolean directedcycleUtil(ArrayList<Edge>[] ed,boolean[] visited,boolean[] stack,int curr){ // O(E+V)
        visited[curr]=true;
        stack[curr]=true;

        for (int i = 0; i < ed[curr].size(); i++) {
            Edge e=ed[curr].get(i);
            if(stack[e.dest]){
                return true; //cycle exists
            }
            if(!visited[e.dest] && directedcycleUtil(ed, visited, stack, e.dest)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }

}
