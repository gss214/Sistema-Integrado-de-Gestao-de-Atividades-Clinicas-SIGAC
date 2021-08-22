// receitamedica

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marcarconsulta;

import java.time.LocalDateTime;

/**
 *
 * @author enzoy
 */
public class ReceitaMedica {
    // atributos
    private LocalDateTime dataHorarioCriacao;
    private String texto;
    
    // classes relacionadas 
    private Consulta consulta;
    
    // construtor
    public ReceitaMedica(){}

    public ReceitaMedica(LocalDateTime dataHorarioCriacao, String texto, Consulta consulta) {
        this.dataHorarioCriacao = dataHorarioCriacao;
        this.texto = texto;
        this.consulta = consulta;
    }
    
    // setter e getter

    public LocalDateTime getDataHorarioCriacao() {
        return dataHorarioCriacao;
    }

    public void setDataHorarioCriacao(LocalDateTime dataHorarioCriacao) {
        this.dataHorarioCriacao = dataHorarioCriacao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Consulta getConsulta() {
        return this.consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    
}
