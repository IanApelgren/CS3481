package solution;

/**
 * 
 * @author Ian Apelgren
 * @version 4/1/2020
 */
public class Book implements Comparable<Book>
{

    private String author;
    private String title;
    private int numberOfPages;
    
    /**
     * books default constructor.
     * @param author a
     * @param title a
     * @param numberOfPages a
     */
    public Book(String author, String title, int numberOfPages)
    {
        this.author = author;
        this.title = title;
        this.numberOfPages = numberOfPages;
    }
    
    /**
     * auther getter.
     * @return author
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * title getter.
     * @return title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * numberOfPages getter.
     * @return numberOfPages a
     */
    public int getNumberOfPages()
    {
        return numberOfPages;
    }
    
    /**
     * auther setter.
     * @param author a
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    /**
     * title setter.
     * @param title a
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * number setter.
     * @param numberOfPages a
     */
    public void setNumberOfPages(int numberOfPages)
    {
        this.numberOfPages = numberOfPages;
    }
    /**
     * uses compareTo looking at author and then title if authors are same.
     * @return aComp s
     * 
     */
    @Override
    public int compareTo(Book o)
    {
        int aComp = this.author.compareTo(o.author);
        int tComp = this.title.compareTo(o.title);
        
        if (aComp == 0)
        {
            if (tComp == 0)
            {
                return 0;
            }
            else
            {
                return tComp;
            }
        }
        else
        {
            return aComp;
        }
    }
    
    /**
     * compares 2 books and returns true if equal and false if not
     * @param o a
     * @return boolean based on if they are the same
     */
    public boolean equals(Book o)
    {
        if (this.author.compareTo(o.author) == 0 
            && this.title.compareTo(o.title) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * toString print author title and number of pages
     * @return what is listed above
     */
    public String toString()
    {
        return (this.author + ", " + this.title + ", " + this.numberOfPages);
    }

    
}
