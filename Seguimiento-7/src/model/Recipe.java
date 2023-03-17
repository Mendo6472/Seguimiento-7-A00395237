package model;

import exceptions.MaxAmmountOfIngredientsReachedException;

public class Recipe {

    Ingredient[] ingredients;
    public final int MAX_INGREDIENTS = 10;

    public Recipe(){
        ingredients = new Ingredient[MAX_INGREDIENTS];
    }

    public void addIngredientToRecipe(String name, int weight) throws Exception{
        try {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(name);
            ingredient.setWeight(weight);
            Ingredient ingredientExists = searchIngredientNameOnRecipe(ingredient.getName());
            if(ingredientExists != null){
                ingredientExists.setWeight(ingredient.getWeight());                
                return;
            }
            boolean ingredientAdded = false;
            for(int i = 0; i < MAX_INGREDIENTS && !ingredientAdded; i++){
                if(ingredients[i] == null){
                    ingredients[i] = ingredient;
                    ingredientAdded = true;
                }
            }
            if(!ingredientAdded) throw new MaxAmmountOfIngredientsReachedException();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeIngredientFromRecipe(String name){
        boolean ingredientRemoved = false;
        for(int i = 0; i < MAX_INGREDIENTS && !ingredientRemoved; i++){
            if(ingredients[i] != null){
                if(ingredients[i].getName().equals(name)){
                    ingredients[i] = null;
                    ingredientRemoved = true;
                }
            }
        }
    }

    public Ingredient searchIngredientNameOnRecipe(String name){
        for(int i = 0; i < MAX_INGREDIENTS; i++){
            if(ingredients[i] != null){
                if(ingredients[i].getName().equals(name)){
                    return ingredients[i];
                }
            }
        }
        return null;
    }

    public int countIngredients(){
        int counter = 0;
        for(int i = 0; i < MAX_INGREDIENTS; i++){
            if(ingredients[i] != null){
                counter++;
            }
        }
        return counter;
    }

}
