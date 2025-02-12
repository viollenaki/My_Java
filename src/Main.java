import java.time.*;


class Book{
    String name;
    String author;
    int publishedYear;

    Book(String name, String author, int publishedYear){
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getInfo(){
        return this.name + ", " + this.author + ", " + this.publishedYear;
    }

    public void getDetails(){
        System.out.println(this.getInfo());
    }
}


class PrintedBook extends Book{
    int NumberOfPages;
    String publisher;
    int price = this.NumberOfPages * 10;

    PrintedBook(String name, String author, int publishedYear, int NumberOfPages, String publisher){
        super( name, author, publishedYear);
        this.NumberOfPages = NumberOfPages;
        this.publisher = publisher;
    }

    @Override
    public String getInfo(){
        return super.getInfo() + ", " + this.NumberOfPages + ", " + this.publisher;
    }

    @Override
    public void getDetails(){
        System.out.println(this.getInfo());
    }

    public void bookType(){
        System.out.println("This is a printed book");
    }

    public void printingBook() throws InterruptedException {
        System.out.println("Printing the book...");
        Thread.sleep(5000); // Sleeps for 1 second
        System.out.println(this.getInfo());
        Thread.sleep(1000);
        System.out.println("Book is printed.");
    }

    public void getPrice(){
        System.out.println(this.price);
    }


}

class EBook extends Book{
    double SizeOfBook;
    String fileFormat;
    double price = this.SizeOfBook * 10;

    EBook(String name, String author, int publishedYear, double SizeOfBook, String fileFormat){
        super( name, author, publishedYear);
        this.SizeOfBook = SizeOfBook;
        this.fileFormat = fileFormat;
    }

    @Override
    public String getInfo(){
        return super.getInfo() + ", " + this.SizeOfBook + ", " + this.fileFormat;
    }

    @Override
    public void getDetails(){
        System.out.println(this.getInfo());
    }

    public void bookType(){
        System.out.println("This is an e-book");
    }

    public void getPrice(){
        System.out.println(this.price);
    }


}


class Main{
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        book1.getDetails();

        PrintedBook book2 = new PrintedBook("The Catcher in the Rye", "JD Salinger", 1951, 234, "Little, Brown and Company");
        book2.getDetails();
        book2.bookType();
        book2.getPrice();
        try {
            book2.printingBook();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        EBook book3 = new EBook("The Hobbit", "J. R. R. Tolkien", 1937, 400, "epub");
        book3.getDetails();
        book3.bookType();
        book3.getPrice();

    }

}

