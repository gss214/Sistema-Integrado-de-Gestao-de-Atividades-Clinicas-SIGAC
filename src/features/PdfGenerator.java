package features;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import marcarconsulta.Consulta;
import pessoas.Medico;
import pessoas.Paciente;

public class PdfGenerator {
    
    public static void gerarPdf(String texto, Paciente paciente, Medico medico, String dataHorario){
        //arrumando o horario
        StringBuilder s = new StringBuilder(dataHorario);
        s.setCharAt(2, '_');
        s.setCharAt(5, '_');
        s.setCharAt(10, 'E');
        s.setCharAt(13, '_');
        
        //nome do arquivo que vai ser gerado, com o nome do paciente e o horario da consulta
        String FILE = "src//db//receitas\\" + paciente.getNome() + s.toString() + ".pdf";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            
            //método para adicionar paragrafo no PDF
            Paragraph paragraph = new Paragraph("SIGAC - GERADOR DE RECEITAS");
            //seta o alinhamento do paragrafo
            paragraph.setAlignment(Element.ALIGN_CENTER);
            //escreve o paragrafo no documento
            document.add(paragraph);
       
            paragraph = new Paragraph("Dados do paciente:\n\nNome: " + paciente.getNome() + "\nConvênio: " + paciente.getConvenio());
            paragraph.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph);
            
            paragraph = new Paragraph("\nReceita: " + texto);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph);
            
            paragraph = new Paragraph("\nReceitado por\n" + medico.getNome() + "\nCRM: " + medico.getInscricaoCRM());
            paragraph.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph);
            
            paragraph = new Paragraph("SIGAC - Sistema Integrado de Gestão de Atividades Clínicas");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            document.close();
            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}