package FactoryMethodPattern;

interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word document");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel document");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryMethodPattern {
    public static void main(String[] args) {
        DocumentFactory factory;

        factory = new WordFactory();
        Document wordDoc = factory.createDocument();
        wordDoc.open();

        factory = new PdfFactory();
        Document pdfDoc = factory.createDocument();
        pdfDoc.open();

        factory = new ExcelFactory();
        Document excelDoc = factory.createDocument();
        excelDoc.open();
    }
}
