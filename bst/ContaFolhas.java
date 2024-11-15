import java.util.Scanner;

public class ContaFolhas {
    private NodeG raiz;
    private int size;
    
    public ContaFolhas(){
        this.size = 0;
        this.raiz = null;
    }
    public boolean isEmpty() {
        return this.raiz == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.raiz = new NodeG(element);
        else {
            
            NodeG aux = this.raiz;
            
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
    public int contaF(){
        if (this.raiz != null) {
            return contaREC(this.raiz);
        }return 0; 
    }
    private int contaREC(NodeG no){
        if (no == null) {
            return 0;
        }
        if (no.isLeaf()) {
            return 1 + contaREC(no.right) + contaREC(no.left);
        }
        else{
            return 0 + contaREC(no.right) + contaREC(no.left);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arv = sc.nextLine().split(" ");
        ContaFolhas bst = new ContaFolhas();

        for(String s: arv){
            bst.add(Integer.parseInt(s));
        }
        System.out.println(bst.contaF());

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



