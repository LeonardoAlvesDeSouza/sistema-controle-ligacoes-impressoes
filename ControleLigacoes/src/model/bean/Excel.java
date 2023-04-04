/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


 
/**
 *
 * @author Camara
 */
public class Excel {
    private String titulo;
    private String qualRelatorio;
    private String dataHora;
    private int totalDeIds;
    private String[] nome;
    private String[] cpf;
    private String[] cidade;
    private String[] estado;
    private String[] telefone;
    private int[] quatdade;
    private int quatdadeTotal;
    private int tamanhoArray;

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getQualRelatorio() {
        return qualRelatorio;
    }

    public void setQualRelatorio(String qualRelatorio) {
        this.qualRelatorio = qualRelatorio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalDeIds() {
        return totalDeIds;
    }

    public void setTotalDeIds(int totalDeIds) {
        this.totalDeIds = totalDeIds;
    }

    public String[] getNome() {
        return nome;
    }

    public void setNome(String[] nome) {
        this.nome = nome;
    }

    public String[] getCpf() {
        return cpf;
    }

    public void setCpf(String[] cpf) {
        this.cpf = cpf;
    }

    public String[] getCidade() {
        return cidade;
    }

    public void setCidade(String[] cidade) {
        this.cidade = cidade;
    }

    public String[] getEstado() {
        return estado;
    }

    public void setEstado(String[] estado) {
        this.estado = estado;
    }

    public String[] getTelefone() {
        return telefone;
    }

    public void setTelefone(String[] telefone) {
        this.telefone = telefone;
    }

    public int[] getQuatdade() {
        return quatdade;
    }

    public void setQuatdade(int[] quatdade) {
        this.quatdade = quatdade;
    }

    public int getQuatdadeTotal() {
        return quatdadeTotal;
    }

    public void setQuatdadeTotal(int quatdadeTotal) {
        this.quatdadeTotal = quatdadeTotal;
    }

    public int getTamanhoArray() {
        return tamanhoArray;
    }

    public void setTamanhoArray(int tamanhoArray) {
        this.tamanhoArray = tamanhoArray;
    }

    
    public void CriaRelatorioImpreMensal() throws FileNotFoundException, IOException {
 
        // Criando o arquivo fisico
        FileOutputStream out = new FileOutputStream("Relatorios/" + qualRelatorio + dataHora + ".xls");
 
        // Criando area de trabalho para o excel
        Workbook wb = new HSSFWorkbook();
 
        // criando uma nova sheet
        Sheet s = wb.createSheet(titulo);
 
        // Criando uma referencia para Linha
        Row r1 = null;
        Row r2 = null;
        Row[] r3 = new Row[getTamanhoArray() + 3];
 
        // Referencia para Celula
        Cell titulo = null;
        Cell nome = null;
        Cell cpf = null;
        Cell cidade = null;
        Cell estado = null;
        Cell qutdade = null;
        Cell qutdadeTotal = null;
        Cell textoValor = null;
        
        Cell[] valorNome = new Cell[getTamanhoArray()];
        Cell[] valorCpf = new Cell[getTamanhoArray()];
        Cell[] valorCidade = new Cell[getTamanhoArray()];
        Cell[] valorEstado = new Cell[getTamanhoArray()];
        Cell[] valorQutdade = new Cell[getTamanhoArray()];
        
 
        // Criando a primeira linha na LINHA zero, que seria o número 1
        r1 = s.createRow(0);
        r2 = s.createRow(2);
        for(int i = 0; i < getTamanhoArray(); i++)
        {
            r3[i] = s.createRow(i + 3);
            
            valorNome[i] = r3[i].createCell(0);
            valorCpf[i] = r3[i].createCell(1);
            valorCidade[i] = r3[i].createCell(2);
            valorEstado[i] = r3[i].createCell(3);
            valorQutdade[i] = r3[i].createCell(4);
           
            valorNome[i].setCellValue(getNome()[i]);
            valorCpf[i].setCellValue(getCpf()[i]);
            valorCidade[i].setCellValue(getCidade()[i]);
            valorEstado[i].setCellValue(getEstado()[i]);
            valorQutdade[i].setCellValue(getQuatdade()[i]);
        }
       
        
 
        // Criando a celula na posicao ZERO, que seria A, com referencia na
        // linha ZERO criado acima ou seja, colocaremos
        // informacao na A1
        titulo = r1.createCell(0);
        nome = r2.createCell(0);
        cpf = r2.createCell(1);
        cidade = r2.createCell(2);
        estado = r2.createCell(3);
        qutdade = r2.createCell(4);
        qutdadeTotal = r1.createCell(7);
        textoValor = r1.createCell(4);
 
        // Colocando um valor
        titulo.setCellValue("Relatório de Impressões Mensal");
        nome.setCellValue("Nome");
        cpf.setCellValue("CPF");
        cidade.setCellValue("Cidade");
        estado.setCellValue("Estado");
        qutdade.setCellValue("Quantidade de Impressões");
        
        
        textoValor.setCellValue("TOTAL de Impressões: ");
        qutdadeTotal.setCellValue(getQuatdadeTotal());
 
        // Pegando valor da celula por referencia, para ler um arquivo inteiro
        // precisa fazer um for
        //CellReference cellReference = new CellReference("A1");
        //Row row = s.getRow(cellReference.getRow());
        //Cell cell = row.getCell(cellReference.getCol());
        //System.out.println(cell.getStringCellValue());
 
        /* Se quiser ler a planilha toda
        for (Row rowFor : s) {
            for (Cell cellFor : rowFor) {
                System.out.print(cellFor.getStringCellValue());
 
            }
        }*/
         
        // Salvando o arquivo
        wb.write(out);
        out.close();
 
    }
    
    public void CriaRelatorioLigaMensal() throws FileNotFoundException, IOException {
 
        // Criando o arquivo fisico
        FileOutputStream out = new FileOutputStream("Relatorios/" + qualRelatorio + dataHora + ".xls");
 
        // Criando area de trabalho para o excel
        Workbook wb = new HSSFWorkbook();
 
        // criando uma nova sheet
        Sheet s = wb.createSheet(titulo);
 
        // Criando uma referencia para Linha
        Row r1 = null;
        Row r2 = null;
        Row[] r3 = new Row[getTamanhoArray() + 3];
 
        // Referencia para Celula
        Cell titulo = null;
        Cell nome = null;
        Cell cpf = null;
        Cell cidade = null;
        Cell estado = null;
        Cell qutdade = null;
        Cell qutdadeTotal = null;
        Cell textoValor = null;
        
        Cell[] valorNome = new Cell[getTamanhoArray()];
        Cell[] valorCpf = new Cell[getTamanhoArray()];
        Cell[] valorCidade = new Cell[getTamanhoArray()];
        Cell[] valorEstado = new Cell[getTamanhoArray()];
        Cell[] valorQutdade = new Cell[getTamanhoArray()];
 
        // Criando a primeira linha na LINHA zero, que seria o número 1
        r1 = s.createRow(0);
        r2 = s.createRow(2);
        for(int i = 0; i < getTamanhoArray(); i++)
        {
            r3[i] = s.createRow(i + 3);
            
            valorNome[i] = r3[i].createCell(0);
            valorCpf[i] = r3[i].createCell(1);
            valorCidade[i] = r3[i].createCell(2);
            valorEstado[i] = r3[i].createCell(3);
            valorQutdade[i] = r3[i].createCell(4);
            
            valorNome[i].setCellValue(getNome()[i]);
            valorCpf[i].setCellValue(getCpf()[i]);
            valorCidade[i].setCellValue(getCidade()[i]);
            valorEstado[i].setCellValue(getEstado()[i]);
            valorQutdade[i].setCellValue(getQuatdade()[i]);
        }
       
        
 
        // Criando a celula na posicao ZERO, que seria A, com referencia na
        // linha ZERO criado acima ou seja, colocaremos
        // informacao na A1
        titulo = r1.createCell(0);
        nome = r2.createCell(0);
        cpf = r2.createCell(1);
        cidade = r2.createCell(2);
        estado = r2.createCell(3);
        qutdade = r2.createCell(4);
        qutdadeTotal = r1.createCell(7);
        textoValor = r1.createCell(4);
 
        // Colocando um valor
        titulo.setCellValue("Relatório de Ligações Mensal");
        nome.setCellValue("Nome");
        cpf.setCellValue("CPF");
        cidade.setCellValue("Cidade");
        estado.setCellValue("Estado");
        qutdade.setCellValue("Quantidade de Ligações");
        
        textoValor.setCellValue("TOTAL de Ligações: ");
        qutdadeTotal.setCellValue(getQuatdadeTotal());
 
        // Pegando valor da celula por referencia, para ler um arquivo inteiro
        // precisa fazer um for
        //CellReference cellReference = new CellReference("A1");
        //Row row = s.getRow(cellReference.getRow());
        //Cell cell = row.getCell(cellReference.getCol());
        //System.out.println(cell.getStringCellValue());
 
        /* Se quiser ler a planilha toda
        for (Row rowFor : s) {
            for (Cell cellFor : rowFor) {
                System.out.print(cellFor.getStringCellValue());
 
            }
        }*/
         
        // Salvando o arquivo
        wb.write(out);
        out.close();
 
    }
    
        public void CriaRelatorioImpreTotal() throws FileNotFoundException, IOException {
 
        // Criando o arquivo fisico
        FileOutputStream out = new FileOutputStream("Relatorios/" + qualRelatorio + dataHora + ".xls");
 
        // Criando area de trabalho para o excel
        Workbook wb = new HSSFWorkbook();
 
        // criando uma nova sheet
        Sheet s = wb.createSheet(titulo);
 
        // Criando uma referencia para Linha
        Row r1 = null;
        Row r2 = null;
        Row[] r3 = new Row[getTamanhoArray() + 3];
 
        // Referencia para Celula
        Cell titulo = null;
        Cell nome = null;
        Cell cpf = null;
        Cell cidade = null;
        Cell estado = null;
        Cell qutdade = null;
        Cell qutdadeTotal = null;
        Cell textoValor = null;
        
        Cell[] valorNome = new Cell[getTamanhoArray()];
        Cell[] valorCpf = new Cell[getTamanhoArray()];
        Cell[] valorCidade = new Cell[getTamanhoArray()];
        Cell[] valorEstado = new Cell[getTamanhoArray()];
        Cell[] valorQutdade = new Cell[getTamanhoArray()];
        
 
        // Criando a primeira linha na LINHA zero, que seria o número 1
        r1 = s.createRow(0);
        r2 = s.createRow(2);
        for(int i = 0; i < getTamanhoArray(); i++)
        {
            r3[i] = s.createRow(i + 3);
            
            valorNome[i] = r3[i].createCell(0);
            valorCpf[i] = r3[i].createCell(1);
            valorCidade[i] = r3[i].createCell(2);
            valorEstado[i] = r3[i].createCell(3);
            valorQutdade[i] = r3[i].createCell(4);
           
            valorNome[i].setCellValue(getNome()[i]);
            valorCpf[i].setCellValue(getCpf()[i]);
            valorCidade[i].setCellValue(getCidade()[i]);
            valorEstado[i].setCellValue(getEstado()[i]);
            valorQutdade[i].setCellValue(getQuatdade()[i]);
        }
       
        
 
        // Criando a celula na posicao ZERO, que seria A, com referencia na
        // linha ZERO criado acima ou seja, colocaremos
        // informacao na A1
        titulo = r1.createCell(0);
        nome = r2.createCell(0);
        cpf = r2.createCell(1);
        cidade = r2.createCell(2);
        estado = r2.createCell(3);
        qutdade = r2.createCell(4);
        qutdadeTotal = r1.createCell(7);
        textoValor = r1.createCell(4);
 
        // Colocando um valor
        titulo.setCellValue("Relatório de Impressões Total");
        nome.setCellValue("Nome");
        cpf.setCellValue("CPF");
        cidade.setCellValue("Cidade");
        estado.setCellValue("Estado");
        qutdade.setCellValue("Quantidade de Impressões");
        
        
        textoValor.setCellValue("TOTAL de Impressões: ");
        qutdadeTotal.setCellValue(getQuatdadeTotal());
 
        // Pegando valor da celula por referencia, para ler um arquivo inteiro
        // precisa fazer um for
        //CellReference cellReference = new CellReference("A1");
        //Row row = s.getRow(cellReference.getRow());
        //Cell cell = row.getCell(cellReference.getCol());
        //System.out.println(cell.getStringCellValue());
 
        /* Se quiser ler a planilha toda
        for (Row rowFor : s) {
            for (Cell cellFor : rowFor) {
                System.out.print(cellFor.getStringCellValue());
 
            }
        }*/
         
        // Salvando o arquivo
        wb.write(out);
        out.close();
 
    }
        
        public void CriaRelatorioLigaTotal() throws FileNotFoundException, IOException {
 
        // Criando o arquivo fisico
        FileOutputStream out = new FileOutputStream("Relatorios/" + qualRelatorio + dataHora + ".xls");
 
        // Criando area de trabalho para o excel
        Workbook wb = new HSSFWorkbook();
 
        // criando uma nova sheet
        Sheet s = wb.createSheet(titulo);
 
        // Criando uma referencia para Linha
        Row r1 = null;
        Row r2 = null;
        Row[] r3 = new Row[getTamanhoArray() + 3];
 
        // Referencia para Celula
        Cell titulo = null;
        Cell nome = null;
        Cell cpf = null;
        Cell cidade = null;
        Cell estado = null;
        Cell qutdade = null;
        Cell qutdadeTotal = null;
        Cell textoValor = null;
        
        Cell[] valorNome = new Cell[getTamanhoArray()];
        Cell[] valorCpf = new Cell[getTamanhoArray()];
        Cell[] valorCidade = new Cell[getTamanhoArray()];
        Cell[] valorEstado = new Cell[getTamanhoArray()];
        Cell[] valorQutdade = new Cell[getTamanhoArray()];
 
        // Criando a primeira linha na LINHA zero, que seria o número 1
        r1 = s.createRow(0);
        r2 = s.createRow(2);
        for(int i = 0; i < getTamanhoArray(); i++)
        {
            r3[i] = s.createRow(i + 3);
            
            valorNome[i] = r3[i].createCell(0);
            valorCpf[i] = r3[i].createCell(1);
            valorCidade[i] = r3[i].createCell(2);
            valorEstado[i] = r3[i].createCell(3);
            valorQutdade[i] = r3[i].createCell(4);
            
            valorNome[i].setCellValue(getNome()[i]);
            valorCpf[i].setCellValue(getCpf()[i]);
            valorCidade[i].setCellValue(getCidade()[i]);
            valorEstado[i].setCellValue(getEstado()[i]);
            valorQutdade[i].setCellValue(getQuatdade()[i]);
        }
       
        
 
        // Criando a celula na posicao ZERO, que seria A, com referencia na
        // linha ZERO criado acima ou seja, colocaremos
        // informacao na A1
        titulo = r1.createCell(0);
        nome = r2.createCell(0);
        cpf = r2.createCell(1);
        cidade = r2.createCell(2);
        estado = r2.createCell(3);
        qutdade = r2.createCell(4);
        qutdadeTotal = r1.createCell(7);
        textoValor = r1.createCell(4);
 
        // Colocando um valor
        titulo.setCellValue("Relatório de Ligações Total");
        nome.setCellValue("Nome");
        cpf.setCellValue("CPF");
        cidade.setCellValue("Cidade");
        estado.setCellValue("Estado");
        qutdade.setCellValue("Quantidade de Ligações");
        
        textoValor.setCellValue("TOTAL de Ligações: ");
        qutdadeTotal.setCellValue(getQuatdadeTotal());
 
        // Pegando valor da celula por referencia, para ler um arquivo inteiro
        // precisa fazer um for
        //CellReference cellReference = new CellReference("A1");
        //Row row = s.getRow(cellReference.getRow());
        //Cell cell = row.getCell(cellReference.getCol());
        //System.out.println(cell.getStringCellValue());
 
        /* Se quiser ler a planilha toda
        for (Row rowFor : s) {
            for (Cell cellFor : rowFor) {
                System.out.print(cellFor.getStringCellValue());
 
            }
        }*/
         
        // Salvando o arquivo
        wb.write(out);
        out.close();
 
    }
}
