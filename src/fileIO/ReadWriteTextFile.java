package fileIO; /**
 * 63-21 - Approfondissement de la programmation
 * Langage Java : Différentes façons de lire/écrire des fichiers
 *
 * @author Ch. Stettler - HEG-Genève
 */

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ReadWriteTextFile {

    public static void readLoopWithoutSplitLineByLineFileToStr(String filename) {
        // Utilisation d'une méthode outils.FileToStr.lireCsv() qui retourne tous les CHAMPS du fichier
        // Un tableau de String à 2 dimensions contient chaque ligne / chaque colonne

        // SANS SPLIT

        String[][] contenuFichier = FileToStr.lireCsv(filename);
        for (String[] ligne : contenuFichier) {
            int champ1 = Integer.parseInt(ligne[0]);
            String champ2 = ligne[1];
            String champ3 = ligne[2];
            for (String champ : ligne) {
                System.out.println(champ);
            }
        }
    }

    public static void readLoopWithSplitLineByLineFileToStr(String filename) {
        // Utilisation d'une méthode outils.FileToStr.lireLignes() qui retourne toutes les LIGNES du fichier
        // Décomposition des lignes en utilisant ligne.split(";") ==> permet de décomposer à l'aide d'un String séparateur

        // AVEC SPLIT

        String[] contenuFichier = FileToStr.lireLignes(filename);
        for (String ligne : contenuFichier) {
            String[] champs = ligne.split(";");
            int champ1 = Integer.parseInt(champs[0]);
            String champ2 = champs[1];
            String champ3 = champs[2];
            for (String champ : champs) {
                System.out.println(champ);
            }
        }
    }

    public static void readTokenizerLineByLineFileToStr(String filename) {
        // Utilisation d'une méthode outils.FileToStr.lireLignes() qui retourne toutes les LIGNES du fichier
        // Décomposition des lignes en utilisant un StringTokenizer ==> permet de décomposer à l'aide d'une liste de caractères séparateur

        // AVEC TOKENIZER / LIGNES

        String[] contenuFichier = FileToStr.lireLignes(filename);
        for (String ligne : contenuFichier) {
            StringTokenizer strTok = new StringTokenizer(ligne, ";:.,/");
            while (strTok.hasMoreTokens()) {
                System.out.println(strTok.nextToken());
            }
        }
    }

    public static void readCharByChar(String filename) throws IOException {
        // Utilisation d'un FileReader pour accéder au fichier
        // Lecture caractère par caractère du fichier

        // CHAR BY CHAR

        FileReader reader = new FileReader(filename);
        int caractere;
        while ((caractere = reader.read()) != -1) {
            System.out.println((char) caractere);
        }
        reader.close();
    }

    public static void readBufferedReaderLoop(String filename) throws IOException {
        // Utilisation d'un BufferedReader afin de pouvoir lire une ligne entière (readLine)

        // LIGNE PAR LIGNES TOUT UN FICHIER

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String ligne;
        while ((ligne = reader.readLine()) != null) {
            System.out.println(ligne);
        }
        reader.close();
    }

    public static void readBufferedReaderLambda(String path) throws IOException {
        String separator = ";";

        // LIGNE PAR LIGNES en LAMBDA

        List<String[]> output = new BufferedReader(new FileReader(new File(path)))
                .lines()
                .map(s -> {
                    return s.split(separator);
                })
                .collect(Collectors.toList());
    }

    public static void write_version1(String filename, List<String> data) throws IOException {
        // Utilisation d'un FileWriter pour accéder au fichier en écriture
        FileWriter writer = new FileWriter(filename /* le 2ème paramètre 'append' permet de compléter le fichier */);
        for (String ligne : data) {
            writer.write(ligne + "\n");
        }
        writer.close();
    }
}