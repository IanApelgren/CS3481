package solution;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Sample program to show how to read the comma delimited text file pets.txt and
 * break the lines up into a name, age, and weight.
 * 
 * @author Ian Aplegren
 * @version ???
 * 
 */
public class FileReading
{
    private SortedLinkedList<Book> book = new SortedLinkedList<Book>();
    private Scanner fileIn = null;
    
    /**
     * Constructor reads from filename.
     * 
     * @param filename
     *            The name of the file.
     */
    public FileReading(String filename)
    {
        // open the input file
        try
        {
            setFileIn(new Scanner(new FileReader(filename)));
        }
        catch (IOException ioe)
        {
            System.out.println("Could not open the input file." + filename);
            System.exit(0);
        }

        // read the data
        readLines();

        // close the input file
        fileIn.close();
    }

    /**
     * Sets the input scanner.
     * 
     * @param input
     *            The input scanner.
     */
    public void setFileIn(Scanner input)
    {
        fileIn = input;
    }

    /**
     * Read lines of the file.
     */
    public void readLines()
    {
        String[] line;
        String author;
        String title;
        int numberOfPages;

        // as long as there are lines to read
        while (fileIn.hasNextLine())
        {
            // read a line from the file and split it
            // into an array of Strings around the commas
            line = fileIn.nextLine().split(",");
            // put the data before the first comma in petName
            author = line[0];
            // put the data before the second comma in petAge
            // after converting the String to an integer
            title = line[1];
            // put the data before the third comma in petWeight
            // after converting the String to a Double
            numberOfPages = Integer.parseInt(line[2]);
            // print out the data for testing to make sure it worked
            System.out.print("author: " + author + " ");
            System.out.print("title: " + title + " ");
            System.out.println("number of pages: " + numberOfPages);
            
        }
    }

    /**
     * The main program to read from pets.txt.
     * 
     * @param args
     *            unused.
     */
    public static void main(String[] args)
    {
        FileReading fileRead = new FileReading("bookdata.txt");
        for (Book o : fileRead.getBooks())
        {
            System.out.println(o.toString());
        }
        System.out.println();
        fileRead.printMoreThan300();
    }

    /**
     * why does book not look like a real word anymore.
     * @return book
     */
    public SortedLinkedList<Book> getBooks()
    {
        return book;
    }

    /**
     * prints all books greater than 300 pages.
     */
    public void printMoreThan300()
    {
        Book printBook;
        Iterator<Book> bookItr = this.book.iterator();
        while (bookItr.hasNext())
        {
            printBook = bookItr.next();
            if (printBook.getNumberOfPages() > 300)
            {
                System.out.println(printBook.toString());
            }
        }
    }
    
    /**
     * counts books and the pages in them then divides
     * @return asw the average number of pages
     */
    public double averagePages()
    {
        double avg = 0;
        int counter = 0;
        for (Book o : book)
        {
            avg += o.getNumberOfPages();
            counter++;
        }
        double asw = avg / counter;
        return asw;
    }
    /**
     * would remove less than 200
     */
    public void removeLessThan200()
    {
        
    }
}
