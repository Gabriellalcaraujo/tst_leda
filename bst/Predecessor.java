import java.util.ArrayList;
import java.util.Scanner;

public class Predecessor {
    private NodeG root;
    private int size;
    
    public Maiores(){
        this.size = 0;
        this.root = null;
    }
    public boolean isEmpty() {
        return this.root == null;
    }
    
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.root = new NodeG(element);
        else {
            
            NodeG aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        NodeG newNode = new NodeG(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        NodeG newNode = new NodeG(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
    }
    private NodeG search(int n){
        NodeG aux = this.root;
        while (aux != null) {
            if (aux.value == n) {
                return aux;
            }
            else if (n < aux.value) {
                aux = aux.left;
            }else{
                aux = aux.right;
            }
        }return null;
    }

    private ArrayList<Integer> max(NodeG n, ArrayList<Integer> p){
        if (isEmpty()) {
            return null;
        }
        NodeG no = n;
        while (no.right != null) {
            p.add(no.value);
            no = no.right;
        }
        p.add(no.value);
        return p;
    }
    public ArrayList<Integer> predecessor(int k){
        NodeG no = search(k);
        if (no == null) {
            return null;
        }
        ArrayList<Integer> pred = new ArrayList<>();
        if (no.left != null) {
            pred.add(no.value);
            return max(no.left, pred);
        }
        else{
            NodeG aux = no.parent;
            pred.add(no.value);
            while (aux.parent != null && aux.value < no.value) {
                pred.add(aux.value);
                aux = aux.parent;
            }
            return pred;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int n = sc.nextInt();
        sc.nextLine();
        Predecessor p = new Predecessor();

        for(String s: entrada){
            p.add(Integer.parseInt(s));
        }
        System.out.println(p.predecessor(n).toString());
    }
}

class NodeG {
    
    int value;
    NodeG left;
    NodeG right;
    NodeG parent;
    
    NodeG(int v) {
        this.value = v;
    }
    public boolean isLeaf(){
        if (this.left == null && this.right == null) {
            return true;
        } return false;
    }
}