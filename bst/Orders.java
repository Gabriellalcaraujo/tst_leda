import java.util.ArrayList;
import java.util.Scanner;

public class Orders {
    private Node10 root;

    public Orders(){
        this.root = null;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public void add(int k){
        if (isEmpty()) {
            Node10 no = new Node10(k);
            this.root = no;
        }
        else{
            Node10 aux = this.root;
            while (aux != null) {
                if (k < aux.value) {
                    if (aux.left == null) {
                        Node10 n = new Node10(k);
                        aux.left = n;
                        n.parent = aux;
                        return;
                    }
                    aux = aux.left;
                }
                else{
                    if (aux.right == null) {
                        Node10 no = new Node10(k);
                        aux.right = no;
                        no.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }
    public ArrayList<Integer> preOrder(){
        ArrayList<Integer> p = new ArrayList<>();
        preOrder(p, root);
        return p;
    }
    private void preOrder(ArrayList<Integer> p, Node10 n){
        if (n != null) {
            p.add(n.value);
            preOrder(p, n.left);
            preOrder(p, n.right);
        }
    }
    public ArrayList<Integer> posOrder(){
        ArrayList<Integer> p = new ArrayList<>();
        posOrder(p, root);
        return p;
    }
    private void posOrder(ArrayList<Integer> p, Node10 n){
        if (n != null) {
            posOrder(p, n.left);
            posOrder(p, n.right);
            p.add(n.value);
        }
    }
    public ArrayList<Integer> inOrder(){
        ArrayList<Integer> p = new ArrayList<>();
        inOrder(p, root);
        return p;
    }
    private void inOrder(ArrayList<Integer> p, Node10 n){
        if (n != null) {
            inOrder(p, n.left);
            p.add(n.value);
            inOrder(p, n.right);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        Orders bst = new Orders();

        for(String s: entrada){
            bst.add(Integer.parseInt(s));
        }
        System.out.println(bst.preOrder().toString());
        System.out.println(bst.inOrder().toString());
        System.out.println(bst.posOrder().toString());
    }
    
}
class Node10 {
    
    int value;
    Node10 left;
    Node10 right;
    Node10 parent;
    
    Node10(int v) {
        this.value = v;
    }
    public boolean isLeaf(){
        if (this.left == null && this.right == null) {
            return true;
        } return false;
    }
}