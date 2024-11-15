import java.util.Scanner;
public class MinBST {
    private Node11 root;

    public MinBST(){
        this.root = null;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public void add(int k){
        if (isEmpty()) {
            Node11 no = new Node11(k);
            this.root = no;
        }
        else{
            Node11 aux = this.root;
            while (aux != null) {
                if (k < aux.value) {
                    if (aux.left == null) {
                        Node11 n = new Node11(k);
                        aux.left = n;
                        n.parent = aux;
                        return;
                    }
                    aux = aux.left;
                }
                else{
                    if (aux.right == null) {
                        Node11 no = new Node11(k);
                        aux.right = no;
                        no.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }
    public String min(){
        String out = "";
        Node11 n = this.root;
        while (n.left != null) {
            out += n.value + " ";
            n = n.left;
        }
        out += n.value + " ";
        return out;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        MinBST bst = new MinBST();

        for(String s: entrada){
            bst.add(Integer.parseInt(s));
        }
        System.out.println(bst.min().trim());
    }
}
class Node11 {
    
    int value;
    Node11 left;
    Node11 right;
    Node11 parent;
    
    Node11(int v) {
        this.value = v;
    }
    public boolean isLeaf(){
        if (this.left == null && this.right == null) {
            return true;
        } return false;
    }
}
