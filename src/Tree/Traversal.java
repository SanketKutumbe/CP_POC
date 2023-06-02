package Tree;

public interface Traversal {

    void dfs(Node node); // pre-order traversal
    void bfs(Node node); // level order traversal

    void inOrder(Node node);

    void postOrder(Node node);
}
