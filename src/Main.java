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
        return "______________________________________\n" + "Title: " +this.name + "\nAuthor: " + this.author + " \nPublished Year: " + this.publishedYear;
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
        return  "Printed Book info \n" + super.getInfo() + " \nNumber of pages: " + this.NumberOfPages + " \nPublisher: " + this.publisher;
    }

    @Override
    public void getDetails(){
        System.out.println(this.getInfo());
    }

    public void bookType(){
        System.out.println("this is a printed book");
    }

    public void printingBook() throws InterruptedException {
        System.out.println("Printing the book...");
        Thread.sleep(5000); // Sleeps for 1 second
        System.out.println(this.getInfo());
        Thread.sleep(1000);
        System.out.println("Book is printed");
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
        return "______________________________________\n" + "Ebook info\n" + super.getInfo() + "\nSize of book: " + this.SizeOfBook +"MB" + "\nFile format " + this.fileFormat;
    }

    @Override
    public void getDetails(){
        System.out.println(this.getInfo());
    }

    public void bookType(){
        System.out.println("this is e-book");
    }

    public void getPrice(){
        System.out.println(this.price);
    }


}


class Main{
    public static void main(String[] args) {
        Book book1 = new Book("The white pages of History", "Rozetta Aitmatova", 2014);
        book1.getDetails();

        PrintedBook book2 = new PrintedBook("The broken sword", "Chyngyz Aitmatov", 1990, 234, "Kyrgyz News");
        book2.getDetails();
        book2.bookType();
        book2.getPrice();
        try {
            book2.printingBook();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        EBook book3 = new EBook("By myself", "Marcus Aurelius", -100, 15, "pdf");
        book3.getDetails();
        book3.bookType();
        book3.getPrice();

    }

}

