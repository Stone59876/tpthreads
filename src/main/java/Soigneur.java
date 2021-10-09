public class Soigneur extends Guerrier{

    public Soigneur(String equipe){
        super(equipe);
        this.trait = "Soigneur";
    }

    @Override
    public void action(){
        this.vie = this.viemax;
        System.out.println("--| Le Soigneur récupère tout ses points de vies ! |--");
    }
}
