
// atendente

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import marcarconsulta.*;

/**
 *
 * @author EYZ
 */
public class Atendente extends Pessoa {
    // atributos
    private int numeroBalcao;
    private String senha;

    // classes relacionadas
    ArrayList<Consulta> consultas = new ArrayList();
    
    // construtor
    public Atendente(){
    }
    
    public Atendente(int numeroBalcao, String nome, String cpf, String sexo, String endereco, String email, String celular, LocalDate dataNascimento, String senha) {
        super(nome, cpf, sexo, endereco, email, celular, dataNascimento);
        this.numeroBalcao = numeroBalcao;
        this.senha = senha;
    }
    
    // setter e getter
    public int getNumeroBalcao() {
        return numeroBalcao;
    }

    public void setNumeroBalcao(int numeroBalcao) {
        this.numeroBalcao = numeroBalcao;
    }
    
    // metodos
    
    public void agendarConsulta(Paciente paciente, Medico medico, LocalDateTime data, Consulta consulta){
        paciente.addConsulta(consulta);
        medico.addConsulta(consulta);
    }
    

    
    // retorna um paciente cadastrado ?
    public Paciente cadastrarPaciente(String tipoSanguineo, String convenio, String nome, String cpf, String sexo, 
                        String endereco, String email, String celular, LocalDate dataNascimento){
        Paciente paciente = new Paciente(tipoSanguineo, convenio, nome, cpf, sexo, endereco, email, celular, dataNascimento);
        return paciente;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
