package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TraversalImpl implements Traversal {

    public static void main(String[] args) {

        TraversalImpl ti = new TraversalImpl();

        Node node = Node.initialise();

        System.out.print("BFS traversal is: ");
        ti.bfs(node);
        System.out.println();

        System.out.print("DFS traversal is: ");
        ti.dfs(node);
        System.out.println();

        System.out.print("Inorder traversal is: ");
        ti.inOrder(node);
        System.out.println();

        System.out.print("Post-order traversal is: ");
        ti.postOrder(node);
        System.out.println();


    }

    public void dfs(Node node) {
        if( node == null ) return;
        System.out.print(node.val + " ");
        dfs(node.prev);
        dfs(node.next);
    }

    public void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while( !q.isEmpty() ){
            Node temp = q.peek();
            System.out.print( temp.val + " ");

            if( temp.prev != null ) q.add(temp.prev);
            if( temp.next != null ) q.add(temp.next);

            q.poll();

        }
    }

    public void inOrder(Node node){
        if( node == null ) return;
        inOrder(node.prev);
        System.out.print(node.val + " ");
        inOrder(node.next);
    }

    public void postOrder(Node node){
        if( node == null ) return;
        postOrder(node.prev);
        postOrder(node.next);
        System.out.print(node.val + " ");
    }
}
