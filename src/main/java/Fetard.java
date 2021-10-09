public class Fetard extends Guerrier {
    public Fetard(String equipe){
        super(equipe);
        this.trait = "Fêtard";
    }

    @Override
    public void action(){
        System.out.println("--| Le Fêtard bois un peu (trop) de bières ! |--");
        this.efficacite = (int) (this.efficacite / 2);
    }
}
