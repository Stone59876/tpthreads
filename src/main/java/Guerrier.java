public abstract class Guerrier {
    int vie;
    int viemax;
    int attaque;
    int efficacite;
    String trait;
    boolean vivant;
    String equipe;

    public void action(){

    }

    public void action(Guerrier g){

    }

    public void attaque(Guerrier g) {
        System.out.println("[Le " + g.trait + " " + g.equipe + " tente une attaque]");
        int chance = (int) (Math.random() * ((100) + 1)) ;
        if (this.efficacite >= chance){
            System.out.println("/// Il touche sa cible ///");
            int pdvrestant = g.vie  - this.attaque;
            if (pdvrestant <= 0){
                g.vivant = false;
                int regeneration = (int) this.vie * 1/3;
                if(this.vie + regeneration <= this.viemax){
                    this.vie = this.vie + regeneration;
                }
                else {
                    this.vie = this.viemax;
                }
            }
            else
            {
                g.vie = pdvrestant;
            }
        }
    }

    public Guerrier(){
        this.viemax = (int) (Math.random() * ((150 - 100) + 1)) + 100;
        this.vie = this.viemax;
        this.attaque = (int) (Math.random() * ((50 - 30) + 1)) + 30;
        this.efficacite = (int) (Math.random() * ((100 - 30) + 1)) + 30;
        this.vivant = true;
    }
    public Guerrier(String equipe){
        this.viemax = (int) (Math.random() * ((150 - 100) + 1)) + 100;
        this.vie = this.viemax;
        this.attaque = (int) (Math.random() * ((50 - 30) + 1)) + 30;
        this.efficacite = (int) (Math.random() * ((100 - 30) + 1)) + 30;
        this.vivant = true;
        this.equipe = equipe;
    }

}
