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
    try {
      Scanner input = new Scanner(file);

      while (input.hasNext()) {
        palavra = input.next();
        palavra = palavra.replaceAll("[^a-zA-Z]", "");
        palavra = palavra.toUpperCase();

        hashTable.add(palavra);

      }
      System.out.println(hashTable);
      input.close();
    } catch (Exception e) {
      System.out.println("We can't read your file! " + e);
    }
  }
}
