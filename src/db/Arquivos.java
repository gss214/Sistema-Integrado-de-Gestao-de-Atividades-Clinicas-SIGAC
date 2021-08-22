/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import marcarconsulta.*;
import pessoas.*;

/**
 *
 * @author enzoy
 */
public class Arquivos {
    // atributos de arquivo do paciente
    private File arquivoPaciente;
    private FileWriter escrevePaciente;
    private BufferedWriter escreveBufferPaciente;
    private FileReader lerPaciente;
    private BufferedReader lerBufferPaciente;
    // atributos de arquivos do medico
    private File arquivoMedico;
    private FileWriter escreveMedico;
    private BufferedWriter escreveBufferMedico;
    private FileReader lerMedico;
    private BufferedReader lerBufferMedico;
    // atributos de arquivos do atendente
    private File arquivoAtendente;
    private FileWriter escreveAtendente;
    private BufferedWriter escreveBufferAtendente;
    private FileReader lerAtendente;
    private BufferedReader lerBufferAtendente;
    // atributos de arquivos de salvar a consulta
    private File arquivoConsulta;
    private FileWriter escreveConsulta;
    private BufferedWriter escreveBufferConsulta;
    private FileReader lerConsulta;
    private BufferedReader lerBufferConsulta;
    
    // construtor
    public Arquivos(){
        this.arquivoMedico = new File("src/db/medico.txt");
        this.arquivoAtendente = new File("src/db/atendente.txt");
        this.arquivoPaciente = new File("src/db/paciente.txt");
        this.arquivoConsulta = new File("src/db/consulta.txt");
        try {
            // inicializando o paciente
            if(!this.arquivoPaciente.exists()){
                this.arquivoPaciente.createNewFile();
            }
            this.escrevePaciente = new FileWriter(this.arquivoPaciente, true);
            this.escreveBufferPaciente = new BufferedWriter(this.escrevePaciente);
            this.lerPaciente = new FileReader(this.arquivoPaciente);
            this.lerBufferPaciente = new BufferedReader(this.lerPaciente);
            
            // inicializanfo o medico
            if(!this.arquivoMedico.exists()){
                this.arquivoMedico.createNewFile();
            }
            this.escreveMedico = new FileWriter(this.arquivoMedico, true);
            this.escreveBufferMedico = new BufferedWriter(this.escreveMedico);
            this.lerMedico = new FileReader(this.arquivoMedico);
            this.lerBufferMedico = new BufferedReader(this.lerMedico);
            
            // inicializando o atendente 
            if(!this.arquivoAtendente.exists()){
                this.arquivoAtendente.createNewFile();
            }
            this.escreveAtendente = new FileWriter(this.arquivoAtendente, true);
            this.escreveBufferAtendente = new BufferedWriter(this.escreveAtendente);
            this.lerAtendente = new FileReader(this.arquivoAtendente);
            this.lerBufferAtendente = new BufferedReader(this.lerAtendente);
            
            // inicializando as consultas
            if(!this.arquivoConsulta.exists()){
                this.arquivoConsulta.createNewFile();
            }
            this.escreveConsulta = new FileWriter(this.arquivoConsulta, true);
            this.escreveBufferConsulta = new BufferedWriter(this.escreveConsulta);
            this.lerConsulta = new FileReader(this.arquivoConsulta);
            this.lerBufferConsulta = new BufferedReader(this.lerConsulta);
        } catch (IOException ex) {
            System.out.println("Deu rui,");
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // metodos
    public void WriteFile(String caminho, String texto){
        try (
            FileWriter criaArquivo = new FileWriter(caminho, true);
            BufferedWriter buffer = new BufferedWriter(criaArquivo);
            PrintWriter escrever = new PrintWriter (buffer);
                  ){
             escrever.append(texto);
                
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
       
    public void registrar(Paciente paciente){
        
        try {
            this.escreveBufferPaciente.write(paciente.getTipoSanguineo() + '\n');
            this.escreveBufferPaciente.write(paciente.getConvenio() + '\n');
            this.escreveBufferPaciente.write(paciente.getNome() + '\n');
            this.escreveBufferPaciente.write(paciente.getCpf() + '\n');
            this.escreveBufferPaciente.write(paciente.getSexo() + '\n');
            this.escreveBufferPaciente.write(paciente.getEndereco() + '\n');
            this.escreveBufferPaciente.write(paciente.getEmail() + '\n');
            this.escreveBufferPaciente.write(paciente.getCelular() + '\n');
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.escreveBufferPaciente.write(paciente.getDataNascimento().format(formatter) + '\n');
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrar(Medico medico){
        try {
            this.escreveBufferMedico.write(medico.getNome());
            this.escreveBufferMedico.newLine();
            this.escreveBufferMedico.write(medico.getCpf());
            this.escreveBufferMedico.newLine();
            this.escreveBufferMedico.write(medico.getSexo());
            this.escreveBufferMedico.newLine();
            this.escreveBufferMedico.write(medico.getEndereco());
            this.escreveBufferMedico.newLine();
            this.escreveBufferMedico.write(medico.getEmail());
            this.escreveBufferMedico.newLine();
            this.escreveBufferMedico.write(medico.getCelular());
            this.escreveBufferMedico.newLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.escreveBufferMedico.write(medico.getDataNascimento().format(formatter));
            this.escreveBufferMedico.newLine();
            this.escreveBufferMedico.write(medico.getSenha());
            this.escreveBufferMedico.newLine();
            this.escreveBufferMedico.write(medico.getInscricaoCRM());
            this.escreveBufferMedico.newLine();
            this.escreveBufferMedico.write(medico.getEspecialidade());
            this.escreveBufferMedico.newLine();
            
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrar(Atendente atendente){
        try {
            this.escreveBufferAtendente.write(Integer.toString(atendente.getNumeroBalcao()));
            this.escreveBufferAtendente.newLine();
            this.escreveBufferAtendente.write(atendente.getNome());
            this.escreveBufferAtendente.newLine();
            this.escreveBufferAtendente.write(atendente.getCpf());
            this.escreveBufferAtendente.newLine();
            this.escreveBufferAtendente.write(atendente.getSexo());
            this.escreveBufferAtendente.newLine();
            this.escreveBufferAtendente.write(atendente.getEndereco());
            this.escreveBufferAtendente.newLine();
            this.escreveBufferAtendente.write(atendente.getEmail());
            this.escreveBufferAtendente.newLine();
            this.escreveBufferAtendente.write(atendente.getCelular());
            this.escreveBufferAtendente.newLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.escreveBufferAtendente.write(atendente.getDataNascimento().format(formatter));
            this.escreveBufferAtendente.newLine();
            this.escreveBufferAtendente.write(atendente.getSenha());
            this.escreveBufferAtendente.newLine();
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrar(Consulta consulta){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        WriteFile("src/db/consulta.txt", consulta.getDataHorario().format(formatter).toString() + '\n');
        WriteFile("src/db/consulta.txt", Integer.toString(consulta.getIdMedico()) + '\n');
        WriteFile("src/db/consulta.txt", Integer.toString(consulta.getIdPaciente()) + '\n');

    }
    
    public void remover(ArrayList<Consulta> consultas) {
        try (
            FileWriter criaArquivo = new FileWriter("src/db/consulta.txt", false);
            BufferedWriter buffer = new BufferedWriter(criaArquivo);
            PrintWriter escrever = new PrintWriter (buffer);
                  ){
            for(Consulta consulta: consultas){
                escrever.append(consulta.getDataHorario().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + '\n');
                escrever.append(Integer.toString(consulta.getIdMedico()) + '\n');
                escrever.append(Integer.toString(consulta.getIdPaciente()) + '\n');
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public ArrayList<Paciente> carregaPaciente(){
        BufferedReader br = this.lerBufferPaciente;
        ArrayList<Paciente> pac = new ArrayList();
        try {
            while(br.ready()){
                String tpSangue = br.readLine();
                if(tpSangue.equals("")){
                    return null;
                }
                String [] vet = new String[8];
                for(int i = 0; i < vet.length; ++i){
                    vet[i] = br.readLine();
                }
                LocalDate dataNascimento = LocalDate.parse(vet[7], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                pac.add(new Paciente(tpSangue, vet[0], vet[1], vet[2], vet[3], vet[4], vet[5], vet[6], dataNascimento));
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pac;
    }
    
    public ArrayList<Medico> carregaMedico(){
        BufferedReader br = this.lerBufferMedico;
        ArrayList<Medico> med = new ArrayList();
        try {
            while(br.ready()){
                String nome = br.readLine();
                if(nome.equals("")){
                    return null;
                }
                String [] vet = new String[9];
                for(int i = 0; i < vet.length; ++i){
                    vet[i] = br.readLine();
                }
                LocalDate dataNascimento = LocalDate.parse(vet[5], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                med.add(new Medico(nome, vet[0], vet[1], vet[2], vet[3], vet[4], dataNascimento, vet[6], vet[7], vet[8]));
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return med;
    }
    
    public ArrayList<Atendente> carregaAtendente(){
        BufferedReader br = this.lerBufferAtendente;
        ArrayList<Atendente> atende = new ArrayList();
        try {
            while(br.ready()){
                String nBalcao = br.readLine();
                try{
                    int n = Integer.parseInt(nBalcao);
                } catch(NumberFormatException ex){
                    break;
                }
                String [] vet = new String[8];
                for(int i = 0; i < vet.length; ++i){
                    vet[i] = br.readLine();
                }
                LocalDate dataNascimento = LocalDate.parse(vet[6], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                atende.add(new Atendente(Integer.parseInt(nBalcao), vet[0], vet[1], vet[2], vet[3], vet[4], vet[5], dataNascimento, vet[7]));
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atende;
    }
    
    public ArrayList<Consulta> carregaConsulta(){
        ArrayList<Consulta> consultas = new ArrayList();
        
        BufferedReader br = this.lerBufferConsulta;
        
        try {
            while(br.ready()){
                int idMed, idPac;
                String data = br.readLine();
                if(data.equals("")){
                    return null;
                }
                LocalDateTime dataConsulta = LocalDateTime.parse(data , DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                idMed = Integer.parseInt(br.readLine());
                idPac = Integer.parseInt(br.readLine());
                consultas.add(new Consulta(dataConsulta, idMed, idPac));
            }
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return consultas;
    }
    
    public void close(){
        try {
            this.escreveBufferMedico.close();
            this.escreveMedico.close();
            this.lerBufferMedico.close();
            this.lerMedico.close();
            this.escreveBufferAtendente.close();
            this.escreveAtendente.close();
            this.lerBufferAtendente.close();
            this.lerAtendente.close();
            this.lerBufferPaciente.close();
            this.lerPaciente.close();
            this.escreveBufferPaciente.close();
            this.escrevePaciente.close();
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
