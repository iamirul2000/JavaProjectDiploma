
public class Movie extends Ticket
{
    //Attributes
    private String date;
    private String movieTitle;
    private int age;
    private String numSeat;
    private String time;

    //Default Constructor
    public Movie()
    {
        super();
        date = "";
        movieTitle = "";
        age = 0;
        numSeat = "";
        time = "";
    }

    //Normal Constructor
    public Movie(String n,String i,String d,String m,int a, String nS, String t)
    {
        super(n,i);
        date = d;
        movieTitle = m;
        age = a;
        numSeat = nS;
        time = t;
    }

    //Mutator for All
    public void setAllMovie(String n,String i,String d,String m,int a, String nS, String t)
    {
        super.setAll(n,i);
        date = d;
        movieTitle = m;
        age = a;
        numSeat = nS;
        time = t;
    }

    //Mutator for each
    public void setDate(String d)
    { date = d; }
    public void setMovieTitle(String m)
    { movieTitle = m; }
    public void setAge(int a)
    { age = a; }
    public void setNumSeat(String nS)
    { numSeat = nS; }
    public void setTime(String t)
    { time = t; }
    
    //Accessors
    public String getDate()
    { return date; }
    public String getMovieTitle()
    { return movieTitle; }
    public int getAge()
    { return age; }
    public String getNumSeat()
    { return numSeat; }
    public String getTime()
    { return time; }

    //Processor
    public double calcFee()
    {
        double price = 0.0;
        if(age < 12)
            price = 15.00;
        else
            price = 25.00;

        return price;
    }

    //Printer/Output
    public String printTicket()
    {
        return("\n\tGSC Cinemas"+
               "\nCustomer Name: \t"+super.getName()+
               "\nIc: \t\t"+super.getIc() +
               "\nMovie Title: \t"+movieTitle+
               "\nMovie Date: \t"+date+
               "\nMovie Time: \t"+time+
               "\nNo of Seat: \t"+numSeat+
               "\nPrice:RM \t"+calcFee());
    }

}
