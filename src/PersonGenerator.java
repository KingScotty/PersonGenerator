import java.util.ArrayList;
import java.util.Scanner;
public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<String> folks = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        Boolean done = false;

/*
        a.	ID (a String)
        b.	FirstName
        c.	LastName
        d.	Title (a string like Mr., Mrs., Ms., Dr., etc.)
        e.	YearOfBirth (an int)
*/
        String personRec = "";
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;

        do {
ID = SafeInput.getNonZeroLenString(in, prompt: "Enter the ID [6 digits]: ");
firstName = SafeInput.getMinLenString(in, prompt: "Enter the first name [>= 2 chars]: ", minLen: 2);
lastName = SafeInput.getMinLenString(in, prompt: "Enter the last name [>= 2 chars]: ", minLen: 2);
title = SafeInput.getNonZeroLenString(in, prompt: "Enter the title [>= 2 chars]: ");
YOB = SafeInput.getRangedInt(in, prompt: "Enter the year of birth [1900-2020]: ", low: 1900, high: 2020);

personRec = ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
folks.add(personRec);




        } while(!done);

    }
    }
