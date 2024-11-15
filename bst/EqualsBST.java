import java.util.ArrayList;
import java.util.Scanner;

public class EqualsBST {
    private NodeZ root;
    private int size;
    
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
            this.root = new NodeZ(element);
        else {
            
            NodeZ aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        NodeZ newNode = new NodeZ(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        NodeZ newNode = new NodeZ(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
        
    }
    
    
    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public NodeZ search(int element) {
        NodeZ aux = this.root;
        while (aux != null) {
            if (aux.value == element) {
                return aux;
            }
            if (element < aux.value) {
                aux = aux.left;
            }else{
                aux = aux.right;
            }
        }return null;

    }
    
    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        return height(this.root);
    }
    
    private int height(NodeZ no){
        if (no == null) {
            return -1;
        }
        else{
            return 1 + Math.max(height(no.left),height(no.right));
        }

    }

    public boolean equals(EqualsBST outra) {

        return (this.preOrder()).equals(outra.preOrder());
    }

    /**
    * Retorna o número de folhas da árvore.
    */
    public int contaFolhas() {
        return contaFolhas(this.root);
    }
    private int contaFolhas(NodeZ no) {
        if (isEmpty()) {
            return 0;
        }
        else if (no.left == null && no.right == null) {
            return 1;
        }
        else{
            return contaFolhas(no.left) + contaFolhas(no.right);
        }
    }
    
    public ArrayList<Integer> preOrder(){
        ArrayList<Integer> preO = new ArrayList<>();
        preOrder(this.root, preO);
        return preO;
    }

    private void preOrder(NodeZ no, ArrayList<Integer> array){
        
        if (no != null) {
            array.add(no.value);
            preOrder(no.left, array);
            preOrder(no.right, array);
        }
    }

    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }
    private NodeZ min(NodeZ n){
        if (isEmpty()) {
            return null;
        }
        NodeZ no = n;
        while (no.left != null) {
            no = no.left;
        }
        return no;
    }

    private NodeZ max(NodeZ n){
        if (isEmpty()) {
            return null;
        }
        NodeZ no = n;
        while (no.right != null) {
            no = no.right;
        }
        return no;
    }


    public NodeZ predecessor(int k){
        NodeZ no = search(k);
        if (no == null) {
            return null;
        }
        if (no.left != null) {
            return max(no.left);
        }
        else{
            NodeZ aux = no.parent;
            while (aux.parent != null && aux.value < no.value) {
                aux = aux.parent;
            }
            return aux;
        }

    }
    public NodeZ sucessor(int k){
        NodeZ no = search(k);
        if (no == null) {
            return null;
        }
        if (no.right != null) {
            return min(no.right);
        }
        else{
            NodeZ aux = no.parent;
            while (aux.parent != null && aux.value > no.value) {
                aux = aux.parent;
            }
            return aux;
        }

    }
    public void remove(int k){
        NodeZ remover = search(k);
        if (remover.isLeaf()) {
            if (remover == this.root) {
                this.root = null;
            }
            else{
                if (remover.value < remover.parent.value) {
                    remover.parent.left = null;
                }else{
                    remover.parent.right = null;
                }
            }
        }   
        else if (remover.oneChild() != null) {
            NodeZ aux = remover.oneChild();
            if (remover.value == this.root.value) {
                this.root = aux;
                this.root.parent = null;
            }
            else if (remover.parent.value > remover.value) {
                remover.parent.left = aux;
                aux.parent = remover.parent;
            }
            else {
                remover.parent.right = aux;
                aux.parent = remover.parent;
            }
        }
        else{
            NodeZ sucessor = sucessor(remover.value);
            remover.value = sucessor.value;
            remove(sucessor.value);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] e1 = sc.nextLine().split(" ");
        String[] e2 = sc.nextLine().split(" ");

        EqualsBST bst1 = new EqualsBST();
        for(String s: e1){
            bst1.add(Integer.parseInt(s));
        }
        EqualsBST bst2 = new EqualsBST();
        for(String l: e2){
            bst2.add(Integer.parseInt(l));
        }
        System.out.println(bst1.equals(bst2));
    }
    
}


class NodeZ {
    
    int value;
    NodeZ left;
    NodeZ right;
    NodeZ parent;
    
    NodeZ(int v) {
        this.value = v;
    }
    public boolean isLeaf(){
        if (this.left == null && this.right == null) {
            return true;
        } return false;
    }
    public NodeZ oneChild(){
        if (this.left != null && this.right == null) {
            return this.left;
        }
        else if (this.left == null && this.right != null) {
            return this.right;
        } return null;
    }
}

