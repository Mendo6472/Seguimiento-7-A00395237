package exceptions;

public class MaxAmmountOfIngredientsReachedException extends Exception{
    public MaxAmmountOfIngredientsReachedException(){
        super("Se ha llegado a la cantidad maxima de ingredientes para la receta.");
    }
}
