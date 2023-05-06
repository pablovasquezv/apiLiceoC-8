package com.complejoeducaciona.modelosIngope;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "fechaVigencia",
        "cantidadOrden",
        "indicadorPrecioLimite",
        "indicadorPrimeraEmision",
        "medioCobroPago",
        "nombreSerie"
})

@Data
@NoArgsConstructor

public class OperacionAcciones {
    private String fechaVigencia;
    private BigDecimal cantidadOrden;
    private String indicadorPrecioLimite;
    private String indicadorPrimeraEmision;
    private String medioCobroPago;
    private String nombreSerie;
}
