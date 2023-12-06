package Hash;

import java.text.Normalizer;

import List.DynamicList;
import Tree.SearchTree;

//Endereçamento fechado
public class ClosedHashTable {
  private SearchTree[] table;

  public ClosedHashTable(int size) {
    table = new SearchTree[size];
  }

  public void add(String element) {
    String word = element;
    element = element.toUpperCase();
    element = normalizeText(element);
    element = element.replaceAll("[^A-Z-]", "");

    int position = ((int) element.charAt(0)) - 65;

    if (table[position] == null) {
      table[position] = new SearchTree();
    }

    table[position].add(word);

  }

  public void findAndInsertLine(String element, int line) {

    String word = element;
    element = element.toUpperCase();
    element = normalizeText(element);
    element = element.replaceAll("[^A-Z-]", "");

    if (!element.equals("") && element.charAt(0) != '-') {
      int position = ((int) element.charAt(0)) - 65;

      if (table[position] != null) {
        table[position].research(word, line);
      }
    }

  }

  // public void remove(int element) {
  // int position = element % table.length;

  // if (table[position] != null) {
  // table[position].remove(element);
  // }
  // }

  public String show() {
    String result = "";
    for (SearchTree searchTree : table) {
      if (searchTree != null)
        result += searchTree.displayInOrder();
    }

    return result;
  }

  public static String normalizeText(String input) {
    // Remover acentos e normalizar para a forma NFD (Decomposition, Form)
    String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);

    // Substituir caracteres não ASCII
    normalized = normalized.replaceAll("[^\\p{ASCII}]", "");

    return normalized;
  }
}