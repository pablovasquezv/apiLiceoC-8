package com.complejoeducaciona.modelosIngope;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "pIngresarInstruccion"
})

public class PIngresarInstruccions {
    private List<PIngresarInstruccion> pIngresarInstruccion;

    public List<PIngresarInstruccion> getPIngresarInstruccion() {
        if (pIngresarInstruccion == null) {
            pIngresarInstruccion = new ArrayList<PIngresarInstruccion>();
        }
        return this.pIngresarInstruccion;
    }

    public void setpIngresarInstruccion(List<PIngresarInstruccion> pIngresarInstruccion) {
        this.pIngresarInstruccion = pIngresarInstruccion;
    }
}
