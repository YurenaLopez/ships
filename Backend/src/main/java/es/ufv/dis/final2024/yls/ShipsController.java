package es.ufv.dis.final2024.yls;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import es.ufv.dis.final2022.yls.LeerFicheroJSON;
import es.ufv.dis.final2022.yls.PDFManager;

@RestController
public class ShipsController {

    // Métodos GET para leer datos de la API
    @GetMapping("/ships")
    public ArrayList<Ships> ships() throws IOException {

        return es.ufv.dis.final2022.yls.LeerFicheroJSON.LeerFicheroShips();
    }

    @PostMapping("/ships")
    public ArrayList<Ships> createShips(@RequestBody Ships nuevoDato) throws IOException {
        ArrayList<Ships> datos = LeerFicheroJSON.LeerFicheroShips();

        // Añadimos los datos nuevos al fichero existente
        datos.add(nuevoDato);

        // Convertimos la lista actualizada a JSON manteniendo el formato
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(datos);
        File file = new File("peticiones/data.json");

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(json); // Escribir el JSON actualizado
        fileWriter.flush();
        fileWriter.close();

        PDFManager.GenerarPDF(nuevoDato,nuevoDato.getName());

        return datos;
    }
}
