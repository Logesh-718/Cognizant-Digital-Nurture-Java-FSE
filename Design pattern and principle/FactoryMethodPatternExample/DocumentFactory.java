package FactoryMethodPatternExample;

public class DocumentFactory {
     public Document createDocument(String type){

        if(type.equals("word"))
            return new WordDocument();

        else if(type.equals("pdf"))
            return new PdfDocument();

        else if(type.equals("excel"))
            return new ExcelDocument();

        return null;
    }
    
}
