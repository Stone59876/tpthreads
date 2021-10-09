public class Barbare extends Guerrier {
    public Barbare(String equipe){
        super(equipe);
        this.trait = "Barbare";
    }

    @Override
    public void action(Guerrier g){
        System.out.println("--| Le Barbare attaque un ennemi aléatoire ! |--");
        this.attaque(g);
    }
}
