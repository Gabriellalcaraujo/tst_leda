import java.util.Scanner;
import java.util.LinkedList;

public class EncLarg {
    private NodeE root;
    private int size;
    
    public EncLarg(){
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
            this.root = new NodeE(element);
        else {
            
            NodeE aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        NodeE newNode = new NodeE(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        NodeE newNode = new NodeE(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
    }
    public String bstLarg(){
        LinkedList<NodeE> l = new LinkedList<>();
        if (this.root != null) l.add(this.root);
        String out = "";
        while (!l.isEmpty()) {
            NodeE aux = l.removeFirst();
            out += aux.value + " ";
            if(aux.right != null) l.add(aux.right);
            if(aux.left != null) l.add(aux.left);
        } return out;
    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        EncLarg bst = new EncLarg();

        for(String s: entrada){
            bst.add(Integer.parseInt(s));
        }
        System.out.println(bst.bstLarg().trim());

    }
}
class NodeD {
    
    int value;
    NodeE left;
    NodeE right;
    NodeE parent;
    
    NodeD(int v) {
        this.value = v;
    }
    public boolean isLeaf(){
        if (this.left == null && this.right == null) {
            return true;
        } return false;
    }
}
