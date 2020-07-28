import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyGymManager extends Application {
    final static int maximumMembers = 100;//Maximum number of members
    private static ArrayList<DefaultMember> membersDataHolder = new ArrayList<>();//Arraylist to store all the member objects


    //Methods for Menu Option
    private void addMember(){
        exitMenu:
        if(membersDataHolder.size()!=100) { //Checking the member list full or not
            while (true) {
                System.out.println("=======Adding Members=======");//Welcome message
                System.out.println("Please Select the Member Type\n1 - Default Member\n2 - Student Member\n3 - Over 60 Member\n4 - exit : ");//selecting the member type
                Scanner scanner = new Scanner(System.in);
                String memberType = scanner.nextLine();
                switch (memberType) {
                    case ("1"):
                        String mType = "Default Member";
                        System.out.println("=====Please fill the following details=====");
                        System.out.println("Name of the Member : ");//getting the member name
                        String mName = scanner.nextLine();
                        System.out.println("Membership Number : ");//getting the membership number
                        String mNumber = scanner.nextLine();
                        System.out.println("=====Please Fill the date details bellow=====");
                        System.out.println("Enter the day : ");//getting the day
                        int mDay = scanner.nextInt();
                        System.out.println("Enter the month : ");//getting the month
                        int mMonth = scanner.nextInt();
                        System.out.println("Enter the Year : ");//getting the year
                        int mYear = scanner.nextInt();
                        Date date = new Date(mDay, mMonth, mYear);//Creating the date object and setting the values
                        DefaultMember defaultMember = new DefaultMember(mName, mNumber, date,mType);//Creating the default member class and setting the values
                        membersDataHolder.add(defaultMember);//adding member object to the data holder ArrayList
                        break;
                    case ("2"):
                        String sType = "Student Member";
                        System.out.println("=====Please fill the following details=====");
                        System.out.println("Name of the Member : ");//getting the member name
                        String sName = scanner.nextLine();
                        System.out.println("Membership Number : ");//getting the membership number
                        String sNumber = scanner.nextLine();
                        System.out.println("Enter the School Name : ");//getting the school name
                        String schoolName = scanner.nextLine();
                        System.out.println("=====Please Fill the date details bellow=====");
                        System.out.println("Enter the day : ");//getting the day
                        int sDay = scanner.nextInt();
                        System.out.println("Enter the month : ");//getting the month
                        int sMonth = scanner.nextInt();
                        System.out.println("Enter the Year : ");//getting the year
                        int sYear = scanner.nextInt();
                        Date dateS = new Date(sDay, sMonth, sYear);//Creating the date object and setting the values
                        StudentMember studentMember = new StudentMember(schoolName, sName, sNumber, dateS,sType);//Creating the student member object and setting the values
                        membersDataHolder.add(studentMember);//adding member object to the data holder ArrayList
                        break;
                    case ("3"):
                        String oType = "Over 60 Member";
                        System.out.println("=====Please fill the following details=====");
                        System.out.println("Name of the Member : ");//getting the member name
                        String oName = scanner.nextLine();
                        System.out.println("Membership Number : ");//getting the membership number
                        String oNumber = scanner.nextLine();
                        System.out.println("Enter the Member age : ");//getting the member age
                        String mAge = scanner.nextLine();
                        System.out.println("=====Please Fill the date details bellow=====");
                        System.out.println("Enter the day : ");//getting the day
                        int oDay = scanner.nextInt();
                        System.out.println("Enter the month : ");//getting the month
                        int oMonth = scanner.nextInt();
                        System.out.println("Enter the Year : ");//getting the year
                        int oYear = scanner.nextInt();
                        Date dateO = new Date(oDay, oMonth, oYear);//Creating the date object and setting the values
                        Over60Member over60Member = new Over60Member(mAge, oName, oNumber, dateO,oType);//Creating the Over 60 Member object and setting the values
                        membersDataHolder.add(over60Member);//adding member object to the data holder ArrayList
                        break;
                    case ("4"):
                        break exitMenu;
                    default:
                        System.out.println("Please Enter a Valid Option !");
                }
            }
        } else {
            System.out.println("Members are full!");//Error message for full list
        }
    }

    private void deleteMember(){
        System.out.println("======Delete Members======");
        System.out.println("Enter the Membership Number : ");//Getting the membership number
        Scanner scanner = new Scanner(System.in);
        String mNumber = scanner.nextLine();
        for (int find = 0; find < membersDataHolder.size(); find++){//checking all the objects to a matching membership number
            if(mNumber.equals(membersDataHolder.get(find).getMembershipNumber())){//if the entered membership number matched
                System.out.println(membersDataHolder.get(find).getMemberType()+" with Membership Number "+mNumber+" Deleted");//console message for deletion
                membersDataHolder.remove(find);//deleting the object from the data holder Arraylist
                break;
            }
        }
    }

    private void printMembers(){
        if(membersDataHolder.size()!=0) {//checking the list is empty or not
            System.out.println("==========Members==========");
            System.out.println("Membership No.\t\tMember Type\t\t Starting Date\t\tMember Name");
            for (int count = 0; count < membersDataHolder.size(); count++) {//Getting the details from the data holder Arraylist
                System.out.println(membersDataHolder.get(count).getMembershipNumber() + "\t\t\t\t"
                        + membersDataHolder.get(count).getMemberType() + "\t\t" +
                        membersDataHolder.get(count).getMemberShipDate().getDay()+"/"
                        +membersDataHolder.get(count).getMemberShipDate().getMonth()+"/"
                        +membersDataHolder.get(count).getMemberShipDate().getYear()
                        + "\t\t" + membersDataHolder.get(count).getMemberName());
            }
        } else {
            System.out.println("No data in Member List!");//Error message for empty list
        }
    }

    private void sortMembers(){
        String tempName;//Temporary String for bubble sorting
        int nameCount = 1;
        ArrayList<String> memberNames = new ArrayList<>();//To store all the object names
        if(membersDataHolder.size()!=0) {//Checking whether there is data to sort or not
            System.out.println("===========Names Sorted===========");
            for (int d = 0; d < membersDataHolder.size(); d++) {//Adding all the member names into the Arraylist
                memberNames.add(d, membersDataHolder.get(d).getMemberName());
            }
            for (int firstName = 0; firstName < memberNames.size(); firstName++) {//Bubble sorting
                for (int secondName = firstName + 1; secondName < memberNames.size(); secondName++) {
                    if (memberNames.get(secondName).compareTo(memberNames.get(firstName)) < 0) {//Comparing the first and second name character value using ASCII
                        tempName = memberNames.get(firstName);
                        memberNames.set(firstName, memberNames.get(secondName));
                        memberNames.set(secondName, tempName);
                    }
                }
                System.out.println(" " + String.join(" ", +nameCount + ". " + memberNames.get(firstName)));//Console output
                nameCount++;
            }
        } else {
            System.out.println("No data to sort !");//Error message for the empty data
        }
    }

    private void writeToFile() throws IOException {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("Details.txt");//Creating the file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Membership No.\t\tMember Type\t\t Starting Date\t\tMember Name");
            bufferedWriter.newLine();
            for(int w = 0; w<membersDataHolder.size();w++){//Writing the data into the text file
                bufferedWriter.write(membersDataHolder.get(w).getMembershipNumber() + "\t\t"
                        + membersDataHolder.get(w).getMemberType() + "\t\t" +
                        membersDataHolder.get(w).getMemberShipDate().getDay()+"/"
                        +membersDataHolder.get(w).getMemberShipDate().getMonth()+"/"
                        +membersDataHolder.get(w).getMemberShipDate().getYear()
                        + "\t\t" + membersDataHolder.get(w).getMemberName());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e){
            System.out.println("Error Occurred");//Error message for console
        }
    }

    private void openGui(){
        //Creating the list view
        ListView listView = new ListView();

        //Resize the list view
        listView.setPrefSize(600,400);

        //Creating the Border Pane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(listView);
        Scene scene = new Scene(borderPane,600,450);

        //Adding details to the list view
        if(membersDataHolder.size()!=0) {
            for (int h = 0; h < membersDataHolder.size(); h++) {
                listView.getItems().add("Member Name "+membersDataHolder.get(h).getMemberName() + "\t\t\t"
                        +"Membership No. "+ membersDataHolder.get(h).getMembershipNumber() + "\t\t" +
                        "Membership Type "+ membersDataHolder.get(h).getMemberType() + "\t\t" +
                        "Membership Date "+ membersDataHolder.get(h).getMemberShipDate().getDay()+"/"
                        +membersDataHolder.get(h).getMemberShipDate().getMonth()+"/"
                        +membersDataHolder.get(h).getMemberShipDate().getYear()
                        + "\t\t" + membersDataHolder.get(h).getMemberName());
            }
        } else {
            listView.getItems().add("No data to Display");
        }

        //Creating the stage
        Stage guiStage = new Stage();

        //Setting the stage
        guiStage.setTitle("MyGym Manager");
        guiStage.setScene(scene);
        guiStage.showAndWait();

    }

    public static void main(String[] args) {launch();}

    //Calling the methods to the console menu
    @Override
    public void start(Stage primaryStage) throws Exception {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("***Welcome to My Gym Manager***");
            System.out.println("A - add a new Member");
            System.out.println("B - delete a Member");
            System.out.println("C - print the list of Members");
            System.out.println("D- sort the item");
            System.out.println("E - write member details to a file");
            System.out.print("F - open GUI window : ");
            String menuSelect = scanner.nextLine().toUpperCase();
            switch (menuSelect) {
                case ("A"):
                    addMember();
                    break;
                case ("B"):
                    deleteMember();
                    break;
                case ("C"):
                    printMembers();
                    break;
                case ("D"):
                    sortMembers();
                    break;
                case ("E"):
                    writeToFile();
                    break;
                case ("F"):
                    openGui();
                    break;
                default:
                    System.out.println("Please enter a valid option!");
                    break;
            }

        }
    }
}
