package org.arvore;

public class Node {
    public int chave, height; //permite que o tamnho e chave do nó possam ser armazenadas
    public Node esquerda, direita;

    public Node(int d) {
        chave = d; //d = valor vazio que permite que qualquer valor possa ser armazenado neste nó.
        height = 1; //define com que o tamanho de um novo nó seja 1 por padrão

        //caso for mudar alguma coisa nessa classe avise no grupo primeiro.
    }
}