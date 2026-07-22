import java.util.*;

public class Scenario6_DirectedCycle {

    static boolean dfs(Map<Integer,List<Integer>> graph,int node,int[] state){

        state[node]=1;

        for(int next:graph.getOrDefault(node,Collections.emptyList())){

            if(state[next]==1)
                return true;

            if(state[next]==0 && dfs(graph,next,state))
                return true;
        }

        state[node]=2;
        return false;
    }
}
