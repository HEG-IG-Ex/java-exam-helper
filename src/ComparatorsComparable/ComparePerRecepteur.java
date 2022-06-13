package ComparatorsComparable;

import java.util.Comparator;

public class ComparePerRecepteur implements Comparator<Transaction> {
    @Override
    public int compare(Transaction o1, Transaction o2) {return o1.comparePerRecepteur(o2);}
}
