import java.io.*;
import java.util.*;
public class TicketApp
{
    public static void main(String args[])throws Exception
    {
        Scanner in = new Scanner(System.in);
        Scanner inS = new Scanner(System.in);
        Scanner ws = new Scanner(System.in);
        Scanner toCont = new Scanner(System.in);

        System.out.println("\tMenu");
        System.out.print("------------------");
        System.out.print("\n[1]Add Customer");
        System.out.print("\n[2]Search Customer");
        System.out.print("\n[3]Print Ticket");
        System.out.print("\n[4]Print Summary");
        System.out.println("\n[5]Exit");
        System.out.print("------------------");
        System.out.print("\nChoose your option: ");
        int choice = inS.nextInt();

        try
        {
            FileReader fr = new FileReader("CustomerList.txt");
            BufferedReader br = new BufferedReader(fr);

            Ticket t[] = new Ticket[50];

            int countM = 0;
            int countB = 0;
            String input = null;
            int index = 0;

            while((input = br.readLine()) != null)
            {
                StringTokenizer st = new StringTokenizer(input,";");

                String name = st.nextToken();
                String ic = st.nextToken();
                String option = st.nextToken();

                if(option.equalsIgnoreCase("Movie"))
                {
                    String date = st.nextToken();
                    String movie = st.nextToken();
                    int age = Integer.parseInt(st.nextToken());
                    String seatM = st.nextToken();
                    String time = st.nextToken();

                    t[index] = new Movie(name,ic,date,movie,age,seatM,time);
                    countM++;
                }
                else if(option.equalsIgnoreCase("Bus"))
                {
                    String bus = st.nextToken();
                    String depart = st.nextToken();
                    String seatB = st.nextToken();
                    String state = st.nextToken();

                    t[index] = new Bus(name,ic,bus,depart,seatB,state);
                    countB++;
                }
                else
                { System.out.println("Error"); }

                index++;
            }

            boolean ans = true;
            while(ans)
            {
                if(choice == 1)
                {
                    System.out.print("Enter Name: ");
                    String name = ws.nextLine();
                    System.out.print("Enter Ic: ");
                    String ic = in.next();
                    System.out.println("Ticket Type (Movie | Bus)");
                    System.out.print("Enter Ticket Type: ");
                    String ticketType = in.next();
                    if(ticketType.equalsIgnoreCase("Movie"))
                    {
                        System.out.print("Enter Date: ");
                        String date = in.next();
                        System.out.print("Enter Movie Title: ");
                        String movie = ws.nextLine();
                        System.out.print("Enter Age: ");
                        int age = inS.nextInt();
                        System.out.print("Enter Seat Number: ");
                        String seatM = in.next();
                        System.out.print("Enter Time: ");
                        String time =in.next();

                        t[index] = new Movie(name,ic,date,movie,age,seatM,time);
                        countM++;

                    }
                    else if(ticketType.equalsIgnoreCase("Bus"))
                    {
                        System.out.print("Enter Bus Name: ");
                        String bus = ws.nextLine();
                        System.out.print("Enter Depart Date: ");
                        String depart = in.next();
                        System.out.println("Choose Seat Type (Business | Economy)");
                        System.out.print("Enter Seat Type: ");
                        String seatB = in.next();
                        System.out.println("Choose State (Kelantan | Terengganu | Kedah)");
                        System.out.print("Enter State: ");
                        String state = in.next();

                        t[index] = new Bus(name,ic,bus,depart,seatB,state);
                        countB++;
                    }
                    index++;

                    System.out.println("Enter to Continue");
                    String str = toCont.nextLine();

                    System.out.print("\n");
                    System.out.print("\f");
                    System.out.println("\tMenu");
                    System.out.print("------------------");
                    System.out.print("\n[1]Add Customer");
                    System.out.print("\n[2]Search Customer");
                    System.out.print("\n[3]Print Ticket");
                    System.out.print("\n[4]Print Summary");
                    System.out.println("\n[5]Exit");
                    System.out.print("------------------");
                    System.out.print("\nChoose your option: ");
                    choice = inS.nextInt();

                    FileWriter fw2 = new FileWriter("Added Customer.txt");
                    BufferedWriter bw2 = new BufferedWriter(fw2);
                    PrintWriter out2 = new PrintWriter(bw2);

                    for(int i = 0; i < index; i++)
                    {
                        if(t[i] instanceof Movie)
                        {
                            out2.println(t[i].printTicket());
                        }
                        if(t[i] instanceof Bus)
                        {
                            out2.println(t[i].printTicket());
                        }
                    }

                    out2.close();
                }

                else if(choice == 2)
                {
                    
                    int find = 0; 

                    System.out.println("Search Customer - Please Enter Name ");
                    System.out.print("Enter Name: ");
                    String search = ws.nextLine();
                    boolean found = true;

                    for(int i = 0; i < t.length; i++)
                    {
                        if(t[i] instanceof Movie)
                        {
                            Movie findM = (Movie)t[i];
                            if(findM.getName().equalsIgnoreCase(search))
                            {
                                System.out.println(findM.printTicket());
                                found = true;
                                break;
                            }
                            else
                            {
                                found = false;
                            }
                        }

                        else if(t[i] instanceof Bus)
                        {
                            Bus findB = (Bus)t[i];
                            if(findB.getName().equalsIgnoreCase(search))
                            {
                                System.out.println(findB.printTicket());
                                found = true;
                                break;
                            }
                            else
                            {
                                found = false;
                            }
                        }
                    }
                    

                    if(found == false)
                    {
                        System.out.println("Name Not Found");
                    }

                    boolean next;

                    System.out.println("Do you want to Continue Searching? [1]Yes | [2]No");
                    int str = inS.nextInt();

                    if(str == 1)
                        next = true;
                    else
                        next = false;

                    if(next == false)
                    {
                        System.out.print("\f");
                        System.out.print("\n");
                        System.out.println("\tMenu");
                        System.out.print("------------------");
                        System.out.print("\n[1]Add Customer");
                        System.out.print("\n[2]Search Customer");
                        System.out.print("\n[3]Print Ticket");
                        System.out.print("\n[4]Print Summary");
                        System.out.println("\n[5]Exit");
                        System.out.print("------------------");
                        System.out.print("\nChoose your option: ");
                        choice = inS.nextInt();
                    }

                }
                else if(choice == 3)
                {
                    System.out.println("Ticket has been printed");

                    FileWriter fw1 = new FileWriter("Ticket.txt");
                    BufferedWriter bw1 = new BufferedWriter(fw1);
                    PrintWriter out1 = new PrintWriter(bw1);

                    for(int i = 0; i < index; i++)
                    {
                        if(t[i] instanceof Movie)
                        {
                            out1.println(t[i].printTicket());
                        }

                        if(t[i] instanceof Bus)
                        {
                            out1.println(t[i].printTicket());
                        }
                    }

                    System.out.println("Enter to Continue");
                    String str = toCont.nextLine();

                    System.out.print("\n");
                    System.out.print("\f");
                    System.out.println("\tMenu");
                    System.out.print("------------------");
                    System.out.print("\n[1]Add Customer");
                    System.out.print("\n[2]Search Customer");
                    System.out.print("\n[3]Print Ticket");
                    System.out.print("\n[4]Print Summary");
                    System.out.println("\n[5]Exit");
                    System.out.print("------------------");
                    System.out.print("\nChoose your option: ");
                    choice = inS.nextInt();

                    out1.close();
                }

                else if(choice == 4)
                {
                    System.out.println("Summary has been calculated and store into file");

                    double collM = 0;
                    double collB = 0;
                    for(int i = 0; i < index; i++)
                    {
                        if(t[i] instanceof Movie)
                        {
                            collM = collM + t[i].calcFee();
                        }

                        if(t[i] instanceof Bus)
                        {
                            collB = collB + t[i].calcFee();
                        }
                    }

                    System.out.println("Enter to Continue");
                    String str = toCont.nextLine();

                    System.out.print("\n");
                    System.out.print("\f");
                    System.out.println("\tMenu");
                    System.out.print("------------------");
                    System.out.print("\n[1]Add Customer");
                    System.out.print("\n[2]Search Customer");
                    System.out.print("\n[3]Print Ticket");
                    System.out.print("\n[4]Print Summary");
                    System.out.println("\n[5]Exit");
                    System.out.print("------------------");
                    System.out.print("\nChoose your option: ");
                    choice = inS.nextInt();

                    int countTicket = countM + countB;
                    double GrandColl = collM + collB;

                    FileWriter fw2 = new FileWriter("Collection.txt");
                    BufferedWriter bw2 = new BufferedWriter(fw2);
                    PrintWriter out2 = new PrintWriter(bw2);

                    out2.println("Summary Ticketing System");
                    out2.print("\n");
                    out2.println("Ticket \tNo Of Ticket \t Collection(RM)");
                    out2.println("-----------------------------------------");
                    out2.println("Movie"+"\t\t"+countM+"\t\t"+collM);
                    out2.println("Bus"+"\t\t"+countB+"\t\t"+collB);
                    out2.println("-----------------------------------------");
                    out2.println("TOTAL"+"\t\t"+countTicket+"\t\t"+GrandColl);

                    out2.close();
                }
                else if(choice == 5)
                {
                    System.out.println("Thank You and GoodBye :)");
                    ans = false;
                    break;
                }
                else
                {
                    System.out.println("Option Not Found!");
                    System.out.println("Please Enter Again: ");

                    System.out.print("\n");
                    System.out.println("\tMenu");
                    System.out.print("------------------");
                    System.out.print("\n[1]Add Customer");
                    System.out.print("\n[2]Search Customer");
                    System.out.print("\n[3]Print Ticket");
                    System.out.print("\n[4]Print Summary");
                    System.out.println("\n[5]Exit");
                    System.out.print("------------------");
                    System.out.print("\nChoose your option: ");
                    choice = inS.nextInt();
                }

                br.close();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Problem: "+e.getMessage());
        }
        catch(IOException ioe)
        {
            System.out.println("Problem: "+ioe.getMessage());
        }
        catch(NoSuchElementException nse)
        {
            System.out.println("Problem: "+nse.getMessage());
        }
        finally
        {
            System.out.println("\nProccesing completed");
        }
    }

}
