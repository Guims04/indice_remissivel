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
          hashTable.add(word);
        }
      }

      inputKey.close();
    } catch (Exception e) {
      System.out.println("We can't read your file! " + e);
    }
  }

  public void compareText() {
    try {
      int line = 0;

      Scanner inputText = new Scanner(text);
      while (inputText.hasNextLine()) {
        line++;
        String[] currentLine = inputText.nextLine().split(" ");

        for (String wordSearch : currentLine) {
          hashTable.findAndInsertLine(wordSearch, line);
        }
      }

      System.out.println(hashTable.show());
      WriteIndex(hashTable.show());

      inputText.close();
    } catch (Exception e) {
      System.out.println("We can't compare your files!!");
      System.out.println(e);
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
}
