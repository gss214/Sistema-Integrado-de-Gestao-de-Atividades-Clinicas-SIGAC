// medico

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoas;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import marcarconsulta.*;

/**
 *
 * @author gss21
 */
public class Medico extends Pessoa {
    // atributos
    private String inscricaoCFM, inscricaoCRM, especialidade, senha;
    private Map<String, String> agenda = new HashMap<String, String>();
    
    
    // classes relacionadas
    ArrayList<Consulta> consultas = new ArrayList();
    
    // construtor
    public Medico(){}
    
    public Medico(String nome, String cpf, String sexo, String endereco, String email, 
            String celular, LocalDate dataNascimento, String senha,
            String inscricaoCRM, String especialidade) {
        super(nome, cpf, sexo, endereco, email, celular, dataNascimento);
        this.inscricaoCRM = inscricaoCRM;
        this.especialidade = especialidade;
        this.senha = senha;
    }
    
    // setter e getter

    public Map getAgenda() {
        return agenda;
    }

    public void setAgenda(Map agenda) {
        this.agenda = agenda;
    }
    
    
    public String getInscricaoCFM() {
        return inscricaoCFM;
    }

    public void setInscricaoCFM(String inscricaoCFM) {
        this.inscricaoCFM = inscricaoCFM;
    }

    public String getInscricaoCRM() {
        return inscricaoCRM;
    }

    public void setInscricaoCRM(String inscricaoCRM) {
        this.inscricaoCRM = inscricaoCRM;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public ArrayList<Consulta> getMinhasConsultas() {
        return this.consultas;
    }
    
    // metodos
    
    public void addConsulta(Consulta consulta){
        this.consultas.add(consulta);
    }
    
    public void removeConsulta(Consulta consulta){
        this.consultas.remove(consulta);
    }
    
 
}
