package Programming.Graphs;

import java.util.*;

public class SuggestFriendsDFS<T> {

    HashMap<T, ArrayList<T>> adj= new HashMap<>();
    List<Set<T>> groups = new ArrayList<>();

    protected void addRelation(T src, T dest){
        adj.putIfAbsent(src, new ArrayList<T>());
        adj.get(src).add(dest);
        adj.putIfAbsent(dest, new ArrayList<T>());
        adj.get(dest).add(src);
    }

  protected void findGroups() {
    Map<T, Boolean> visited = new HashMap<>();

    for (T t : adj.keySet()) visited.put(t, false);
        for (T t : adj.keySet()) {
          if (!visited.get(t)) {
            Set<T> group = new HashSet<>();
            dfs(t, visited, group);
            groups.add(group);
          }
        }
    }
    protected void dfs(T v, Map<T, Boolean> visited, Set<T> group) {
        visited.put(v, true);
        group.add(v);
        for(T x: adj.get(v)){
            if(!visited.get(x)){
                dfs(x, visited, group);
            }
        }
    }
    //Time O(V+E), Space O(V)
    public Set<T> getSuggestedFriends (T a) {
        if (groups.isEmpty())
            findGroups();
        Set<T> res = new HashSet<>();
        for (Set<T> t : groups) {
            if (t.contains(a)) {
                res = t;
                break;
            }
        }
        if (res.size() > 0)
            res.remove(a);
        return res;
}
    public static void main(String[] args){

        SuggestFriendsDFS<String> g = new SuggestFriendsDFS<>();
        g.addRelation("Ashley", "Christopher");
        g.addRelation("Ashley", "Emily");
        g.addRelation("Ashley", "Joshua");
        g.addRelation("Bart", "Lisa");
        g.addRelation("Bart", "Matthew");
        g.addRelation("Christopher", "Andrew");
        g.addRelation("Emily", "Joshua");
        g.addRelation("Jacob", "Christopher");
        g.addRelation("Jessica", "Ashley");
        g.addRelation("JorEl", "Zod");
        g.addRelation("KalEl", "JorEl");
        g.addRelation("Kyle", "Lex");
        g.addRelation("Kyle", "Zod");
        g.addRelation("Lisa", "Marge");
        g.addRelation("Matthew", "Lisa");
        g.addRelation("Michael", "Christopher");
        g.addRelation("Michael", "Joshua");
        g.addRelation("Michael", "Jessica");
        g.addRelation("Samantha", "Matthew");
        g.addRelation("Samantha", "Tyler");
        g.addRelation("Sarah", "Andrew");
        g.addRelation("Sarah", "Christopher");
        g.addRelation("Sarah", "Emily");
        g.addRelation("Tyler", "Kyle");
        g.addRelation("Stuart", "Jacob");

        g.findGroups();
        System.out.println(g.groups);

        String name = "Andrew";
        System.out.println("Suggestion friends of " + name + ": " + g.getSuggestedFriends(name));
    }
}