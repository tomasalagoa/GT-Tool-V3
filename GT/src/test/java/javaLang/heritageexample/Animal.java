package javaLang.heritageexample;

public class Animal {
    protected String name;
    protected int age;
    protected String race;

    public Animal(String name, int age, String race){
        this.name = name;
        this.age = age;
        this.race = race;
    }

    public Animal(){}

    public void sound(){
        System.out.println("What's the sound of this animal?");
    }

    //Silly function to test "super" support in functions/methods
    public void superExample(String str){
        this.name = str;
    }
    
    public void testingNoOverride(){
        
    }
}
