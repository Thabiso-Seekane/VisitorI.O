import org.apache.logging.log4j.LogManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import  java.time.*;

import org.apache.logging.log4j.Logger;

public class Visitor {

    Logger VisitorLog = LogManager.getLogger(Visitor.class);

    public String name;
    public int age;
    public String date;
    public String time;
    public String comment;
    public String assist;

    public void save()

    {
        StringBuilder builder = new StringBuilder();

        builder.append("full names: "+name + "\n")
                .append(" ")
                .append("Age: "+age+"\n")
                .append(" ")
                .append("Date: "+date+"\n")
                .append(" ")
                .append("Time: "+time+"\n")
                .append(" ")
                .append("Assisted by:"+assist+" ");

        String full_Name = name.replace(" ", "_");
        String fileName = "visitor_"+full_Name+".txt";

        int ar[] = new int[3];
        File file = null;
        try {
            file = new File(fileName);
            if(file.createNewFile()) {
                Files.write(Paths.get(fileName),String.valueOf(builder).getBytes());
            }
            else
                throw new IOException("File already exist");
        } catch (IOException e) {
            e.printStackTrace();
            VisitorLog.info(e);
            System.out.println("Done!");
        }
    }
}