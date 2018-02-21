package entity;

public class LocalizacionMetastasis {

    private int localizacion_metastasis_id;
    private String localizacion_metastasis;
    private int eliminado;

    public LocalizacionMetastasis() {
    }

    public LocalizacionMetastasis(int localizacion_metastasis_id, String localizacion_metastasis, int eliminado) {
        this.localizacion_metastasis_id = localizacion_metastasis_id;
        this.localizacion_metastasis = localizacion_metastasis;
        this.eliminado = eliminado;
    }

    public int getLocalizacion_metastasis_id() {
        return localizacion_metastasis_id;
    }

    public void setLocalizacion_metastasis_id(int localizacion_metastasis_id) {
        this.localizacion_metastasis_id = localizacion_metastasis_id;
    }

    public String getLocalizacion_metastasis() {
        return localizacion_metastasis;
    }

    public void setLocalizacion_metastasis(String localizacion_metastasis) {
        this.localizacion_metastasis = localizacion_metastasis;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

}
