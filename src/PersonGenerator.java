import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<String> folks = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\personData.txt");

        Boolean done = false;

        String personRec = "";
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]: ");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the first name:");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the last name: ");
            title = SafeInput.getNonZeroLenString(in, "Enter the title ");
            YOB = SafeInput.getRangedInt(in, "Enter the year of birth [1900-2020]: ", 1900, 2020);

            personRec = ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
            folks.add(personRec);

            done = SafeInput.getYNConfirm(in, "Another person (y/n)? ");


        } while (!done);
        for (String person : folks) {
            System.out.println(person);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile())))
        {

            // Finally can write the file LOL!

            for(String rec : folks)
            {
                writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
000001, Bilbo, Baggins, Esq., 1060
        000002, Frodo, Baggins, Esq., 1120
        000003, Samwise, Gamgee, Esq., 1125
        000004, Peregrin, Took, Esq., 1126
        000005, Meridoc, Brandybuck, Esq., 1126
