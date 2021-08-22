
// consulta

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marcarconsulta;

import pessoas.*;
import java.time.LocalDateTime;

/**
 *
 * @author enzoy
 */
public class Consulta {
    // atributos
    private LocalDateTime dataHorario;
    private int idMedico, idPaciente;
    
    // Precisa mesmo disso nessa classe ? acho q sim pra poder apagar na hr de cancelar SIM
    // Classes relacionadas 
    private Paciente paciente;
    private Medico medico;
    private ReceitaMedica receita;
    
    // Construtor
    public Consulta(){
    }
    
    public Consulta(LocalDateTime dataHorario, int idMed, int idPac){
        this.medico = new Medico();
        this.paciente = new Paciente();
        this.dataHorario = dataHorario;
        this.idMedico = idMed;
        this.idPaciente = idPac;
    }

    public Consulta(LocalDateTime dataHorario, Paciente paciente, Medico medico, int idMed, int idPac) {
        this.medico = new Medico();
        this.paciente = new Paciente();
        this.dataHorario = dataHorario;
        this.paciente = paciente;
        this.medico = medico;
        this.idMedico = idMed;
        this.idPaciente = idPac;
    }
    
    // setter e getter 

    public LocalDateTime getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(LocalDateTime dataHorario) {
        this.dataHorario = dataHorario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public ReceitaMedica getReceitaMedica() {
        return this.receita;
    }

    public void setReceitaMedica(ReceitaMedica receita) {
        this.receita = receita;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    
    
}

