package org.arvore;

public class Search {
        public static Node search(int chave) {
            return searchRec(Rotate.raiz, chave);
        }

        private static Node searchRec(Node raiz, int key) {
            // Caso base: raiz é nula ou o valor está presente na raiz
            if (raiz == null || raiz.chave == key)
                return raiz;

            // Valor é maior que a raiz
            if (key > raiz.chave)
                return searchRec(raiz.direita, key);

            // Valor é menor que a raiz
            return searchRec(raiz.esquerda, key);
        }
}
