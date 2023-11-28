package FileCraft;

import java.io.File;
import java.util.Scanner;

import Hash.ClosedHashTable;

public class FileCraft {
  File file;
  ClosedHashTable hashTable;

  public FileCraft() {
    hashTable = new ClosedHashTable(26);
    file = new File("./src/FileCraft/Files/texto.txt");
  }

  public void readFile() {
    String palavra = "";
    int count = 0;
    try {
      Scanner input = new Scanner(file);

      while (input.hasNextLine()) {
        count++;
        String[] line = input.nextLine().split(" ");
        for (String word : line) {
          word = word.toUpperCase();
          word = word.replaceAll("[^A-Z]", "");

          hashTable.add(word, count);
        }
      }

      System.out.println(hashTable);
      input.close();
    } catch (Exception e) {
      System.out.println("We can't read your file! " + e);
    }
  }

  public void writeFile() {

  }
}
