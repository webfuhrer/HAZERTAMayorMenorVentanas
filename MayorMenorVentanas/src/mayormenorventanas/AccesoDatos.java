/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayormenorventanas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
class AccesoDatos {
static String ruta_ranking="D:\\ranking.csv";
static String separador=",";
    static boolean grabarRanking(Ranking r) {
        String aux=r.getNombre()+separador+r.getNumero_intentos()+"\n";
    try {
        FileWriter escritor=new FileWriter(ruta_ranking, true);
        escritor.write(aux);
        escritor.close();
        return true;
        
    } catch (IOException ex) {
        Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
        
    }

    static ArrayList<Ranking> recuperarRanking() {
        ArrayList<Ranking> lista_ranking=new ArrayList<>();
    try {
        FileReader fr=new FileReader(ruta_ranking);
        BufferedReader br=new BufferedReader(fr);
        String linea=br.readLine();
        while(linea!=null)
        { //pepe,4
            
            String[] datos=linea.split(separador);
            String nombre_usuario=datos[0];
            String intentos_string=datos[1];
            
            int intentos_numerico=Integer.parseInt(intentos_string);
            Ranking r=new Ranking(nombre_usuario, intentos_numerico);
            lista_ranking.add(r);
            linea=br.readLine();
        }
    } catch (IOException ex) {
        Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        
    
    }
    return lista_ranking;
    }
    
}
