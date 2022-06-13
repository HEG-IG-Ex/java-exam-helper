package ComparatorsComparable;

import java.util.Objects;

public class Client  implements Comparable {
    private int idClient;
    private String nom;
    private String prenom;

    public Client(int idClient){
        this.idClient = idClient;
    }

    public Client(int idClient, String nom, String prenom) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCodeClient() {
        return this.getNom().substring(0, 3).toUpperCase()
                + this.getPrenom().substring(0,3).toUpperCase()
                + this.getIdClient();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client that = (Client) o;
        return this.getIdClient() == that.getIdClient();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdClient());
    }

    @Override
    public String toString() {
        return this.getCodeClient();
    }

    @Override
    public int compareTo(Object o) {
        // NATURAL SORT BY Code
        Client c = (Client) o;
        return this.getCodeClient().compareToIgnoreCase(c.getCodeClient());
    }
}