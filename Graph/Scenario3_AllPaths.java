import java.util.*;

public class Scenario3_AllPaths {

    static void dfs(Map<Integer,List<Integer>> graph,int node,int target,
                    List<Integer> path,Set<Integer> visited,
                    List<List<Integer>> ans){

        path.add(node);
        visited.add(node);

        if(node==target){
            ans.add(new ArrayList<>(path));
        }else{
            for(int next:graph.getOrDefault(node,Collections.emptyList())){
                if(!visited.contains(next)){
                    dfs(graph,next,target,path,visited,ans);
                }
            }
        }

        path.remove(path.size()-1);
        visited.remove(node);
    }
}
