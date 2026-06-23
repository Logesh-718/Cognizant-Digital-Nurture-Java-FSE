package FactoryMethodPatternExample;

public class main {
     public static void main(String[] args){

        DocumentFactory factory =
                new DocumentFactory();

        Document d =
                factory.createDocument("pdf");

        d.open();
    }
    
}
