public class Combat {
    Guerrier g1;
    Guerrier g2;
    boolean termine;

    public void afficher(){
        System.out.println("Guerrier 1");
        System.out.println("Equipe : " + g1.equipe);
        System.out.println("Trait : " + g1.trait );
        System.out.println("Guerrier 2");
        System.out.println("Equipe : " + g2.equipe);
        System.out.println("Trait : " + g2.trait );
        System.out.println("--------------------------------------");
    }

    public Combat(Guerrier g1,Guerrier g2){
        this.g1 = g1;
        this.g2 = g2;
        this.termine = false;
    }

    public Guerrier getG1(){
        return this.g1;
    }

    public Guerrier getG2(){
        return this.g2;
    }

    public void setTermine(boolean termine) {
        this.termine = termine;
    }

    public void combat(){
            Thread tourguerrier1 = new Thread() {
                public void run() {
                        Guerrier g1 = getG1();
                        Guerrier g2 = getG2();
                        g1.attaque(g2);
                    String pdv = "";
                    if (g2.vie > 100) {
                        pdv = "████████████████";
                    }
                    else if (g2.vie > 80) {
                        pdv = "█████████████▒▒▒";
                    }
                    else if (g2.vie > 60) {
                        pdv = "██████████▒▒▒▒▒▒";
                    }
                    else if (g2.vie > 40) {
                        pdv = "█████▒▒▒▒▒▒▒▒▒▒▒";
                    }
                    else if (g2.vie > 20) {
                        pdv = "██▒▒▒▒▒▒▒▒▒▒▒▒▒▒";
                    }
                    else if (g2.vie < 20){
                        pdv = "█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒";
                    }
                    System.out.println(g2.trait + " " + g2.equipe +" VIE: " + pdv +" (" + g2.vie + ")");
                        if (!g2.vivant) {
                            termine = true;
                            setTermine(true);
                        }
                        try {
                            Thread.sleep((int) (Math.random() * ((500 - 300) + 1)) + 300);
                            //.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            };
            Thread tourguerrier2 = new Thread() {
                public void run() {
                    Guerrier g1 = getG1();
                    Guerrier g2 = getG2();
                    g2.attaque(g1);
                    String pdv = "";
                    if (g1.vie > 100) {
                        pdv = "████████████████";
                    }
                    else if (g1.vie > 80) {
                        pdv = "█████████████▒▒▒";
                    }
                    else if (g1.vie > 60) {
                        pdv = "██████████▒▒▒▒▒▒";
                    }
                    else if (g1.vie > 40) {
                        pdv = "█████▒▒▒▒▒▒▒▒▒▒▒";
                    }
                    else if (g1.vie > 20) {
                        pdv = "██▒▒▒▒▒▒▒▒▒▒▒▒▒▒";
                    }
                    else if (g1.vie < 20){
                        pdv = "█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒";
                    }
                    System.out.println(g1.trait + " " + g1.equipe +" VIE: " + pdv +" (" + g1.vie + ")");
                    if (!g1.vivant) {
                        termine = true;
                        setTermine(true);
                    }
                        try {
                            Thread.sleep((int) (Math.random() * ((500 - 300) + 1)) + 300);
                            //Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            };
            tourguerrier1.start();
            tourguerrier2.start();
            while(!termine){
                tourguerrier1.run();
                tourguerrier2.run();
            }
            if (termine){
                if (g1.vivant) {
                    System.out.println("Le " +g1.trait + " " + g1.equipe + " remporte la victoire");
                    System.out.println("Il a desormais :" + this.g1.vie + "points de vies");
                }
                else
                {
                    System.out.println("Le " +g2.trait + " " + g2.equipe + " remporte la victoire");
                    System.out.println("Il a desormais :" + this.g2.vie + "points de vies");
                }
            }
        }

}
