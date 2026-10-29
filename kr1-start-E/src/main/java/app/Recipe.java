/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;


public class Recipe {
   private String name;
   private String cuisine;
   private String mainIngredient;
   private int minutes;

    public Recipe(String name, String cuisine, String mainIngredient, int minutes) {
        this.name = name;
        this.cuisine = cuisine;
        this.mainIngredient = mainIngredient;
        this.minutes = minutes;
    }

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }


    @Override
    public String toString() {
        return name + " (" + cuisine + ") - " + minutes + " мин" ;
    }
  
}
