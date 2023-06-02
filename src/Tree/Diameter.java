package Tree;

import java.util.ArrayList;
import java.util.List;

public class Diameter {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.prev = new Node(2);
        node.next = new Node(3);
        node.next.prev = new Node(4);
        node.next.prev.prev = new Node(5);
        node.next.prev.prev.prev = new Node(6);
        node.next.prev.prev.prev.prev = new Node(7);
        node.next.next = new Node(7);
        node.next.next.prev = new Node(8);
        node.next.next.prev.prev = new Node(9);

        List<Integer> list = new ArrayList<>();
        list.add(0);
        int result = calculate(node, list);
        System.out.println( list.get(list.size()-1) );

        int max = 0;
        result = calc(node, max);
        System.out.println( list.get(list.size()-1) );
    }

    private static int calc(Node node, int max) {

        if( node == null ) return 0;

        int left = calc(node.prev, max);
        int right = calc(node.next, max);

        max = Math.max(max, left+right);

        return 1 + Math.max(left, right);
    }

    private static int calculate(Node node, List<Integer> list) {
        if( node == null ) return 0;

        int left = calculate(node.prev, list);
        int right = calculate(node.next, list);

        if( left + right > list.get(list.size()-1) ) list.add(left + right);

        return 1 + Math.max(left, right);
    }
}
