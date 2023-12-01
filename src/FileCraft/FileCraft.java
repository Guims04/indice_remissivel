package FileCraft;

import java.io.File;
import java.util.Scanner;

import Hash.ClosedHashTable;
import List.DynamicList;

public class FileCraft {
  File text;
  File key;
  ClosedHashTable hashTable;

  public FileCraft() {
    hashTable = new ClosedHashTable(26);
    text = new File("./src/FileCraft/Files/texto.txt");
    key = new File("./src/FileCraft/Files/chave.txt");
  }

  public void readKeys() {
    try {
      Scanner inputKey = new Scanner(key);

      while (inputKey.hasNextLine()) {
        String[] lineKey = inputKey.nextLine().split(" ");

        for (String word : lineKey) {
          DynamicList totalOfLines;
          word = word.toUpperCase();
          word = word.replaceAll("[^A-Z]", "");

          totalOfLines = compareWordsByText(word);

          hashTable.add(word, totalOfLines);
        }
      }
      hashTable.show();
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
          wordSearch = wordSearch.replaceAll("[^A-Z]", "");

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
}
