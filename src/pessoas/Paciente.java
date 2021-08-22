
// paciente

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoas;

import java.time.LocalDate;
import java.util.ArrayList;
import marcarconsulta.*;

/**
 *
 * @author enzoy
 */
public class Paciente extends Pessoa{
    // atributos
    private String tipoSanguineo, convenio;
    
    // Classes relacionadas
    private ArrayList<Consulta> minhasConsultas;
    
    // construtor
    public Paciente(){
        this.minhasConsultas = new ArrayList();
    }
    
    public Paciente(String tipoSanguineo, String convenio, String nome, String cpf, String sexo, String endereco, String email, String celular, LocalDate dataNascimento) {
        super(nome, cpf, sexo, endereco, email, celular, dataNascimento);
        this.minhasConsultas = new ArrayList();
        this.tipoSanguineo = tipoSanguineo;
        this.convenio = convenio;
    }
    
    // setter e getter 

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public ArrayList<Consulta> getMinhasConsultas() {
        return minhasConsultas;
    }

    public void setMinhasConsultas(ArrayList<Consulta> minhasConsultas) {
        this.minhasConsultas = minhasConsultas;
    }
    

    
    // adicionar consulta
    
    public void addConsulta(Consulta consulta){
        this.minhasConsultas.add(consulta);
    }
    
    public void removeConsulta(Consulta consulta){
        this.minhasConsultas.remove(consulta);
    }
}
