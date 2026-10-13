
package test;

import entities.*;
import java.util.Scanner;

public class TestBibliotheque {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Donner la capacité de la bibliothèque : ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n < 2) {
            System.out.println(
                "La capacité doit être au moins égale à 2."
            );
            sc.close();
            return;
        }

        Bibliotheque b = new Bibliotheque(n);

        // Initialisation avec deux documents
        Livre l1 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry");
        Revue r1 = new Revue("Science et Vie", 15, 2025);

        b.ajouter(l1);
        b.ajouter(r1);

        int choix;

        do {
            System.out.println("\n      MENU BIBLIOTHEQUE     ");
            System.out.println("1. Afficher les documents");
            System.out.println("2. Ajouter un livre");
            System.out.println("3. Ajouter une revue");
            System.out.println("4. Supprimer un document");
            System.out.println("5. Rechercher un document");
            System.out.println("6. Afficher les auteurs");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {

                case 1:
                    b.afficherDocuments();
                    break;

                case 2:
                    System.out.print("Titre du livre : ");
                    String titre = sc.nextLine();

                    System.out.print("Auteur : ");
                    String auteur = sc.nextLine();

                    Livre livre = new Livre(titre, auteur);

                    if (b.ajouter(livre)) {
                        System.out.println(
                            "Livre ajouté. Numéro : "
                            + livre.getNumEnreg()
                        );
                    } else {
                        System.out.println(
                            "Échec : bibliothèque pleine."
                        );
                    }
                    break;

                case 3:
                    System.out.print("Titre de la revue : ");
                    String titreRevue = sc.nextLine();

                    System.out.print("Numéro de la revue : ");
                    int numero = sc.nextInt();

                    System.out.print("Année : ");
                    int annee = sc.nextInt();
                    sc.nextLine();

                    Revue revue = new Revue(
                        titreRevue, numero, annee
                    );

                    if (b.ajouter(revue)) {
                        System.out.println(
                            "Revue ajoutée. Numéro : "
                            + revue.getNumEnreg()
                        );
                    } else {
                        System.out.println(
                            "Échec : bibliothèque pleine."
                        );
                    }
                    break;

                case 4:
                    System.out.print(
                        "Numéro du document à supprimer : "
                    );
                    int numSup = sc.nextInt();
                    sc.nextLine();

                    Document docSup = b.document(numSup);

                    if (docSup != null && b.supprimer(docSup)) {
                        System.out.println("Document supprimé.");
                    } else {
                        System.out.println("Document introuvable.");
                    }
                    break;

                case 5:
                    System.out.print(
                        "Numéro du document à rechercher : "
                    );
                    int numRecherche = sc.nextInt();
                    sc.nextLine();

                    Document doc = b.document(numRecherche);

                    if (doc != null) {
                        System.out.println(doc);
                    } else {
                        System.out.println("Document introuvable.");
                    }
                    break;

                case 6:
                    b.afficherAuteurs();
                    break;

                case 0:
                    System.out.println("Fin du programme.");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        sc.close();
    }
}
