import java.io.File;
import java.io.FileFilter;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class archivos {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public ArrayList<String> obtenerArchivos(String ruta) throws RemoteException{
        //Carpeta del usuario
        //String sCarpAct = System.getProperty("user.dir");
        String sCarpAct = ruta;
        System.out.println("Carpeta del usuario = " + sCarpAct);

        ArrayList<String> directorios  = new ArrayList<String>();
        File carpeta = new File(sCarpAct);
        String[] listado = carpeta.list();
        if (listado == null || listado.length == 0) {
            directorios.add("No hay elementos dentro de la carpeta actual");
        } else {
            for (int i = 0; i < listado.length; i++) {
                directorios.add(listado[i]);
            }
        }
        return directorios;
    }

    public static void main(String[] args) {
        //Carpeta del usuario
        //String sCarpAct = System.getProperty("user.dir");
        String sCarpAct = "C:\\Users\\rosa isela\\Desktop";
        System.out.println("Carpeta del usuario = " + sCarpAct);
        //Listemos todas las carpetas y archivos de la carpeta actual
        System.out.println(ANSI_RED + "//// LISTADO SIMPLE" + ANSI_RESET);

        File carpeta = new File(sCarpAct);
        //Lo mismo que lo anterior pero con objetos File para poder ver sus propiedades
        System.out.println(ANSI_RED + "//// LISTADO CON OBJETOS File" + ANSI_RESET);

        File[] archivos = carpeta.listFiles();
        if (archivos == null || archivos.length == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");
            return;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            for (int i = 0; i < archivos.length; i++) {
                File archivo = archivos[i];
                System.out.println(String.format("%s (%s) - %d - %s",
                        archivo.getName(),
                        archivo.isDirectory() ? "Carpeta" : "Archivo",
                        archivo.length(),
                        sdf.format(archivo.lastModified())
                ));
            }
        }
    }
}

