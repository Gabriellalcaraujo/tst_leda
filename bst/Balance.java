import java.util.Scanner;

public class Balance {
    private Node25 root;
    private String balance;

    public Balance(){
        this.root = null;
        this.balance = "";
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public void add(int k){
        if (isEmpty()) {
            Node25 no = new Node25(k);
            this.root = no;
        }
        else{
            Node25 aux = this.root;
            while (aux != null) {
                if (k < aux.value) {
                    if (aux.left == null) {
                        Node25 n = new Node25(k);
                        aux.left = n;
                        n.parent = aux;
                        return;
                    }
                    aux = aux.left;
                }
                else{
                    if (aux.right == null) {
                        Node25 no = new Node25(k);
                        aux.right = no;
                        no.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }
    public int height(){
        return height(root);
    }
    private int height(Node25 no){
        if (no == null) {
            return -1;
        }
        else{
            return 1 + Math.max(height(no.right), height(no.left));
        }
    }
    public String balance(){
        balance(root);
        return this.balance;
    }
    private void balance(Node25 n){
        if (n != null) {
            balance += n.value + "," + (height(n.left) - height(n.right)) + " ";
            balance(n.left);
            balance(n.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        Balance bst = new Balance();
        
        for(String s: entrada){
            bst.add(Integer.parseInt(s));
        }
        System.out.println(bst.balance().trim());
    }
}
class Node25 {
    
    int value;
    Node25 left;
    Node25 right;
    Node25 parent;
    
    Node25(int v) {
        this.value = v;
    }
    public boolean isLeaf(){
        if (this.left == null && this.right == null) {
            return true;
        } return false;
    }
}
