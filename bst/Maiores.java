import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;

public class Maiores {
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
    public ArrayList<Integer> preOrder(){
        ArrayList<Integer> preO = new ArrayList<>();
        preOrderREC(this.root, preO);
        return preO;
    }

    private void preOrderREC(NodeG no, ArrayList<Integer> array){
        
        if (no != null) {
            array.add(no.value);
            preOrderREC(no.left, array);
            preOrderREC(no.right, array);
        }
    }
    public int qtdMaiores(int n){
        return contaMaiores(this.root, n);
    }
    public int contaMaiores(NodeG n, int v){
        if (n == null) {
            return 0;
        }
        if (n.value > v) {
            return 1 + contaMaiores(n.left, v) + contaMaiores(n.right, v);
        }
        return contaMaiores(n.left, v) + contaMaiores(n.right, v);

    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int n = sc.nextInt();
        sc.nextLine();
        Maiores bst = new Maiores();

        for(String s: entrada){
            bst.add(Integer.parseInt(s));
        }
        System.out.println(bst.preOrder().toString());
        System.out.println(bst.qtdMaiores(n));

    
    }
}
class NodeE {
    
    int value;
    NodeG left;
    NodeG right;
    NodeG parent;
    
    NodeE(int v) {
        this.value = v;
    }
    public boolean isLeaf(){
        if (this.left == null && this.right == null) {
            return true;
        } return false;
    }
}


