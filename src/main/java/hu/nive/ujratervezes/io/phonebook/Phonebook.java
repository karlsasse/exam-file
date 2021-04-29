package hu.nive.ujratervezes.io.phonebook;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
    Egy alkalmazást írunk, ahol a megrendelő szeretné az alkalmazásban tárolt ügyfeleit és azok telefonszámát exportálni fájlba.
    Hozd létre a Phonebook osztályt, és abban az exportPhonebook(Map<String, String> contacts, String output) metódust.
    A paraméterben kapott Mapben a kulcsok nevek, az értékek pedig telefonszámok.
    Írd ki az összes kulcs-érték párt az outputként megadott címre, minden kulcs-érték párt egy új sorba, az alábbi szintaxisban:
    név: telefonszám
    A kiírás sorrendje a fájlba nem fontos, de a Map összes elemét pontosan egyszer írd ki a fájlba!
    Ha a metódus akármelyik paraméternek null-t kapna, akkor dobj IllegalArgumentException-t!
 */

public class Phonebook {

    public void exportPhonebook(TreeMap<String, String> contacts, String actualPath) {
        try {
            if (actualPath == null) {
                throw new IllegalArgumentException();
            }
            File file = new File(actualPath);
            if (contacts == null) {
                if (file != null) {
                    file.delete();
                }
                System.out.println("file exists?: " + file.exists());
                throw new IllegalArgumentException();
            }
            FileWriter fileWriter = new FileWriter(file);
            if (contacts.isEmpty()) {
                return;
            }
            actualPath = "";
            Set<String> keys = contacts.keySet();
            for (String key : keys) {
                if (key == null)
                    throw new IllegalArgumentException();
                String tel = contacts.get(key);
                if (tel == null)
                    throw new IllegalArgumentException();
                actualPath += key + ": " +tel + "\n";
            }
            fileWriter.write(actualPath);
            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println(actualPath + " not exists.");
        }
    }
}