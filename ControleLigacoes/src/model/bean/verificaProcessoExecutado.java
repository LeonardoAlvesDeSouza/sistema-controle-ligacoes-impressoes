/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author Camara
 */
public class verificaProcessoExecutado {
    public void verificaProcesso() {
        String line;
        int instances = 0;
        try {
            Process processo = Runtime.getRuntime().exec("wmic.exe");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(processo.getInputStream()))) {
                OutputStreamWriter osw = new OutputStreamWriter(processo.getOutputStream());
                osw.write("process where name='javaw.exe'");
                osw.flush();
                osw.close();
                while ((line = br.readLine()) != null) {
                    if (line.contains("javaw.exe")) {
                        instances++;
                    }
                }
                if(instances > 1)
                {
                    System.exit(0);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }    
}
