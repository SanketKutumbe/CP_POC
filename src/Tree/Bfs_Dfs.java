package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Bfs_Dfs {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.prev = new Node(2);
        node.next = new Node(5);
        node.prev.prev = new Node(3);
        node.prev.next = new Node(4);
        node.next.prev = new Node(7);
        node.next.next = new Node(6);

        //bfs(node);
        dfs(node);
    }

    private static void dfs(Node node) {
        if( node == null ) return;
        System.out.println(node.val);
        dfs(node.prev);
        dfs(node.next);
    }

    private static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while( !q.isEmpty() ){
            Node temp = q.peek();
            System.out.println( temp.val );

            if( temp.prev != null ) q.add(temp.prev);
            if( temp.next != null ) q.add(temp.next);

            q.poll();

        }
    }
}
