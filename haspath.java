import java.util.ArrayList;

public class haspath {
    //has path
    public static boolean haspath(ArrayList<Edge>[] graph,boolean[] visited,int src,int dest ){
        if(src==dest){
            return true;
        }
        visited[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!visited[e.dest] && haspath(graph, visited, e.dest, dest)){
                return true;
            }
        }
        return false;
    }

    //All path from src to dest in directed graph  TC=exponential
    public static void haspath1(ArrayList<Edge>[] graph,String path,int src,int dest,boolean[] visited ){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }
        visited[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!visited[e.dest]){
            haspath1(graph,path+src, e.dest, dest,visited);  
            }
        }
        visited[src] = false;
        
    }

}
