import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int floor,room;
        String buyer;
        String breakLine= "----------------------------------------------";
        System.out.println("---------------Custom Yuor Condo---------------");
        //todo enter number of floor
        while (true){
            System.out.print("Enter Number of Floor: ");
            floor= input.nextInt();
            if(floor<=0){
                System.out.println("Floor can not be Zero(0) or Nagative number(-)!!");
                floor= input.nextInt();
            }else {
                break;
            }
        }
        // todo enter number of room
        while (true){
            System.out.print("Enter Numbre of room in each floor: ");
            room = input.nextInt();
            if(room<=0){
                System.out.println("Room can not be Zero(0) or Nagative number(-)!!");
                room= input.nextInt();
            }else {
                break;
            }
        }
        int total = floor *room;
        System.out.println("Total Condo : "+ total);
        // todo choose option
        String condo[][] = new String[floor][room];
        int buyFloor,buyRoom;
        while (true){
            System.out.println("------------WELCOME TO ODINN CONDO-------------");
            System.out.println("1. Buy Condo");
            System.out.println("2. Sell Condo");
            System.out.println("3. Search Information");
            System.out.println("4. Display Information");
            System.out.println("0. Exit");
            System.out.println(breakLine);
            System.out.print("Choose option(0-4): ");
            int option = input.nextInt();
            switch (option){
                case 1:
                {
                    System.out.println("---------------Buy Center---------------");
                    //
                    again:
                    while (true){
                        // todo checking buying floor
                        while (true){
                            System.out.print("Enter the Floor: ");
                            buyFloor= input.nextInt();
                            if(buyFloor<=0){
                                System.out.println("Floor can not be Zero(0) or Nagative number(-)!!");
                                buyFloor= input.nextInt();
                            } else if (buyFloor > floor) {
                                System.out.println("We have only "+ floor + " floors!!");
                            } else {
                                break;
                            }
                        }
                        // todo checking buying room
                        while (true){
                            System.out.print("Enter the Room: ");
                            buyRoom = input.nextInt();
                            if(buyRoom<=0){
                                System.out.println("Room can not be Zero(0) or Nagative number(-)!!");
                                buyRoom= input.nextInt();
                            } else if (buyRoom>room) {
                                System.out.println("We only have "+ room + " each floors!!");
                            } else if (condo[buyFloor-1][buyRoom-1] != null) {
                                // todo checking, Is room have owner or not
                                System.out.println("This Room was sale to someone else!!");
                                System.out.println("Press Enter to continue...");
                                input.nextLine();
                                input.nextLine();
                                break again;
                            } else {
                                break;
                            }
                        }
                        input.nextLine();
                        System.out.print("Enter Buyer's Name: ");
                        buyer = input.nextLine();
                        condo[buyFloor-1][buyRoom-1] = buyer;
                        System.out.println("Buying completed");
                        break;
                    }
                    System.out.println("Press Enter to Continue...");
                    input.nextLine();
                    input.nextLine();
                    break;
                }
                case 2:
                {
                    int sellFloor,sellRoom;
                    System.out.println("--------------SELL CONDO BACK--------------");
                    System.out.println("Enter floor number and room number which you want to sell!!");
                    again:
                    while (true){
                        while (true){
                            System.out.print("Enter the Floor: ");
                            sellFloor= input.nextInt();
                            if(sellFloor<=0){
                                System.out.println("Floor can not be Zero(0) or Nagative number(-)!!");
                                sellFloor= input.nextInt();
                            } else if (sellFloor > floor) {
                                System.out.println("We have only "+ floor + " floors!!");
                            } else {
                                break;
                            }
                        }
                        // todo checking buying room
                        while (true){
                            System.out.print("Enter the Room: ");
                            sellRoom = input.nextInt();
                            if(sellRoom<=0){
                                System.out.println("Room can not be Zero(0) or Nagative number(-)!!");
                                sellRoom= input.nextInt();
                            } else if (sellRoom>room) {
                                System.out.println("We only have "+ room + " each floors!!");
                            } else if (condo[sellFloor-1][sellRoom-1] == null) {
                                // todo
                                System.out.println("Cannot sell the condo, cause you don't have ownership");
                                break again;
                            } else if (condo[sellFloor-1][sellRoom-1] != null) {
                                System.out.println("Select condo information: ");
                                System.out.println("Floor: "+ sellFloor +"  Room: "+ sellRoom + " Belong to: "+ condo[sellFloor-1][sellRoom-1]);
                                System.out.print("Enter 1 to conform and 0 to cancel : ");
                                int comfirm = input.nextInt();
                                if(comfirm==1){
                                    condo[sellFloor-1][sellRoom-1] = null;
                                    System.out.println("Congratulation!! you are successfully sell your condo!!");
                                }else {
                                    System.out.println("You have cancel your selection!!");
                                    break again;
                                }


                                break again;
                            } else {
                                break;
                            }
                        }
                        break;
                    }
                    System.out.println("Press Enter to Continue...");
                    input.nextLine();
                    input.nextLine();
                    break;
                }
                case 3:
                {
                    while (true){
                        System.out.println("------------Search Information--------------");
                        System.out.println("1. Search by owner's name");
                        System.out.println("2. Search by floor");
                        System.out.println("0. Exit");
                        System.out.print("Choose option: ");
                        int op= input.nextInt();
                        switch (op){
                            case 1:
                            {
                                System.out.println("------------Search by owner's name--------------");
                                input.nextLine();
                                System.out.print("Enter owner's name: ");
                                String searchName = input.nextLine();
                                for(int i=(floor-1); i>=0;i--){
                                    for(int j=0;j<room;j++){
                                        System.out.println("test");
                                        if(condo[i][j]!=null){
                                            System.out.println("Owner's name: "+ condo[i][j]+ " stay in room no: "+condo[j]+ "and floor no: "+ condo[i] );
                                        }
                                    }
                                }
                                break;
                            }
                            case 2:
                            {
                                System.out.println("------------Search by Floor--------------");
                                System.out.print("Enter Floor: ");
                                int searchFloor = input.nextInt();
                                System.out.print("=> Floor ["+(searchFloor)+"]:" );
                                for(int i=0;i<condo[floor-1].length;i++){
                                    System.out.print(condo[searchFloor-1][i]+ " ");
                                }
                                System.out.println();
                                break;
                            }
                            case 0:
                                System.exit(0);
                                System.out.println("System out!!");
                                break;
                        }
                        break;
                    }
                    System.out.print("Press Enter to Continue...");
                    input.nextLine();
                    input.nextLine();
                    break;
                }
                case 4:{
                    System.out.println("-------------Display Information--------------");
//                    System.out.println("");
                    for(int i=(floor-1);i>=0;i--){
                        System.out.print("=> Floor ["+(i+1)+"] : ");
                        for(int j=0;j<room;j++){
                            System.out.println(condo[i][j]+" ");
                        }
                        System.out.println();
                    }
                    System.out.print("Press Enter to Continue...");
                    input.nextLine();
                    input.nextLine();
                    break;
                }
                case 0:
                    System.out.println("System Out!!");
                    System.exit(0);
                default:
                {
                    System.out.println("Out of Case, our option start from 0-4!!");
                }
            }
        }
    }
}