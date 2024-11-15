import java.util.Scanner;
public class MaxBST {
    private Node10 root;

    public MaxBST(){
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
            Node11 aux = this.root;
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
    public String max(){
        String out = "";
        Node10 n = this.root;
        while (n.right != null) {
            out += n.value + " ";
            n = n.right;
        }
        out += n.value + " ";
        return out;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        MaxBST bst = new MaxBST();

        for(String s: entrada){
            bst.add(Integer.parseInt(s));
        }
        System.out.println(bst.max().trim());
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