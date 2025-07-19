import java.util.ArrayList;
import java.util.Stack;

public class topo {
     //Topological sorting using modified dfs
    public static void topologicalSort(ArrayList<Edge>[] ed){ // O(E+V)
        boolean[] visited=new boolean[ed.length];
        Stack<Integer> stack=new Stack<>();

        for (int i = 0; i < ed.length; i++) {
            if(!visited[i]){
                topologicalSortUtil(ed,visited,stack,i);
            }

        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop()+" ");
        }

    }

    public static void topologicalSortUtil(ArrayList<Edge>[] ed,boolean[] visited,Stack<Integer> stack,int curr){ // O(E+V)
        visited[curr]=true;
        for (int i = 0; i < ed[curr].size(); i++) {
            Edge e=ed[curr].get(i);
            if(!visited[e.dest]){
                topologicalSortUtil(ed, visited, stack, e.dest);
            }
        }
        stack.push(curr);

    }
}
