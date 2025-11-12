

public class Compte { 
    // Attributs
    private int code;
    protected float solde;
    
    // Constructeur
    public Compte (int c, float s) {
        code=c; solde=s;
    }

    // Méthode pour verser un montant 
    public void verser (float mt) {
    solde+=mt;
    }

    // Méthode pour retirer un montant 
    public void retirer (float mt){
    solde-=mt;
    }

    // Une méthode qui retourne l'état du compte 
    public String toString(){
    return(" Code="+code+" Solde="+solde);
    }

public static void main(String[] args) {
Compte c1=new Compte (1,5000);
Compte c2=new Compte (2,6000);
c1.verser (3000);
c1. retirer (2000);
System.out.println(c1.toString());
System.out.println(c2.toString());
}

}