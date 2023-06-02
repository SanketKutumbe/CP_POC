package Tree;

public class MaxDepthOfTree {

    public static void main(String[] args) {
        Node node = Node.initialise();
        System.out.println(calculate(node, 0));
    }

    private static int calculate(Node node, int max) {

        if( node == null ) return 0;

        int left = 1 + calculate(node.prev, max);
        int right = 1 + calculate(node.next, max);
        return Math.max(left, right);
    }
}
