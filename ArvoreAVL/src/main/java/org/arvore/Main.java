package org.arvore;

import javax.swing.*;

public class Main {
    private static Node raiz = null;
    private static Insert insert = new Insert();
    private static Remove remove = new Remove();
    private static Search search = new Search();
    private static Rotate rotate = new Rotate();
    private static Balance balance = new Balance();

    public static void main(String[] args) {
        // Loop principal para exibir o menu de opções repetidamente até o usuário sair
        while (true) {
            // Opções para o menu
            String[] options = {"Inserir", "Remover", "Rotação à esquerda", "Balançar", "Exibir Árvore", "Sair"};

            // Exibe uma caixa de opções que armazena a escolha do usuário
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma operação:",
                    "Árvore de Busca Binária Interativa",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            // Escolha se o usuário queira sair
            if (choice == -1 || choice == options.length - 1) {
                break;
            }

            switch (choice) {
                case 0: // Inserindo um valor na árvore
                    String insertchave = JOptionPane.showInputDialog("Digite um valor para inserir:");
                    if (insertchave != null) { // Verifica se há um valor
                        int chave = Integer.parseInt(insertchave);
                        raiz = insert.insert(raiz, chave);
                        JOptionPane.showMessageDialog(null, "Valor" + chave + "inserindo.");
                    }
                    break;
                case 1:
                    String removechave = JOptionPane.showInputDialog("Digite o valor para remover:");
                    if (removechave != null) {
                        int chave = Integer.parseInt(removechave);
                        raiz = remove.deletarNo(raiz, chave);
                        JOptionPane.showMessageDialog(null, "Valor " + chave + " removido.");
                    }
                    break;
                case 2:
                    String searchchave = JOptionPane.showInputDialog("Digite o valor para buscar:");
                    if (searchchave != null) {
                        int chave = Integer.parseInt(searchchave);
                        Node foundNode = search.search(raiz.chave);
                        if (foundNode != null) {
                            JOptionPane.showMessageDialog(null, "Nó encontrado: " + foundNode.chave);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nó não encontrado.");
                        }
                    }
                    break;
                case 3: // Rotação à Esquerda
                    raiz = rotate.EsquerdaRotate(raiz);
                    JOptionPane.showMessageDialog(null, "Rotação à esquerda realizada.");
                    break;
                case 4: // Rotação à Direita
                    raiz = rotate.DireitaRotate(raiz);
                    JOptionPane.showMessageDialog(null, "Rotação à direita realizada.");
                    break;
                case 5: // Balancear
                    raiz = balance.balance(raiz);
                    JOptionPane.showMessageDialog(null, "Árvore balanceada.");
                    break;
                case 6: // Exibir Árvore
                    String treeStructure = getTreeStructure(raiz, 0);
                    JOptionPane.showMessageDialog(null, treeStructure.isEmpty() ? "Árvore vazia." : treeStructure);
                    break;
            }
        }

    }

    // Método recursivo para gerar uma representação da árvore como String com indentação
    private static String getTreeStructure(Node node, int level) {
        if (node == null) {
            return ""; // Retorna vazio se o nó for nulo (nó folha)
        }
        StringBuilder builder = new StringBuilder();
        // Recorre pelo lado direito primeiro (nós maiores) para exibir de forma hierárquica
        builder.append(getTreeStructure(node.direita, level + 1));
        // Adiciona o valor do nó com indentação proporcional ao nível (para representar hierarquia)
        builder.append(" ".repeat(level * 4)).append(node.chave).append("\n");
        // Recorre pelo lado esquerdo (nós menores)
        builder.append(getTreeStructure(node.esquerda, level + 1));
        return builder.toString(); // Retorna a estrutura da árvore como uma String
    }

}

    }