package ComparatorsComparable;

import java.util.Comparator;

public class ComparePerEmetteur implements Comparator<Transaction> {

    @Override
    public int compare(Transaction o1, Transaction o2) {return o1.comparePerEmetteur(o2);}
}

