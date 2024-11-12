import java.util.*;
import java.util.LinkedList;
public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T>{

public BetterBST(){
    root = null;
}
public BetterBST(BinaryNode<T> root){
    this.root = root;
}
public int height(){
    return height(super.root);
}

//checks the maximum height of the BinarySearchTree
private int height(BinaryNode<T> node){
    if(node == null)
        return -1;
    //recursively checks through each the left and ride nodes of the root 
     int lHeight = height(node.left);
     int rHeight = height(node.right);

    //returns the greatest height value between the two sides of the tree
     return 1 + (Math.max(lHeight, rHeight)); 

}

public T imbalance(){
    return imbalance(super.root);
}

//checks if there is a depth imbalance greater than 1 in the tree
private T imbalance(BinaryNode<T> node){
    if (node == null)
        return null;
    //checks for the height of both left and right nodes and find the
    //absolute value of their difference  
    int lHeight = height(node.left);
    int rHeight = height(node.right);
    int balance = Math.abs(lHeight - rHeight);

    //if there is an imbalance of greater than 1 the value of the node
    //with the imabalance is returned
    if (balance > 1)
        return node.data;

    return null;
    

    
}

public T smallestGreaterThan(T t){
    return smallestGreaterThan(t, super.root);
}

//returns the value of a node within the tree
//with the smallest value larger than the inputted value 
private T smallestGreaterThan(T t, BinaryNode<T> node){
    if (node ==null)
        return null;
   //recursively traverses the tree and compares each
   //node's values with the inputted value.
   //if the value is is larger than the node it continues searching 
   //to the right of the node and returns that value
    if (node.data.compareTo(t) <= 0)
        return smallestGreaterThan(t, node.right);
    
    //if the function has reached a node with no 
    //left child it returns that parent node
    if(node.left == null)
        return node.data;

    //otherwise the left child of the final node is returned 
    return smallestGreaterThan(t, node.left); 

}

//returns a mirrored BinarySearchTree
//creates a new tree and swaps each value within
//the tree from left to right
public BinarySearchTree<T> mirror(){
    BinarySearchTree<T> mirrorTree = new BetterBST<T>();
    mirrorTree.root = rePrint(root);
    mirror(mirrorTree.root);
    return mirrorTree;
}

//takes the copied tree from rePrint()
//and recursively traverses the nodes
//swapping each left for right node.
private BinaryNode<T> mirror(BinaryNode<T> node){
    if(node ==null)
        return null;
        
    BinaryNode<T> left = mirror(node.left);
    BinaryNode<T> right = mirror(node.right);
    node.left = right;
    node.right = left; 

    return node; 
}
//makes an identical copy of the current tree
//in order to be mirrored
private BinaryNode<T> rePrint(BinaryNode<T> node){
    if (node == null)
        return null;
    
    BinaryNode<T> reRoot = new BinaryNode<T>(node.data);

    reRoot.left = rePrint(node.left);
    reRoot.right = rePrint(node.right);

    return reRoot; 
}


public LinkedList<BinaryNode<T>> levelOrderTraversal(){
    
    return levelOrderTraversal(super.root);
} 


private LinkedList<BinaryNode<T>> levelOrderTraversal(BinaryNode<T> node){
    
    if (node == null )
        return null;

    //creates a queue holding the values within the 
    //BinarySearchTree and adds them to a LinkedList
    //to be returned
    Queue<BinaryNode<T>> queue = new LinkedList<>();
    LinkedList<BinaryNode<T>> list = new LinkedList<>();
    
    queue.add(node);
   
    //traverses the nodes within the tree inside of the queue
    //adds each node to the linked list
    while(!queue.isEmpty()){
        
        BinaryNode<T> n = queue.poll();
        if(n == null){
            if(!queue.isEmpty()){
                list.add(n);
            }
        }else{
        
            if(node.left != null){
                queue.add(n.left);
            }if(node.right != null){
                queue.add(n.right);
            } 
            list.add(n);
        }
            
    }

    return list; 




}


}


