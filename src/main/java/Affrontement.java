import java.util.ArrayList;
import java.util.Iterator;

public class Affrontement {
    Equipe equipe1;
    Equipe equipe2;
    ArrayList<Combat> combats;
    int nbmanche;

    public Affrontement(String nom1,String nom2){
        this.equipe1 = new Equipe(nom1);
        this.equipe2 = new Equipe(nom2);
        this.combats = new ArrayList<Combat>();
        this.nbmanche = 0;
    }

    public void Manche(Affrontement a){
        Iterator<Guerrier> i1 = a.equipe1.guerriers.iterator();
        Iterator<Guerrier> i2 = a.equipe2.guerriers.iterator();
        while (i1.hasNext() && i2.hasNext()){
            a.combats.add(new Combat(i1.next(),i2.next()));
            i1.remove();
            i2.remove();
            a.equipe1.afficher();
            a.equipe2.afficher();
        }

        if (!a.equipe1.guerriers.isEmpty()) {
            for (Guerrier g:a.equipe1.guerriers) {
                if (g.trait == "Barbare"){
                    g.action(a.combats.get((int) (Math.random() * ((a.combats.size()) ))).g2);
                }
                else
                {
                    g.action();
                }
            }
        }

        if (!a.equipe2.guerriers.isEmpty()) {
            for (Guerrier g:a.equipe2.guerriers) {
                if (g.trait == "Barbare"){
                    g.action(a.combats.get((int) (Math.random() * ((a.combats.size())))).g1);
                }
                else
                {
                    g.action();
                }
            }
        }

        for (Combat c:a.combats) {
            System.out.println("Combats:");
            c.afficher();
            c.combat();
            if (c.termine){
                if (c.g1.vivant){
                    a.equipe1.guerriers.add(c.g1);
                }
                else if (c.g2.vivant){
                    a.equipe2.guerriers.add(c.g2);
                }
            }
            a.equipe1.afficher();
            a.equipe2.afficher();
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|-----------------------| FIN DE LA MANCHE " + a.nbmanche + " |----------------------------|");
        System.out.println("-------------------------------------------------------------------------------");
        this.combats = new ArrayList<Combat>();
        a.equipe1.afficher();
        System.out.println("Il reste encore " +a.equipe1.guerriers.size() + " " + a.equipe1.nom);
        a.equipe2.afficher();
        System.out.println("Il reste encore " +a.equipe2.guerriers.size() + " " + a.equipe2.nom);

    }

    public static void main(String[] args) {
        Affrontement a = new Affrontement("Vikings","Sauvages");
        while(a.equipe1.guerriers.size() > 0 && a.equipe2.guerriers.size() > 0) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("|-------------------------------| MANCHE " + a.nbmanche + " |----------------------------|");
            System.out.println("-------------------------------------------------------------------------------");
            a.Manche(a);
            a.nbmanche = a.nbmanche + 1;
        }
        if (a.equipe2.guerriers.size() == 0){
            System.out.println("L'équipe " + a.equipe1.nom + " a gagné en " + a.nbmanche + " manches");
            System.out.println("Ils sont encore :" + a.equipe1.guerriers.size()+ " " +a.equipe1.nom) ;
        }
        if (a.equipe1.guerriers.size() == 0){
            System.out.println("L'équipe " + a.equipe2.nom + " a gagné en " + a.nbmanche + " manches");
            System.out.println("Ils sont encore :" + a.equipe2.guerriers.size()+ " " +a.equipe2.nom);
        }

    }
}
