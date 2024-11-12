import java.util.LinkedList;
import java.util.*;
public class ExpressionTree implements ExpressionTreeInterface{

    //initializes the root of the tree
    public ExpressionNode root;

    public class ExpressionNode{
        String Node;
        ExpressionNode left;
        ExpressionNode right;
        int operand;
        String operator;

    //Creates nodes    
    public ExpressionNode(String Node, ExpressionNode left, ExpressionNode right){
        this.Node = Node;
        this.right = right;
        this.left = left;
        
        
        }

   


    }

    //Creates an expression tree
    public ExpressionTree(String expression){
        String[] values = expression.split(" "); 
        LinkedList<ExpressionNode> list = new LinkedList<>();

        for(String i: values){
            if(isOperator(i)){
                ExpressionNode rightNum = list.pop();
                ExpressionNode leftNum= list.pop();
                ExpressionNode o = new ExpressionNode(i,leftNum, rightNum);
                list.push(o);
                root = o;

            }else{
               ExpressionNode num = new ExpressionNode(i, null,null );
               list.push(num);

            }
            
        }
        root = list.pop();

            
            


    }
    
    public int eval(){
        return eval(root);
    }

    //recursively evaluates the left and right subtrees of a Node and excutes the arithmetic
    //based on the apply method
    private int eval(ExpressionNode t){
         if (t.left == null && t.right == null)
            return Integer.parseInt(t.Node);
            
        int lval = eval(t.left);
        int rval = eval(t.right); 

        return apply(t.Node, lval, rval);
    }

    //ensures the root is not a leave and creates a string for postfix notation 
    //and builds it based off the private postfix function
    public String postfix(){
        if (root == null)
            throw new NoSuchElementException("root is null!");
        final StringBuilder post = new StringBuilder();
        postfix(root, post);
        return post.toString();
    }

    //recursively evaluates the left and then right subtrees and then adds the 
    //nodes data to the postfix string
    private void postfix(ExpressionNode t, StringBuilder post){
        if (t!=null){
            postfix(t.left, post);
            postfix(t.right, post);
            post.append(t.Node + " ");
        }

    }
     //ensures the root is not a leave and creates a string for prefix notation 
    //and builds it based off the private prefix function
    public String prefix(){
          if (root == null)
            throw new NoSuchElementException("root is null!");
        final StringBuilder pre = new StringBuilder();
        prefix(root, pre);
        return pre.toString();
    }
      //adds the nodes data to the prefix string and then  
    //recursively evaluates the left and then right subtrees
    private void prefix(ExpressionNode t, StringBuilder pre){
        if (t!=null){
            pre.append(t.Node + " ");
            prefix(t.left, pre);
            prefix(t.right, pre);
            
        }
    }

     //ensures the root is not a leave and creates a string for infix notation 
    //and builds it based off the private infix function
    public String infix(){
        if (root == null)
            throw new NoSuchElementException("root is null!");
        final StringBuilder in = new StringBuilder();
        infix(root, in);
        return in.toString();
    }

    //recursively evaluates the left subtree, then adds the Nodes data to the infix string
    //and then recursively evaluates right subtree
    private void infix(ExpressionNode t, StringBuilder in){
        if (t!=null){
            infix(t.left, in);
            in.append(t.Node + " ");
            infix(t.right, in);
            
        }
    }

    //checks to see which operator to evaluate based off of and then returns the apropiate result 
    //if the value is not an operator it returns the apropiate number
    private int apply(String operator, int lval, int rval){
        int answer = 0;

        if (operator.equals("+")){
            return lval + rval;
        }else if(operator.equals("-")){
            return lval - rval;
        }else if(operator.equals("*")){
            return lval * rval;    
        }else if(operator.equals("/")){
            return lval / rval;
        }    

        return Integer.parseInt(operator);
    }

    //checks to see if a value is an operator 
    private boolean isOperator(String c){
      
      return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

}





