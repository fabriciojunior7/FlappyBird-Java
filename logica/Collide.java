package logica;

public class Collide {

    //Metodos
    public static boolean rect(Entidade e1, Entidade e2){
        double distX = Math.abs((e1.getX() + e1.getLargura()/2) - (e2.getX() + e2.getLargura()/2));
        double distY = Math.abs((e1.getY() + e1.getAltura()/2) - (e2.getY() + e2.getAltura()/2));
        double largura = Math.abs(e1.getLargura()/2 + e2.getLargura()/2);
        double altura = Math.abs(e1.getAltura()/2 + e2.getAltura()/2);

        if(distX < largura && distY < altura){
            return true;
        }
        else {
            return false;
        }
    }

}
