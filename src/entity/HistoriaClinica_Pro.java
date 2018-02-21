/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class HistoriaClinica_Pro {

    private int paciente_id;
    private String fecha_diag_histologico;
    private int histologia_id;
    private int psa;
    private int gleason;
    private int grupo_riesgo_id;
    private int tratamiento_inicial_id;
    private int numero_sitios_metastasicos;
    private int localizacion_metastasis_id;
    private String fecha_ultimo_control;

    public HistoriaClinica_Pro() {
    }

    public HistoriaClinica_Pro(int paciente_id, String fecha_diag_histologico, int histologia_id, int psa, int gleason, int grupo_riesgo_id, int tratamiento_inicial_id, int numero_sitios_metastasicos, int localizacion_metastasis_id, String fecha_ultimo_control) {
        this.paciente_id = paciente_id;
        this.fecha_diag_histologico = fecha_diag_histologico;
        this.histologia_id = histologia_id;
        this.psa = psa;
        this.gleason = gleason;
        this.grupo_riesgo_id = grupo_riesgo_id;
        this.tratamiento_inicial_id = tratamiento_inicial_id;
        this.numero_sitios_metastasicos = numero_sitios_metastasicos;
        this.localizacion_metastasis_id = localizacion_metastasis_id;
        this.fecha_ultimo_control = fecha_ultimo_control;
    }

    public int getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
    }

    public String getFecha_diag_histologico() {
        return fecha_diag_histologico;
    }

    public void setFecha_diag_histologico(String fecha_diag_histologico) {
        this.fecha_diag_histologico = fecha_diag_histologico;
    }

    public int getHistologia_id() {
        return histologia_id;
    }

    public void setHistologia_id(int histologia_id) {
        this.histologia_id = histologia_id;
    }

    public int getPsa() {
        return psa;
    }

    public void setPsa(int psa) {
        this.psa = psa;
    }

    public int getGleason() {
        return gleason;
    }

    public void setGleason(int gleason) {
        this.gleason = gleason;
    }

    public int getGrupo_riesgo_id() {
        return grupo_riesgo_id;
    }

    public void setGrupo_riesgo_id(int grupo_riesgo_id) {
        this.grupo_riesgo_id = grupo_riesgo_id;
    }

    public int getTratamiento_inicial_id() {
        return tratamiento_inicial_id;
    }

    public void setTratamiento_inicial_id(int tratamiento_inicial_id) {
        this.tratamiento_inicial_id = tratamiento_inicial_id;
    }

    public int getNumero_sitios_metastasicos() {
        return numero_sitios_metastasicos;
    }

    public void setNumero_sitios_metastasicos(int numero_sitios_metastasicos) {
        this.numero_sitios_metastasicos = numero_sitios_metastasicos;
    }

    public int getLocalizacion_metastasis_id() {
        return localizacion_metastasis_id;
    }

    public void setLocalizacion_metastasis_id(int localizacion_metastasis_id) {
        this.localizacion_metastasis_id = localizacion_metastasis_id;
    }

    public String getFecha_ultimo_control() {
        return fecha_ultimo_control;
    }

    public void setFecha_ultimo_control(String fecha_ultimo_control) {
        this.fecha_ultimo_control = fecha_ultimo_control;
    }

}
