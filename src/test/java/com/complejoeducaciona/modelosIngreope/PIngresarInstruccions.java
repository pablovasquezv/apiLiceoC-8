package com.complejoeducaciona.modelosIngreope;


import com.complejoeducaciona.modelosIngope.PIngresarInstruccion;

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
    private List<com.complejoeducaciona.modelosIngope.PIngresarInstruccion> pIngresarInstruccion;

    public List<com.complejoeducaciona.modelosIngope.PIngresarInstruccion> getPIngresarInstruccion() {
        if (pIngresarInstruccion == null) {
            pIngresarInstruccion = new ArrayList<com.complejoeducaciona.modelosIngope.PIngresarInstruccion>();
        }
        return this.pIngresarInstruccion;
    }

    public void setpIngresarInstruccion(List<PIngresarInstruccion> pIngresarInstruccion) {
        this.pIngresarInstruccion = pIngresarInstruccion;
    }
}