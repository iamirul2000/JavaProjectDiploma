
public abstract class Ticket
{
    //Attributes
    protected String name;
    protected String ic;
    
    //Default Constructor
    public Ticket()
    {
        name = "";
        ic = "";
    }
    
    //Normal Constructor
    public Ticket(String n,String i)
    {
        name = n;
        ic = i;
    }
    
    //Mutator for All
    public void setAll(String n,String i)
    {
        name = n;
        ic= i;
    }
    
    //Mutator for each
    public void setName(String n)
    {  name = n; }
    public void setIc(String i)
    {  ic = i; }
    
    //Accessors
    public String getName()
    { return name; }
    public String getIc()
    { return ic; }
    
    //Processor Abstract Method
    public abstract double calcFee();
    
    //Printter/Output Abstract Method
    public abstract String printTicket();
}
