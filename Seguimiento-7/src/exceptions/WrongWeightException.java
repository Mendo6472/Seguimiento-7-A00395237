package exceptions;

public class WrongWeightException extends Exception{
    public WrongWeightException(){
        super("El peso que has introducido no es correcto.");
    }
}
