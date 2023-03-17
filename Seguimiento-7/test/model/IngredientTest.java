package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IngredientTest {

    Ingredient setupStage1Ingredient;

    public void setupStage1(){
        try {
            setupStage1Ingredient = new Ingredient();
            setupStage1Ingredient.setName("Tomate");
            setupStage1Ingredient.setWeight(245);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addWeightToIngredient(){
        setupStage1();
        boolean weightChanged = false;
        int weightToAdd = 54;
        try {
            setupStage1Ingredient.addWeight(weightToAdd);
            weightChanged = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(weightChanged);//Se verifica que el boolean adentro del try haya cambiado a true
        assertEquals(299, setupStage1Ingredient.getWeight());//Se vefirica que el ingrediente tenga el peso correcto
    }

    @Test
    public void addWrongWeightToIngredient(){
        setupStage1();
        boolean weightChanged = false;
        int weightToAdd = -100;
        try {
            setupStage1Ingredient.addWeight(weightToAdd);
            weightChanged = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(weightChanged);//Se verifica que el boolean no haya cambiado a true como pasa dentro del try
    }

    @Test
    public void removeWeightFromIngredient(){
        setupStage1();
        boolean weightChanged = false;
        int weightToRemove = 45;
        try {
            setupStage1Ingredient.removeWeight(weightToRemove);
            weightChanged = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(weightChanged);//Se verifica que el boolean adentro del try haya cambiado a true
        assertEquals(200, setupStage1Ingredient.getWeight());//Se vefirica que el ingrediente tenga el peso correcto
    }

    @Test
    public void removeWrongWeightFromIngredient(){
        setupStage1();
        boolean weightChanged = false;
        int weightToRemove = -100;
        try {
            setupStage1Ingredient.removeWeight(weightToRemove);
            weightChanged = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(weightChanged);//Se verifica que el boolean no haya cambiado a true como pasa dentro del try
    }



}
