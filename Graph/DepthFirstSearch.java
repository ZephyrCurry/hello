package Graph;

public class DepthFirstSearch {

    private boolean[] marked;
    public int count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {

    }

}
