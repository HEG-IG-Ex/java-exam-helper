package ComparatorsComparable;

public class Transaction implements Comparable<Transaction>{
    private int noTransaction;
    private Client emetteur;
    private Client recepteur;
    private int montant;
    private String devise;

    public Transaction(int noTransaction, Client emetteur, Client recepteur, int montant, String devise) {
        this.noTransaction = noTransaction;
        this.emetteur = emetteur;
        this.recepteur = recepteur;
        this.montant = montant;
        this.devise = devise;
    }

    public int getNoTransaction() {
        return noTransaction;
    }

    public void setNoTransaction(int noTransaction) {
        this.noTransaction = noTransaction;
    }

    public Client getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Client emetteur) {
        this.emetteur = emetteur;
    }

    public Client getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Client recepteur) {
        this.recepteur = recepteur;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    @Override
    public String toString() {
        return "Transaction " + this.getNoTransaction() + "\t"
                + this.emetteur.toString() + " ----> " + this.recepteur.toString() + "\t"
                + "Montant " + this.getMontant() + " " + this.getDevise();
    }

    @Override
    public int compareTo(Transaction that) {
        // Natural Sort By Devise // Emetteur // Receptuer

        int res = this.getDevise().compareToIgnoreCase(that.getDevise());
        if(res != 0){return res;}
        else{

            res = this.getEmetteur().compareTo(that.getEmetteur());

            if(res != 0){return res;}
            else{

                res = this.getRecepteur().compareTo(that.getRecepteur());

                if(res != 0){return res;}
                else{
                    return 0;
                }
            }
        }
    }

    public int comparePerEmetteur(Transaction that) {
        return (this.getEmetteur().compareTo(that.getEmetteur()));
    }

    public int comparePerRecepteur(Transaction that) {
        return (this.getRecepteur().compareTo(that.getRecepteur()));
    }
}