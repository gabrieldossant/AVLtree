package org.arvore;

public class Remove extends Rotate {
    Node deletarNo(Node raiz, int chave) {


        // Caso a árvore esteja vazia, retorne null.
        if (raiz == null) {
            return raiz;
        }

        // Se a chave a ser removida é menor que a chave do nó atual, procure à esquerda.
        if (chave < raiz.chave) {
            raiz.esquerda = deletarNo(raiz.esquerda, chave);

        }
        // Se a chave a ser removida é maior que a chave do nó atual, procure à direita.
        else if (chave > raiz.chave) {
            raiz.direita = deletarNo(raiz.direita, chave);

        }
        // Se a chave é igual à chave do nó atual, este é o nó a ser removido.
        else {
            // Caso 1: nó com apenas um filho ou nenhum filho.
            if ((raiz.esquerda == null) || (raiz.direita == null)) {
                Node temp = (raiz.esquerda != null) ? raiz.esquerda : raiz.direita;

                // Se não houver filhos, simplesmente remove o nó atual.
                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else {
                    // Se houver um único filho, faz a troca do nó pelo seu filho.
                    raiz = temp;
                }
            } else {
                // Caso 2: nó com dois filhos, encontre o sucessor (menor valor na subárvore direita).
                Node temp = minValueNode(raiz.direita);
                // Copia o valor do sucessor para o nó atual.
                raiz.chave = temp.chave;
                // Remove o sucessor recursivamente da subárvore direita.
                raiz.direita = deletarNo(raiz.direita, temp.chave);
            }
        }


        // Se a árvore ficou vazia após a remoção, retorne null.
        if (raiz == null)
            return raiz;

        // Atualiza a altura do nó atual.
        raiz.height = Math.max(height(raiz.esquerda), height(raiz.direita)) + 1;

        // Verifica o balanceamento do nó atual.
        int balance = getBalance(raiz);

        // Caso 1: desbalanceado à esquerda e a subárvore esquerda é maior ou igual à direita.
        if (balance > 1 && getBalance(raiz.esquerda) >= 0)
            return DireitaRotate(raiz);

        // Caso 2: desbalanceado à esquerda, mas a subárvore direita da esquerda é maior.
        if (balance > 1 && getBalance(raiz.esquerda) < 0) {
            raiz.esquerda = EsquerdaRotate(raiz.esquerda);
            return DireitaRotate(raiz);
        }

        // Caso 3: desbalanceado à direita e a subárvore direita é maior ou igual à esquerda.
        if (balance < -1 && getBalance(raiz.direita) <= 0)
            return EsquerdaRotate(raiz);

        // Caso RL: desbalanceado à direita, mas a subárvore esquerda da direita é maior.
        if (balance < -1 && getBalance(raiz.direita) > 0) {
            raiz.direita = DireitaRotate(raiz.direita);
            return EsquerdaRotate(raiz);
        }

        // Retorna o nó raiz atualizado (após rotações).
        return raiz;
    }

    // Função auxiliar para encontrar o menor valor da subárvore direita.
    Node minValueNode(Node node) {
        Node current = node;
        while (current.esquerda != null) {
            current = current.esquerda;
        }
        return current;
    }
}
