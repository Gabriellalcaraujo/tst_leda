import java.util.Scanner;
import java.util.LinkedList;
public class BFS {
    private Node20 root;

    public BFS(){
        this.root = null;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public void add(int k){
        if (isEmpty()) {
            Node20 no = new Node20(k);
            this.root = no;
        }
        else{
            Node20 aux = this.root;
            while (aux != null) {
                if (k < aux.value) {
                    if (aux.left == null) {
                        Node20 n = new Node20(k);
                        aux.left = n;
                        n.parent = aux;
                        return;
                    }
                    aux = aux.left;
                }
                else{
                    if (aux.right == null) {
                        Node20 no = new Node20(k);
                        aux.right = no;
                        no.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }
    public String encLarg(){
        String out = "";
        LinkedList<Node20> l = new LinkedList<>();
        if (this.root != null) {
            l.add(root);
        }
        while (!l.isEmpty()) {
            Node20 aux = l.removeFirst();
            out += aux.value + " ";
            if (aux.left != null) {
                l.add(aux.left);
            }
            if (aux.right != null) {
                l.add(aux.right);
            }
        }
        return out;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        BFS bfs = new BFS();

        for(String s: entrada){
            bfs.add(Integer.parseInt(s));
        }
        System.out.println(bfs.encLarg().trim());
    }
}
class Node20 {
    
    int value;
    Node20 left;
    Node20 right;
    Node20 parent;
    
    Node20(int v) {
        this.value = v;
    }
    public boolean isLeaf(){
        if (this.left == null && this.right == null) {
            return true;
        } return false;
    }
}
