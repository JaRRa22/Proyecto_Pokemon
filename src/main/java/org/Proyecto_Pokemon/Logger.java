package org.Proyecto_Pokemon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static boolean isClosed=false;

    private static BufferedWriter bufferedWriter;
    private  static BufferedWriter buffWriter1;
    private static String logPath = "Proyecto_Pokemon\\files\\";

    public static BufferedWriter getOrCreateFileWriter() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
        String fechaFormateada = simpleDateFormat.format(new Date());
        logPath += fechaFormateada+ ".log";

        if (bufferedWriter != null)
            return bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(logPath, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bufferedWriter;
    }


    public static BufferedWriter write(String line) throws IOException {


        try {
            getOrCreateFileWriter().write(line);
        } catch (IOException e) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String fechaFormateada = simpleDateFormat.format(new Date());
            logPath += fechaFormateada+ ".log";
            BufferedWriter buffWriter1=new BufferedWriter(new FileWriter(logPath,true));
            return buffWriter1;
        }
        return getOrCreateFileWriter();
    }

    public static void close() throws IOException {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            buffWriter1.close();
        }
    }

    public static boolean isIsClosed() {
        return isClosed;
    }

    public static void setIsClosed(boolean isClosed) {
        Logger.isClosed = isClosed;
    }
/*    public static BufferedWriter getOrCreateFileWriterCombate() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
        String fechaFormateada = simpleDateFormat.format(new Date());
        logPath += "combate" +fechaFormateada+ ".log";

        if (bufferedWriter != null)
            return bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(logPath, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bufferedWriter;
    }*/

}