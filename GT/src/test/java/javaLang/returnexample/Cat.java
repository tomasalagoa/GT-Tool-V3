package javaLang.returnexample;

public class Cat extends Animal{
    
    public Cat(String name, int age, String race){
        super(name, age, race);
    }

    public Cat(String name){
        this(name, 20, "DOG");
    }

    public Cat(int age){
        this("SOMETHING", age, "RACER");
    }

    @Override
    public void sound(String str){
        System.out.println("Meow");
        executeQuery(str);
    }

    @Override
    public void superExample(String str){
        super.superExample(str);
        this.race = str;
    }

    public void executeQuery(Object o){}
}
