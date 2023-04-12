
package View;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.DatabaseTable;

public class Projectcalc {
    public  Projectcalc()
    {
        while(true)
        {
            Scanner input = new Scanner(System.in);

        // Prompt user for client name, project name, and number of materials
        System.out.println("Enter exit to terminate: "  );
        System.out.print("Enter client name: "  );
        String clientName = input.nextLine();

        if (clientName.toLowerCase().equals("exit"))
        {
            break;
        }

        System.out.print("Enter project name: ");
        String projectName = input.nextLine();

        System.out.print("Enter number of materials required: ");
        int numMaterials = input.nextInt();

        // Calculate project cost based on a fixed cost per material
        double materialCost = 12000.0; // cost per material in dollars
        double projectCost = numMaterials * materialCost;
        DatabaseTable db = new DatabaseTable();
        db.getC();

        boolean namein = false;
        boolean projectin = false;

        for(String name: db.names)
        {
           
            if (clientName.toLowerCase().equals(name.toLowerCase()))
            {
                namein = true;
                break;
            }
        }

        for(String name: db.project)
        {
         
             if (projectName.toLowerCase().equals(name.toLowerCase()))
            {
                projectin = true;
                break;
            }
        }

        if(namein && projectin)
        {
            System.out.println("Project cost for " + clientName + "'s " + projectName + " project: $" + projectCost);

                    try {
                            FileWriter myWriter = new FileWriter("Quotation.txt");
                            myWriter.write("Project cost for " + clientName + "'s " + projectName + " project: $" + projectCost);
                            myWriter.close();
                            System.out.println("Successfully wrote to the file.");
                            } catch (IOException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                            }
                }

        

        // Display project cost

    else 
    {
        System.out.println("Client/Project name not in databae");
    }

        
    }
        }

        
}
