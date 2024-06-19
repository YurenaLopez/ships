package es.ufv.dis.final2022.yls;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import es.ufv.dis.final2024.yls.Ships;
import es.ufv.dis.final2024.yls.ShipsApplication;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class LeerFicheroJSON {
    public static ArrayList<Ships> LeerFicheroShips() throws IOException {
        // Ruta relativa desde el directorio de trabajo actual (Backend)
        File ships = new File("peticiones/data.json");
        System.out.println("Ruta absoluta del archivo: " + ships.getAbsolutePath());

        // Imprime la ruta absoluta del archivo para verificar
        System.out.println("Ruta absoluta del archivo: " + ships.getAbsolutePath());

        // Verifica si el archivo existe
        if (!ships.exists()) {
            throw new IOException("El archivo ../peticiones/data.json no se encuentra.");
        }

        // Inicializa Gson
        Gson gson = new Gson();

        // Lee el JSON desde el archivo y lo convierte a un ArrayList de Ships
        JsonReader reader = new JsonReader(new FileReader(ships));
        Type NavesListType = new TypeToken<ArrayList<Ships>>() {}.getType();
        ArrayList<Ships> naves = gson.fromJson(reader, NavesListType);

        return naves;
    }
}
