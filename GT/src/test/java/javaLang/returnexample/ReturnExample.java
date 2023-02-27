package javaLang.returnexample;

public class ReturnExample {
    /* 
     * Fazer aqui um teste que demonstre que se consegue propagar valores pelos returns também.
     * Experimentar fazer uma função com if/else onde manda class references diferentes (Pode ter a superclasse
     * como tipo de retorno e retornar a subclasse num dos retornos por exemplo). Ter também uma que manda um
     * valor String qualquer e outro return cujo valor não sabemos qual é. Tentar ter taintedness também é importante!
     * Pode haver 1 return tainted, outro não tainted por exemplo!
     * */

    public void method(int id){
        String query = someStringFunction(id);
        //vulnerability due to else path
        executeQuery(query);
        Animal animal = someCatClassRef(id);
        //line 18-19-20 same thing as comment above - only vulnerability due to Cat in else
        executeQuery(animal.age);
        sensitiveSink(animal);
        animal.sound(query);
        animal.testingNoOverride();
        query = someStringFunction(11);
        //No vulnerability 24-25
        sensitiveSink(animal);
        sensitiveSink(query);
        animal = someCatClassRef(8);
        //No vulnerability 28
        executeQuery(animal);

        //Tool should report 4 vulnerabilities in report
    }
    
    public String someStringFunction(int number){
        if(number > 10){
            return "Nothing here";
        } else{
            return "SELECT * ..." + number;
        }
    }

    public Animal someCatClassRef(int number){
        if(number < 10){
            return new Animal("Something", 7, "Hello");
        } else{
            return new Cat(number);
        }
    }

    public void executeQuery(Object o){}
    public void sensitiveSink(Object o){}
}
