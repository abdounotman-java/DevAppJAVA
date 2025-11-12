import java.io.*;
import java.util.*;

// 🧩 Classe Etudiant : représente un étudiant avec ses attributs
class Etudiant {
    private String num;
    private String nom;
    private String email;
    private double note;

    // Constructeur
    public Etudiant(String num, String nom, String email, double note) {
        this.num = num;
        this.nom = nom;
        this.email = email;
        this.note = note;
    }

    // Méthode pour retourner les données sous forme de texte
    public String formatFichier() {
        return num + ";" + nom + ";" + email + ";" + note;
    }

    // Getters (optionnels, pour lecture future)
    public String getNum() { return num; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public double getNote() { return note; }
}


//  Classe principale : Gestion des étudiants dans un fichier
public class GestionEtudiantClss {
    static final String FICHIER = "Etudiant.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int choix;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Créer le fichier");
            System.out.println("2. Inscrire un étudiant");
            System.out.println("3. Afficher les étudiants");
            System.out.println("4. Supprimer le fichier");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine(); // vider le buffer

            switch (choix) {
                case 1:
                    creer();
                    break;
                case 2:
                    inscription();
                    break;
                case 3:
                    afficher();
                    break;
                case 4:
                    supprimer();
                    break;
                case 0:
                    System.out.println("Fin du programme. ");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }

    // 🧱 Méthode 1 : Création du fichier
    public static void creer() {
        try {
            File fichier = new File(FICHIER);
            if (fichier.createNewFile()) {
                System.out.println(" Fichier créé avec succès !");
            } else {
                System.out.println(" Le fichier existe déjà.");
            }
        } catch (IOException e) {
            System.out.println(" Erreur lors de la création du fichier !");
        }
    }

    // 🧾 Méthode 2 : Inscription d’un étudiant via la classe Etudiant
    public static void inscription() {
        try (FileWriter writer = new FileWriter(FICHIER, true)) {
            System.out.print("Numéro : ");
            String num = sc.nextLine();
            System.out.print("Nom : ");
            String nom = sc.nextLine();
            System.out.print("Email : ");
            String email = sc.nextLine();
            System.out.print("Note : ");
            double note = sc.nextDouble();
            sc.nextLine(); // vider buffer

            // Création de l’objet Etudiant
            Etudiant etu = new Etudiant(num, nom, email, note);

            // Écriture dans le fichier via la méthode formatFichier()
            writer.write(etu.formatFichier() + "\n");

            System.out.println(" Étudiant inscrit avec succès !");
        } catch (IOException e) {
            System.out.println(" Erreur lors de l’inscription !");
        }
    }

    // Méthode 3 : Affichage du contenu du fichier
    public static void afficher() {
        try (BufferedReader br = new BufferedReader(new FileReader(FICHIER))) {
            System.out.println("\n===== LISTE DES ÉTUDIANTS =====");
            String ligne;
            System.out.println("Numéro\t\tNom\t\tEmail\t\t\t\tNote\n");
            while ((ligne = br.readLine()) != null) {
                String[] data = ligne.split(";");
                if (data.length == 4) {
                    System.out.printf("%-10s %-15s %-25s %-5s%n",
                            data[0], data[1], data[2], data[3]);
                }
            }
        } catch (IOException e) {
            System.out.println(" Erreur lors de la lecture du fichier !");
        }
    }

    // 🧱 Méthode 4 : Suppression du fichier
    public static void supprimer() {
        File fichier = new File(FICHIER);
        if (fichier.delete()) {
            System.out.println(" Fichier supprimé avec succès !");
        } else {
            System.out.println(" Impossible de supprimer le fichier (peut-être inexistant).");
        }
    }
}
