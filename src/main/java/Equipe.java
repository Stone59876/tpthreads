import java.util.ArrayList;

public class Equipe {
    ArrayList<Guerrier> guerriers;
    String nom;

    public void afficher(){
        System.out.println("Equipe " + nom);
        int i = 0;
        for (Guerrier g:this.guerriers) {
            i = i+1;
            String pdv = "";
            if (g.vie > 100) {
                pdv = "████████████████";
            }
            else if (g.vie > 80) {
                pdv = "█████████████▒▒▒";
            }
            else if (g.vie > 60) {
                pdv = "██████████▒▒▒▒▒▒";
            }
            else if (g.vie > 40) {
                pdv = "█████▒▒▒▒▒▒▒▒▒▒▒";
            }
            else if (g.vie > 20) {
                pdv = "██▒▒▒▒▒▒▒▒▒▒▒▒▒▒";
            }
            else if (g.vie < 20){
                pdv = "█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒";
            }
            System.out.println("Guerrier "+ this.nom + " " + i + " : " + g.trait + " vie :" + pdv + " (" + g.vie + ")");
        }
    }

    public Equipe(String nom){
        this.nom = nom;
        this.guerriers = new ArrayList<Guerrier>();
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
            this.guerriers.add(new Soigneur(nom));
            this.guerriers.add(new Forgeron(nom));
            this.guerriers.add(new Barbare(nom));
            this.guerriers.add(new Pacifiste(nom));
            this.guerriers.add(new Fetard(nom));
        }
    }

}
