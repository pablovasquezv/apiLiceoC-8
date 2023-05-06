package com.complejoeducaciona.modelosIngope;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "fondosMutuos",
        "divisa",
        "acciones",
        "codigoModalidad",
        "identificadorCanal",
        "idicadorAvanzaAutomatico",
        "pIngresarInstruccion"
})

@Data
@NoArgsConstructor
public class DatosReinversion {
    public OperacionFondosMutuos fondosMutuos;
    public OperacionMonedaExtranjera divisa;
    public OperacionAcciones acciones;
    private String codigoModalidad;
    private Byte identificadorCanal;
    private String idicadorAvanzaAutomatico;
    private PIngresarInstruccion pIngresarInstruccion;

}