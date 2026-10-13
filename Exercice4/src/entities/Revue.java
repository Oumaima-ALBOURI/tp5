
package entities;

public class Revue extends Document {
    private int numero;
    private int annee;

    public Revue(String titre, int numero, int annee) {
        super(titre);
        this.numero = numero;
        this.annee = annee;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "Revue{" +
                "numEnreg=" + getNumEnreg() +
                ", titre='" + getTitre() + '\'' +
                ", numero=" + numero +
                ", annee=" + annee +
                '}';
    }
}
