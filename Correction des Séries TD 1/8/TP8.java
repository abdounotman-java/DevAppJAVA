// Classe Employe
class Employe {
    protected String nom;
    protected String prenom;
    protected double salaire;

    public Employe(String nom, String prenom, double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
    }

    public void afficherDetails() {
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Salaire : " + salaire + " Dh");
    }
}

// Classe Manager
class Manager extends Employe {
    private double prime;

    public Manager(String nom, String prenom, double salaire, double prime) {
        super(nom, prenom, salaire);
        this.prime = prime;
    }

    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Prime : " + prime + " Dh");
    }
}

// Classe principale
public class TP8 {
    public static void main(String[] args) {
        // Création d'employés et de managers
        Employe employe1 = new Employe("ZAIDI", "Mohamed", 7000);
        Manager manager1 = new Manager("MEKI", "Samir", 13500, 1500);

        // Tableau d'employés
        Employe[] personnels = { employe1, manager1 };

        // Affichage des détails
        for (Employe employe : personnels) {
            employe.afficherDetails();
            System.out.println("-------------------------");
        }
    }
}
