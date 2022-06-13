import ComparatorsComparable.ComparePerEmetteur;
import ComparatorsComparable.ComparePerRecepteur;
import ComparatorsComparable.Transaction;
import Exceptions.LoadDataException;
import fileIO.ReadWriteTextFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GestionApp {
    private static final String FILENAME = "donnees.txt";
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        createDummmyFile();

    }

    private static void createDummmyFile() {
        // Création d'un fichier contenant quelques lignes de texte
        ArrayList<String> data = new ArrayList<>();
        data.add("1;Première;ligne");
        data.add("2;ème;ligne");
        data.add("3;ème;ligne");
        data.add("4;Dernière;ligne");

        try {
            ReadWriteTextFile.write_version1(FILENAME, data);
            ReadWriteTextFile.readBufferedReaderLambda(FILENAME);
        } catch (IOException IOE) {
            System.err.println("ERROR - When reading/writing in the file " + FILENAME);
        }

    }

    private void trierPar(String critere){
        Comparator comparator = null;
        switch (critere){
            case "emetteur":
                comparator = new ComparePerEmetteur();
                break;
            case "recepteur":
                comparator = new ComparePerRecepteur();
                break;
        }
        Collections.sort(this.transactions, comparator);
    }

    private Transaction transformStrToTransaction(String[] event) throws LoadDataException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        String type = event[0];
        String name = event[1];
        String venue = event[4];
        String state = event[5];
        String artist = event[6];

        try {

            Date date = formatter.parse(event[2]);
            Integer subscriptions = Integer.parseInt(event[3]);
            //return new Transaction();

        } catch (ParseException PE) {
            throw new LoadDataException("ERROR - The date of the event " + name + " seems incorrect - Date:" + event[2]);
        } catch (NumberFormatException NFE) {
            throw new LoadDataException("ERROR - The number of subscription for the event " + name + " seems incorrect - Subs:" + event[3]);
        }
        return null;
    }

}
