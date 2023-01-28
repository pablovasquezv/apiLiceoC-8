package com.complejoeducaciona.modelosIngope;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "codigoOficina",
        "codigoMonedaPago",
        "codigoIso",
        "codigoMonedaCobro",
        "montoTotalPago",
        "paridad",
        "precioCompra",
        "precioMedio",
        "precioVenta",
        "montoComisionCalculada",
        "montoComisionRealCalculada"
})

@Data
@NoArgsConstructor
public class OperacionMonedaExtranjera {
    public int codigoOficina;
    public String codigoMonedaPago;
    public String codigoIso;
    public String codigoMonedaCobro;
    public double montoTotalPago;
    public double paridad;
    public double precioCompra;
    public double precioMedio;
    public double precioVenta;
    public double montoComisionCalculada;
    public double montoComisionRealCalculada;
}
