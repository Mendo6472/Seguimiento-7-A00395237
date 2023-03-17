package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RecipeTest {
    Recipe setupStage1Recipe;
    Recipe setupStage2Recipe;

    public void setupStage1(){
        setupStage1Recipe = new Recipe();
    }

    public void setupStage2(){
        setupStage2Recipe = new Recipe();
        try {
            setupStage2Recipe.addIngredientToRecipe("Cebolla", 315);
            setupStage2Recipe.addIngredientToRecipe("Ajo", 58);
            setupStage2Recipe.addIngredientToRecipe("Arroz", 520);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addIngredientToEmptyRecipe(){
        setupStage1();
        boolean ingredientAdded = false;
        String name = "Sal";
        int weight = 12;
        Ingredient ingredientAddedToRecipe;
        try {
            setupStage1Recipe.addIngredientToRecipe(name, weight);
            ingredientAdded = true;
            ingredientAddedToRecipe = setupStage1Recipe.searchIngredientNameOnRecipe(name);
            assertNotNull(ingredientAddedToRecipe);//Se verifica que se haya añadido un ingrediente a la receta con el nombre "Sal"
            assertEquals(name, ingredientAddedToRecipe.getName());//Se verifica que ese ingrediente añadido tenga el mismo nombre que el deseado
            assertEquals(weight, ingredientAddedToRecipe.getWeight());//Se verifica que ese ingrediente añadido tenga el mismo peso que el deseado
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(ingredientAdded);//Se verifica que el boolean no haya cambiado a true como pasa dentro del try
        assertEquals(1, setupStage1Recipe.countIngredients());//Se verifica que solo haya un ingrediente en la receta

    }

    @Test 
    public void addIngredientToRecipe(){
        setupStage2();
        boolean ingredientAdded = false;
        String name = "Pimienta";
        int weight = 6;
        Ingredient ingredientAddedToRecipe;
        try {
            setupStage2Recipe.addIngredientToRecipe(name, weight);
            ingredientAddedToRecipe = setupStage2Recipe.searchIngredientNameOnRecipe(name);
            ingredientAdded = true;
            //Se verifican que los tres ingredientes creados en el setupStage2() sigan existiendo
            assertNotNull(setupStage2Recipe.searchIngredientNameOnRecipe("Cebolla"));
            assertNotNull(setupStage2Recipe.searchIngredientNameOnRecipe("Ajo"));
            assertNotNull(setupStage2Recipe.searchIngredientNameOnRecipe("Arroz"));
            assertNotNull(ingredientAddedToRecipe);//Se verifica que se haya añadido un ingrediente a la receta con el nombre "Pimienta"
            assertEquals(name, ingredientAddedToRecipe.getName());//Se verifica que ese ingrediente añadido tenga el mismo nombre que el deseado
            assertEquals(weight, ingredientAddedToRecipe.getWeight());//Se verifica que ese ingrediente añadido tenga el mismo peso que el deseado
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(ingredientAdded);//Se verifica que el boolean no haya cambiado a true como pasa dentro del try
        assertEquals(4, setupStage2Recipe.countIngredients());//Se verifica que hayan 4 ingredientes en la receta
    }

    @Test
    public void addIngredientThatAlreadyExistsToRecipe(){
        setupStage2();
        boolean ingredientAdded = false;
        String name = "Ajo";
        int weight = 21;
        Ingredient ingredientAddedToRecipe;
        try {
            setupStage2Recipe.addIngredientToRecipe(name, weight);
            ingredientAddedToRecipe = setupStage2Recipe.searchIngredientNameOnRecipe(name);
            ingredientAdded = true;
            //Se verifica que existan los ingredientes
            assertNotNull(setupStage2Recipe.searchIngredientNameOnRecipe("Cebolla"));
            assertNotNull(setupStage2Recipe.searchIngredientNameOnRecipe("Arroz"));
            assertNotNull(ingredientAddedToRecipe);
            //Se verifica que el ingrediente añadido/modificado tenga los atributos deseados
            assertEquals(name, ingredientAddedToRecipe.getName());
            assertEquals(weight, ingredientAddedToRecipe.getWeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(ingredientAdded);//Se verifica que el boolean no haya cambiado a true como pasa dentro del try
        assertEquals(3, setupStage2Recipe.countIngredients());//Se verifica que hayan 3 ingredientes en la receta
    }

    @Test
    public void removeIngredientFromRecipe(){
        setupStage2();
        String name = "Ajo";
        setupStage2Recipe.removeIngredientFromRecipe(name);
        assertNull(setupStage2Recipe.searchIngredientNameOnRecipe(name));//Se verifica que no haya un ingrediente con el nombre el cual acabamos de borrar
        //Se verifica que existan los otros dos ingredientes los cuales no se deberian haber borrado
        assertNotNull(setupStage2Recipe.searchIngredientNameOnRecipe("Cebolla"));
        assertNotNull(setupStage2Recipe.searchIngredientNameOnRecipe("Arroz"));
        assertEquals(2, setupStage2Recipe.countIngredients());//Se verifica que hayan 2 ingredientes en la receta
    }



}
