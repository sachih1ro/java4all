//Example: module for manage students and their grades
//
//by @sachi_h1ro (Elias Camilo Cabarcas Carreño)
//

//imports
import java.util.*;

public class StudentManagementSystem {

    //Function for show commad list on screen
    public static void showCommands(){
        System.out.println("---------------------------------------------------");
        System.out.println("Select an option and type the corresponding command");
        System.out.println("Format: 1&name&grade");
        System.out.println("1. Add student and his/her grade.");
        System.out.println("2. Return the actual grade average.");
        System.out.println("3. Order students by name.");
        System.out.println("4. Check a student's grade.");
        System.out.println("Format: 4&name");
        System.out.println("5. View student list.");
        System.out.println("6. Finish.");
        System.out.println(" ");
        System.out.print("Type the command: ");
    }

    public static boolean isValidEntry(String entry){
        String[] command = entry.split("&");

        String[] othersCommands = new String[]{"2", "3", "5", "6"};

        if(command[0].equals("1")){
            return command.length == 3;

        }else if(command[0].equals("4")){
            return command.length == 2;

        }else if(Arrays.asList(othersCommands).contains(command[0])){
            return command.length == 1;

        }else{
            return false;
        }

    }

    public static void executeSMS(){

        //Scanner init
        Scanner sc = new Scanner(System.in);

        //Student names and grades list init
        ArrayList<String> studentsNames = new ArrayList<>();
        ArrayList<Double> studentsGrades = new ArrayList<>();

        //Boolean flag init
        boolean isWorking = true;

        //Cicle
        while(isWorking){

            showCommands();
            String entry = sc.nextLine();
            System.out.println("---------------------------------------------------");

            //Check if the input is valid
            boolean isValidEntry = isValidEntry(entry);
            String option;
            String[] command = entry.split("&");


            if (isValidEntry){
                option = command[0];
            }else{ //Not valid command case
                option = "7";
            }

            switch (option){

                case("1"): //Add student and grade
                    String name = command[1];
                    Double grade = Double.parseDouble(command[2]);
                    studentsNames.add(name);
                    studentsGrades.add(grade);
                    System.out.println("Added");
                    System.out.println("name: " + name + "   -   grade: " + grade);
                    break;

                case("2"): //Return the actual average
                    if (studentsGrades.size() < 1){
                        System.out.println("There are no students on the list");
                    }else{
                        double average = (studentsGrades.stream().mapToDouble(a -> a).sum())
                                / studentsGrades.size();
                        System.out.println("The actual grade average is " + average);
                    }
                    break;

                case("3"): //Order by name
                    studentsGrades.sort(Comparator.comparing(s ->
                            studentsNames.get(studentsGrades.indexOf(s))));
                    Collections.sort(studentsNames);
                    break;

                case("4"): //Print list
                    String sname = command[1];
                    if (studentsNames.contains(sname)){
                        double sgrade = studentsGrades.get(studentsNames.indexOf(sname));
                        System.out.println("name: " + sname + "   -   grade: " + sgrade);
                    }else{
                        System.out.println("Non-existent student record");
                    }
                    break;

                case("5"): //View student list
                    for(int i =  0; i < studentsNames.size(); i++){
                        System.out.println(studentsNames.get(i) + "   -   " + studentsGrades.get(i));
                    }
                    break;

                case("6"): //Finish
                    System.out.println("Program finished, goodbye.");
                    isWorking = false;
                    break;

                default: //Not valid command case
                    System.out.println("Insert a valid command.");
                    break;
            }
        }
    }


    public static void main(String[] args) {
        executeSMS();
    }

}
