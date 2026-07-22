import java.util.*;

public class Scenario5_UndirectedCycle {

    static boolean dfs(Map<Integer,List<Integer>> graph,int node,int parent,Set<Integer> visited){

        visited.add(node);

        for(int next:graph.getOrDefault(node,Collections.emptyList())){

            if(!visited.contains(next)){
                if(dfs(graph,next,node,visited))
                    return true;
            }else if(next!=parent){
                return true;
            }
        }

        return false;
    }
}
