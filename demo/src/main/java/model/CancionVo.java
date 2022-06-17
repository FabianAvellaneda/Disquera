package model;

public class CancionVo {

    private int idC;
    private String nombreC;
    private String fgrab;
    private String duraC;
    private boolean estadoC;
   
    public CancionVo() {

    }

    public CancionVo(int idC, String nombreC, String fgrab, String duraC, boolean estadoC) {
        this.idC = idC;
        this.nombreC = nombreC;
        this.fgrab = fgrab;
        this.duraC = duraC;
        this.estadoC = estadoC;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getFgrab() {
        return fgrab;
    }

    public void setFgrab(String fgrab) {
        this.fgrab = fgrab;
    }

    public String getDuraC() {
        return duraC;
    }

    public void setDuraC(String duraC) {
        this.duraC = duraC;
    }

    public boolean getEstadoC() {
        return estadoC;
    }

    public void setEstadoC(boolean estadoC) {
        this.estadoC = estadoC;
    }
    
}
