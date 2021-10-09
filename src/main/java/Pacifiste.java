public class Pacifiste extends Guerrier{
    public Pacifiste(String equipe){
        super(equipe);
        this.trait = "Pacifiste";
    }

    @Override
    public void action(){
        System.out.println("--| Le Pacifiste attends le prochain tour |--");
    }
}
