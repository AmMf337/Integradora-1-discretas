import java.io.*;
import java.util.Scanner;
import model.*;
public class Main {
    private Scanner reader;
    HashTablePrototype<Integer,Passenger> hash;
    Controller control;
    int numberOfPassengers;
    int passengerTotal;
    Integer[] passengerkeys;
    private NodeQueue<Passenger,Integer>[] array;
    public Main() {
        reader = new Scanner(System.in);
        hash = new HashTablePrototype<>();

    }

    public static void main(String[] args) {


        Main main = new Main();

        int option = 0;

        do{

            option = main.getOptionShowMenu();
            main.executeOption(option);

        }while(option != 0);

        main.getReader().close();

    }

    public int getOptionShowMenu(){
        int option = 0;
        System.out.println(
                        "1. Upload passengers data base\n" +
                        "2. Show entry order\n" +
                        "3. show exit order\n" +
                        "0. Exit. ");
        option =  validateIntegerInput();
        return option;
    }

    public void executeOption(int option){
    
        String msj = "";
        switch(option){
            case 1:
                loadInformation();
                array = new NodeQueue[passengerTotal];
                System.out.println(passengerTotal);
                for(int i = 1;i<passengerkeys.length;i++){
                    array[i] = new NodeQueue<>(hash.getValue((Integer)passengerkeys[i-1]),hash.getValue(passengerkeys[i-1]).getPriority());
                }
                control = new Controller(array);
                System.out.println("Datos cargados");
                break;

            case 2:
                msj = control.entryOrder();
                System.out.println(msj);
                break;

            case 3:
                msj = control.exitOrder();
                System.out.println(msj);
                break;
            case 4:

                System.out.println("");
                break;
            case 5:

                System.out.println(msj);
                break;
            case 0:
                System.out.println("Exit program.");
                break;

            default:
                System.out.println("Invalid Option");
                break;
        }
    }

    public Scanner getReader(){
        return reader;
    }
    public void loadInformation(){
        int count = 0;
        File projectDir = new File(System.getProperty("user.dir"));
        File dataDirectory = new File(projectDir+"/dataBase");
        File result = new File(projectDir+"/dataBase/passengersData.txt");
        boolean firstclass = false;
        try {
            FileInputStream fis = new FileInputStream(result);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            int sizePlane = 0;
            int count2 = -3;
            while ( (line = reader.readLine()) != null){
                if(count==1){
                    sizePlane *= Integer.parseInt(line);
                }
                if(!line.contains("//") && count==0){
                    sizePlane = Integer.parseInt(line);

                }
                if(count==3){
                    numberOfPassengers = sizePlane;
                    passengerTotal = sizePlane;
                    passengerkeys = new Integer[sizePlane];

                }
                if(line.contains("//")){
                    Integer priority = 0;
                    String[] passengerData = line.split("//");
                    if(passengerData.length==6){

                        if(passengerData[2].equals("1")){
                            firstclass = true;
                            priority += 100;
                        }else{
                            firstclass = false;
                        }
                        priority += Integer.parseInt(passengerData[3])+Integer.parseInt(passengerData[5])+numberOfPassengers;
                        passengerkeys[count2] = priority;
                        Passenger a = new Passenger(passengerData[0],passengerData[1],priority,Integer.parseInt(passengerData[3]),numberOfPassengers,Integer.parseInt(passengerData[3]),passengerData[4]);
                        hash.add(priority,a);
                    }else{
                        if(passengerData[2].equals("1")){
                            firstclass = true;
                            priority += 100;
                        }else{
                            firstclass = false;
                        }
                        priority += Integer.parseInt(passengerData[3])+numberOfPassengers;
                        passengerkeys[count2] = priority;
                        Passenger a = new Passenger(passengerData[0],passengerData[1],priority,Integer.parseInt(passengerData[3]),numberOfPassengers,Integer.parseInt(passengerData[3]),"");
                        hash.add(priority,a);
                        numberOfPassengers--;
                    }
                    
                }

                count += 1;
                count2 += 1;
            }

        }catch (FileNotFoundException e){
              e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public int validateIntegerInput(){
        int option = 0;

        if(reader.hasNextInt()){
            option = reader.nextInt();
        }
        else{
            // clear reader.
            reader.nextLine();
            option = -1;
        }

        return option;
    }

    public double validateDoubleInput(){
        double option = 0;

        if(reader.hasNextDouble()){
            option = reader.nextDouble();
        }
        else{
            // clear reader.
            reader.nextLine();
            option = -1;
        }

        return option;
    }



}
