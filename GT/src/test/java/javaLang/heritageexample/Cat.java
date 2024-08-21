package javaLang.heritageexample;

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
    public void sound(){
        System.out.println("Meow");
    }

    @Override
    public void superExample(String str){
        super.superExample(str);
        this.race = str;
    }

    public void method(int id){
        Cat cat = new Cat("Katto");
        cat.superExample("LMAO");
        Cat something = new Cat(id);
        executeQuery(cat);
        //Vuln here
        executeQuery(something);
    }

    public void executeQuery(Cat c){}
    
    public void main(String[] args){
        Cat cat = new Cat("cat", 3, "striped");
        Animal animal = new Animal("animal", 4, "test");
        //Selects sound from Cat class
        cat.sound();
        //Selects sound from Animal class
        animal.sound();
        //Selects testingNoOverride from Animal class
        cat.testingNoOverride();
    }
}
