package Tree;

public class CheckBalanceTree {

    public static void main(String[] args) {

        Node node = Node.initialise();

        int result = check(node);
        System.out.println( !(result == -1 ));
    }

    private static int check(Node node) {
        if( node == null ) return 0;

        int left = check(node.prev);
        int right = check(node.next);

        if( left == -1 || right == -1 ) return -1;

        if( Math.abs(left - right) >= 2 ) {
            System.out.println("Not balanced");
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}
