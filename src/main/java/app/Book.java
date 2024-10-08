package app;

public class Book {

    private String title;
    private String auther;



    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", auther='" + auther + '\'' +
                ", publicationYear=" + publicationYear +
                ", pages=" + pages +
                ", rating=" + rating +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Book() {
    }

    public Book(String title, String auther, int publicationYear, int pages, double rating) {
        this.title = title;
        this.auther = auther;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.rating = rating;
    }

    private int publicationYear;
    private int pages;
    private double rating;


}
