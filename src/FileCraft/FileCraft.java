package FileCraft;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Scanner;

import Hash.ClosedHashTable;
import List.DynamicList;

public class FileCraft {
  File text;
  File key;
  File index;
  ClosedHashTable hashTable;

  public FileCraft() {
    hashTable = new ClosedHashTable(26);
    text = new File("./src/FileCraft/Files/texto.txt");
    key = new File("./src/FileCraft/Files/chave.txt");
    index = new File("./src/FileCraft/Files/index.txt");
  }

  public void readKeys() {
    try {
      Scanner inputKey = new Scanner(key);

      while (inputKey.hasNextLine()) {
        String[] lineKey = inputKey.nextLine().split(" ");

        for (String word : lineKey) {
          DynamicList totalOfLines;
          word = word.toUpperCase();
          word = normalizeText(word);
          word = word.replaceAll("[^A-Z-]", "");

          totalOfLines = compareWordsByText(word);

          hashTable.add(word, totalOfLines);
        }
      }

      System.out.println(hashTable.show());
      WriteIndex(hashTable.show());

    } catch (Exception e) {
      System.out.println("We can't read your file! " + e);
    }
  }

  public DynamicList compareWordsByText(String currentWord) {
    try {
      DynamicList totalOfLines = new DynamicList();
      int line = 0;

      Scanner inputText = new Scanner(text);
      while (inputText.hasNextLine()) {
        line++;
        String[] currentLine = inputText.nextLine().split(" ");

        for (String wordSearch : currentLine) {
          wordSearch = wordSearch.toUpperCase();
          wordSearch = normalizeText(wordSearch);
          wordSearch = wordSearch.replaceAll("[^A-Z-]", "");

          if (wordSearch.equals(currentWord)) {
            totalOfLines.add(line);
          }
        }
      }
      return totalOfLines;
    } catch (Exception e) {
      System.out.println("We can't compare your files!!");
      return null;
    }
  }

  public void WriteIndex(String line) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(index))) {
      writer.write(line);
      System.out.println("Index written to file successfully.");
    } catch (IOException e) {
      System.out.println("Error writing to the index file: " + e);
    }
  }

  public static String normalizeText(String input) {
    // Remover acentos e normalizar para a forma NFD (Decomposition, Form)
    String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);

    // Substituir caracteres não ASCII
    normalized = normalized.replaceAll("[^\\p{ASCII}]", "");

    return normalized;
  }
}
