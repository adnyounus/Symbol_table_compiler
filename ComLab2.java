/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comlab2;
import java.util.*;

/**
 *
 * @author Flying Dutchman
 */
public class ComLab2 {
    
   public static HashMap<String, String> table = new HashMap<>(); 
    public static int row=1;
    
    static void insert_method(){
        
        System.out.println("Please enter your data");
        Scanner input = new Scanner(System.in);
        String input_str = input.nextLine();
        int full_length = input_str.length();
        char[] input_char =  input_str.toCharArray();
        
        String type,name,value;
        int comma=0;
        int equal=0;
        
        if( input_char[full_length-1] != ';' ){
            System.out.println("Please put a semicolon at the end and try again!!!");
        }
        
        else{
            
            try{
                int signal=0;
                for(int i =0 ; i<full_length ; i++){
                   if ( input_char[i] == ' ' ){

                      signal =1;

                   }

                }

                if( signal!=1){

                    System.out.println("Invalid datatype...make sure you put a space after datatype declaration!! ");

                }

                else{
                     String[] splits1 = input_str.split(" ", 2);
                     if(splits1[0].equals("int")||splits1[0].equals("float")){

                         type = splits1[0];
                         for(int i=0;i<splits1[1].length();i++){
                             if(splits1[1].charAt(i)==44){          //ascii of ',' is 44
                                comma++;
                             }
                         }

                         if(comma==0){
                            for(int i=0;i<splits1[1].length();i++){
                                if(splits1[1].charAt(i)==61){    //ascii of '=' is 61
                                  equal++;
                                }

                            }
                            if(equal==0){
                              String[] splits2=splits1[1].split(";");
                              name=splits2[0];
                              value= "null";
    //                          
                                int toggle=0;
                                for (String i : table.keySet()) {
                                    if( name.equals(i) )
                                        toggle=1;
                                  }
                                if( toggle ==0 ){
                                    String typ_val= type+" "+value; 


                                    table.put(name, typ_val);
                                    System.out.println("Successfully added 1 item!!");
                                }
                                else
                                    System.out.printf("1 The name %s already exists!! try another name...\n",name);
                            }
                            else{
                              String[] splits3=splits1[1].split(";");
                              String[] splits4=splits3[0].split("=");
                              name=splits4[0];
                              value=splits4[1];

                              int toggle1=0;
                                for (String i : table.keySet()) {
                                    if( name.equals(i) )
                                        toggle1=1;
                                  }
                                if( toggle1 ==0 ){
                                    String typ_val= type+" "+value; 


                                    table.put(name, typ_val);
                                    System.out.println("Successfully added 1 item!!");

                                }
                                else
                                    System.out.printf("2 The name %s already exists!! try another name...\n",name);
                            }
                         }

                         else{
                            equal=0; 
                            String[] splits5=splits1[1].split(";");
                            String[] splits6=splits5[0].split(",");
                            for(int i=0;i<comma+1;i++){
                                for(int j=0;j<splits6[i].length();j++){
                                   if(splits6[i].charAt(j)==61){
                                      equal++;

                                    }

                                }
                                if(equal==0){
                                    name=splits6[i];
                                    value= "null";

                                    int toggle2=0;
                                    for (String l : table.keySet()) {
                                        if( name.equals(l) )
                                            toggle2=1;
                                      }
                                    if( toggle2 ==0 ){
                                        String typ_val= type+" "+value; 


                                        table.put(name, typ_val);
                                        System.out.println("Successfully added 1 item!!");
                                    }
                                    else
                                        System.out.printf("3 The name %s already exists!! try another name...\n",name);

                                }
                                else{
                                    String[] splits7=splits6[i].split("=");
                                    name=splits7[0];
                                    value=splits7[1];

                                    int toggle3=0;
                                    for (String l : table.keySet()) {
                                        if( name.equals(l) )
                                            toggle3=1;
                                      }
                                    if( toggle3 ==0 ){
                                        String typ_val= type+" "+value; 


                                        table.put(name, typ_val);
                                        System.out.println("Successfully added 1 item!!");
                                    }
                                    else
                                        System.out.printf("4 The name %s already exists!! try another name...\n",name);
                            }

                         }

                     }

                }
                     else
                         System.out.println("Invalid datatype!!");




                }



            }
            catch(Exception e){
                System.out.println("Not valid");
            }
            
          // System.out.println("Successfully added!!"); 
        
        }
    
    
    
    
    
    
    }
    
    static void remove_method(){
        
        
         if( table.size() ==0 ){
            System.out.println("The table is empty!!");
  
        }
         else{
            System.out.println("Enter the name of the variable that you want to remove:");
            Scanner input = new Scanner(System.in);
            String rem_name = input.nextLine();


            if( table.containsKey(rem_name) ){

                table.remove(rem_name);
                     System.out.println("successfully removed!!");

            }
            else
                System.out.printf("Name %s is not in the table!!\n",rem_name);
        
         }
    
    
    
    
    
    }
    
    static void update_method(){
        
        if( table.size() ==0 ){
            System.out.println("The table is empty!!");
  
        }
        
        else{
            System.out.println("Enter the name of the variable that you want to update:");
            Scanner input = new Scanner(System.in);
            String rem_name = input.nextLine();
            
            if (table.containsKey(rem_name)){
            
                System.out.println("Enter the new Type of the variable :");
                String rem_type = input.nextLine();

                System.out.println("Enter the new Value of the variable :");
                String rem_value = input.nextLine();

                if(rem_type.equals("int")||rem_type.equals("float")){

                    String new_name= rem_type+" "+rem_value;

                    table.replace(rem_name, new_name);
                        System.out.println("Successfully updated!!!");

                }
                else
                    System.out.println("Invalid datatype!!");
            
            }
            
            else
                System.out.printf("Name %s is not in the table!!\n",rem_name);
        
        
        
        }
    
    
    
    
    }
    
    static void display_method(){
        
        if( table.size() ==0 ){
            System.out.println("The table is empty!!");
  
        }
        else{
            
            System.out.println("Serial     |Name     |Type     |Value");
            int srl=1;
            String ty_val;
            for (String i : table.keySet()) {
                
                ty_val = table.get(i);
                String[] split_ty_val=ty_val.split(" ");
                    System.out.println(srl+"          |"+i+"       |"+split_ty_val[0]+"      |"+split_ty_val[1]);
                    srl++;
            }
        
        
        
        }
    
    
    
    
    }

   
    public static void main(String[] args) {
        // TODO code application logic here
        
        int choice;
        for(;;){
            
            System.out.println("Select 1 to Insert Data");
            System.out.println("Select 2 to Remove Data");
            System.out.println("Select 3 to Update Data");
            System.out.println("Select 4 to Display");
            System.out.println("Select 5 to Exit");
           
            System.out.print("Enter your choice: ");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            
            if(choice==1){
                insert_method();
            
            }
            else if (choice==2){
                remove_method();
          
            }
            else if (choice==3){
                update_method();
          
            }
            else if (choice==4){
                display_method();
          
            }

            else if (choice==5){
                break;
          
            }
            else
                System.out.println("Wrong choice!! Please choose between 1 to 5");
        
        
        
        }
    }
    
}
