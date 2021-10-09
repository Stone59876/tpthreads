public class Forgeron extends Guerrier{
    public Forgeron(String equipe){
        super(equipe);
        this.trait = "Forgeron";
    }

    @Override
    public void action(){
        System.out.println("--| Le Forgeron affûte son épée |--");
        int amelioration = (int) (this.attaque / 4);
        this.attaque = this.attaque + amelioration;
    }
}
