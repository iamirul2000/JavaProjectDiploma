
public class Bus extends Ticket
{
    //Attributes
    private String busName;
    private String departDate;
    private String seatCategory;
    private String state;

    //Default Constructor
    public Bus()
    {
        super();
        busName = "";
        departDate = "";
        seatCategory = "";
        state = "";
    }

    //Normal Constructor
    public Bus(String n,String i,String b,String d, String sC, String s)
    {
        super(n,i);
        busName = b;
        departDate = d;
        seatCategory = sC;
        state = s;
    }

    //Mutator for All
    public void setAllBus(String n,String i,String b,String d, String sC, String s)
    {
        super.setAll(n,i);
        busName = b;
        departDate = d;
        seatCategory = sC;
        state = s;
    }

    //Mutator for each
    public void setBusName(String b)
    { busName = b; }
    public void setDepartDate(String d)
    { departDate = d; }
    public void setSeatCategory(String sC)
    { seatCategory = sC; }
    public void setState(String s)
    { state = s; }

    //Accessors
    public String getBusName()
    { return busName; }
    public String getDepartDate()
    { return departDate; }
    public String getSeatCategory()
    { return seatCategory; }
    public String getState()
    { return state; }

    //Processor
    public double calcFee()
    {   
        double price = 0.0;
        if(state.equalsIgnoreCase("Terengganu"))
        {
            if(seatCategory.equalsIgnoreCase("Business"))
            {
                price = 80.00;
            }
            else if(seatCategory.equalsIgnoreCase("Economy"))
            {
                price = 60.00;
            }
            else 
                price = 0.00;
        }
        else if(state.equalsIgnoreCase("Kelantan"))
        {
            if(seatCategory.equalsIgnoreCase("Business"))
            {
                price = 120.00;
            }
            else if(seatCategory.equalsIgnoreCase("Economy"))
            {
                price = 100.00;
            }
            else 
                price = 0.00;
        }
        else if(state.equalsIgnoreCase("Kedah"))
        {
            if(seatCategory.equalsIgnoreCase("Business"))
            {
                price = 60.00;
            }
            else if(seatCategory.equalsIgnoreCase("Economy"))
            {
                price = 40.00;
            }
            else 
                price = 0.00;
        }
        
        return price;
    }

    //Printer/Output
    public String printTicket()
    {
        return("\n    "+busName+" Ticket"+
               "\nCustomer Name: \t"+super.getName()+
               "\nIC : \t\t"+super.getIc()+
               "\nBus Name: \t"+busName+
               "\nDepart Date: \t"+departDate+
               "\nSeat: \t\t"+seatCategory+
               "\nState: \t\t"+state+
               "\nPrice:RM \t"+calcFee());
    }
}
