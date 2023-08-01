package logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class Logger {
    static File file = new File("log.txt");
    
    public static void begin() throws IOException{

            FileWriter gfWriter = new FileWriter(file,true);
            PrintWriter gpWriter = new PrintWriter(gfWriter);
            gpWriter.println();
            gpWriter.println();
            gpWriter.println("Game at "+new Date());
            gpWriter.println("------------------------------------------------------------");
            gpWriter.println();
            gpWriter.close();
    }
    public static void logger( String content ) throws IOException {


        FileWriter fWriter = new FileWriter(file,true);
        PrintWriter pWriter = new PrintWriter(fWriter);
        pWriter.println(content);
        pWriter.close();
    }
}
