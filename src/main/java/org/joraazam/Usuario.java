package org.joraazam;

import java.util.ArrayList;

public class Usuario {
    String username = null;
    ArrayList<Prestamo> prestamoList = new ArrayList<Prestamo>();
    int cargoPorAtraso = 0;

    public Usuario(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(ArrayList<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }

    public int getCargoPorAtraso() {
        return cargoPorAtraso;
    }

    public void setCargoPorAtraso(int i) {
        cargoPorAtraso = i;
    }
}
