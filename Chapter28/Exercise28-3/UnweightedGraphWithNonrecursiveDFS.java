import java.util.*;
import java.lang.*;

public class UnweightedGraphWithNonrecursiveDFS<V> extends UnweightedGraph<V> {
	
	public UnweightedGraphWithNonrecursiveDFS(V[] vertices, int[][] edges) {
		super(vertices, edges);
	}
	
	@Override
	public Tree dfs(int v) {
		List<Integer> searchOrder = new ArrayList<>();
		int[] parent = new int[vertices.size()];
		for (int i = 0; i < parent.length; i++)
			parent[i] = -1; // Initialize parent[i] to -1

		// Mark visited vertices
		boolean[] isVisited = new boolean[vertices.size()];

		// Recursively search
		dfs(v, parent, searchOrder, neighbors, isVisited);

		// Return a search tree
		return new Tree(v, parent, searchOrder);
	}
	
	//@Override
	public void dfs(int u, int[] parent, List<Integer> searchOrder, List<List<Edge>> neighbors, boolean[] isVisited) {
		Stack<Integer> stack = new Stack<Integer>();
		
		
		stack.push(u);
		searchOrder.add(u);
		isVisited[u] = true;
		
		while (!stack.isEmpty()) {
			int x = stack.peek();
			if (neighbors.get(x).size() == 0) {
				stack.pop();
				continue;
			}
			for (int i = getNeighbors(x).size() - 1; i >= 0; i--) {
				Edge e = neighbors.get(x).get(i); 
				if (!isVisited[e.v]) {
					parent[e.v] = x;
					stack.push(e.v);
					isVisited[e.v] = true;
					searchOrder.add(e.v);
					neighbors.get(x).remove(i);
					break;
				}
				else {
					neighbors.get(x).remove((i));
				}
			}
		}
	}
	
}