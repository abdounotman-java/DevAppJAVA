import java.util.Scanner;
public class TP5 {
    public static void main(String[] args) {
        // Déclaration de la variable pour stocker la somme des notes        
        int nbr = 05;
        int i;
        float [] T;
        T = new float[nbr];
        // Créer un objet Scanner pour lire l'entrée de l'utilisateur
        Scanner sc = new Scanner(System.in);
        // Saisie des notes pour les 05 étudiants
        for (i = 0; i < nbr ; i++) {
         System.out.print("Entrez la note de l'étudiant " + (i+1) + ": ");
            T[i] = sc.nextFloat();
        }
        System.out.println("Les notes des étudiants : ");
        // Afficher les notes pour les 05 étudiants
        float S=0;
        for (i = 0; i < nbr ; i++) {
            S=S+T[i];
         System.out.println("> La note de l'étudiant "+(i+1)+": " + T[i]);
        }
        System.out.println("La moyenn de la classe : " + (S/nbr));

        //somme += note;  // Ajouter la note à la somme totale
        // Calcul de la moyenne
        //double moyenne = somme / nombreEtudiants;
        //double somme = 0;
        // Affichage de la moyenne
        //System.out.println("La moyenne des notes est : " + moyenne);

        // Fermer le scanner
        sc.close();
    }
}
