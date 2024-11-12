public class Tester{
    public static void main(String[] args){

    ExpressionTree exp1 = new ExpressionTree("3 4 1 - 9 *");
    System.out.println("eval " + exp1.eval());
    System.out.println("postfx " + exp1.postfix());
    System.out.println("pre " + exp1.prefix());
    System.out.println("in " + exp1.infix());


    BetterBST<Integer> b = new BetterBST<>();

    b.insert(10);
    b.insert(8);
    b.insert(12);
    b.insert(7);
    b.insert(5);
    b.insert(13);
    b.insert(6);
   

    System.out.println("smallestGreaterThan "  + b.smallestGreaterThan(6));
    System.out.println("height " + b.height());
    System.out.println("level order " + b.levelOrderTraversal());
    System.out.println("imbalance " + b.imbalance());
    BinarySearchTree<Integer> mirrored = b.mirror();
    System.out.println("mirror " + mirrored.levelOrderTraversal());

    }
}
