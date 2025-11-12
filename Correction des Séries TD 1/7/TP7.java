class Etudiant {
    private String nom;
    private int age;
    private double moyenne;

    // Constructeur
    public Etudiant(String nom, int age, double moyenne) {
        this.nom = nom;
        this.age = age;
        this.moyenne = moyenne;
    }

    // Méthode pour afficher les détails
    public void afficherDetails() {
        System.out.println("Nom : " + nom);
        System.out.println("Âge : " + age);
        System.out.println("Moyenne : " + moyenne);
    }

    // Méthode pour vérifier si l'étudiant est admis
    public boolean estAdmis() {
        return moyenne >= 10;
    }
}

public class TP7 {
    public static void main(String[] args) {
        // Création d'objets Etudiant
        Etudiant etudiant1 = new Etudiant("Alice", 20, 12.5);
        Etudiant etudiant2 = new Etudiant("Bob", 22, 8.0);

        // Affichage des détails et statut d'admission
        etudiant1.afficherDetails();
        System.out.println("Admis : " + etudiant1.estAdmis());
        System.out.println();

        etudiant2.afficherDetails();
        System.out.println("Admis : " + etudiant2.estAdmis());
    }
}
