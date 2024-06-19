package es.ufv.dis.final2024.yls;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class LeerFicheroJSON {
    public static ArrayList<Ships> LeerFicheroShips() throws IOException {
        InputStream inputStream = LeerFicheroJSON.class.getClassLoader().getResourceAsStream("data.json");
        // Copia el archivo JSON a un File
        File ships = new File("data.json");
        FileUtils.copyInputStreamToFile(inputStream, ships);


        // Verifica si el archivo existe
        if (!ships.exists()) {
            throw new IOException("El archivo peticiones/data.json no se encuentra.");
        }

        // Inicializa Gson
        Gson gson = new Gson();

        // Lee el JSON desde el archivo y lo convierte a un ArrayList de Productos
        JsonReader reader = new JsonReader(new FileReader(ships));
        Type NavesListType = new TypeToken<ArrayList<Ships>>() {}.getType();
        ArrayList<Ships> naves = gson.fromJson(reader, NavesListType);

        return naves;
    }
}
