package org.arvore;

public class Rotate {

    //define raiz
    public static Node raiz;

    //Função que serve para adquirir a altura de um nó
    public static int height(Node N) {
        if (N == null)
            return 0; //Se a altura de um nó for null irá retornar zero.
        return N.height;
    }

    //Realiza uma rotação pra direita
    public static Node DireitaRotate(Node y) {
        Node x = y.esquerda;
        Node Aux = x.direita; //Nó auxiliar temporário que permite que uma rotação possa ser feita

        //rotação

        x.direita = y;
        y.esquerda = Aux;

        return x;

    }

    //realiza uma rotação pra esquerda

    public static Node EsquerdaRotate(Node x) {
        Node y = x.direita;
        Node Aux = y.esquerda;

        //rotação

        y.esquerda = x;
        x.direita = Aux;

        return y;

    }

}