/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr;

/**
 *
 * @author usuario
 */
public class ExceptionHR extends Exception{
    private int codigoErrorBD;
    private String mensajeErrorBD;
    private String mensajeErrorUsuario;
    private String dml;

    public ExceptionHR() {
    }

    public ExceptionHR(int codigoErrorBD, String mensajeErrorBD, String mensajeErrorUsuario, String dml) {
        this.codigoErrorBD = codigoErrorBD;
        this.mensajeErrorBD = mensajeErrorBD;
        this.mensajeErrorUsuario = mensajeErrorUsuario;
        this.dml = dml;
    }

    public int getCodigoErrorBD() {
        return codigoErrorBD;
    }

    public void setCodigoErrorBD(int codigoErrorBD) {
        this.codigoErrorBD = codigoErrorBD;
    }

    public String getMensajeErrorBD() {
        return mensajeErrorBD;
    }

    public void setMensajeErrorBD(String mensajeErrorBD) {
        this.mensajeErrorBD = mensajeErrorBD;
    }

    public String getMensajeErrorUsuario() {
        return mensajeErrorUsuario;
    }

    public void setMensajeErrorUsuario(String mensajeErrorUsuario) {
        this.mensajeErrorUsuario = mensajeErrorUsuario;
    }

    public String getDml() {
        return dml;
    }

    public void setDml(String dml) {
        this.dml = dml;
    }

    @Override
    public String toString() {
        return "ExceptionHR{" + "codigoErrorBD=" + codigoErrorBD + ", mensajeErrorBD=" + mensajeErrorBD + ", mensajeErrorUsuario=" + mensajeErrorUsuario + ", dml=" + dml + '}';
    }
    
    
}
