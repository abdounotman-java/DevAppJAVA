import java.io.*;
import java.util.Scanner;

public class GestionEtudiant {
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
                    System.out.println("Fin du programme. 👋");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }

    // 🧱 Méthode 1 : création du fichier
    public static void creer() {
        try {
            File fichier = new File(FICHIER);
            if (fichier.createNewFile()) {
                System.out.println("Fichier créé avec succès !");
            } else {
                System.out.println("Le fichier existe déjà.");
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la création du fichier !");
        }
    }

    // 🧾 Méthode 2 : inscription d’un étudiant
    public static void inscription() {
        try (FileWriter writer = new FileWriter(FICHIER, true)) {
            System.out.print("Numéro : ");
            String num = sc.nextLine();
            System.out.print("Nom : ");
            String nom = sc.nextLine();
            System.out.print("Prénom : ");
            String prenom = sc.nextLine();
            System.out.print("Email : ");
            String email = sc.nextLine();
            System.out.print("Note : ");
            String note = sc.nextLine();

            writer.write(num + ";" + nom + ";" + prenom + ";" + email + ";" + note + "\n");
			
            System.out.println("Étudiant inscrit avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de l’inscription !");
        }
    }

    // 📖 Méthode 3 : affichage du contenu du fichier
    public static void afficher() {
        try (BufferedReader br = new BufferedReader(new FileReader(FICHIER))) {
            System.out.println("\n===== LISTE DES ÉTUDIANTS =====");
            String ligne;
			System.out.println("Numéro\t\tNom\t\tPrénom\t\tEmail\t\t\t\tNote\n");
            while ((ligne = br.readLine()) != null) {
                String[] data = ligne.split(";");
                System.out.println(data[0] + "\t\t" + data[1] +
                        "\t\t" + data[2] + "\t\t" + data[3] +
                        "\t\t" + data[4]);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier !");
        }
    }

	// 🧱 Méthode 4 : Supprimer du fichier
    public static void supprimer() {
            File fichier = new File(FICHIER);
			fichier.delete();            
    }

}

