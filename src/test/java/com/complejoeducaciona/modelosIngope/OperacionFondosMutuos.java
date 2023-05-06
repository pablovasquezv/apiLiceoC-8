package com.complejoeducaciona.modelosIngope;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "indicadorRescateTotal",
        "codigoOperacion",
        "indicador18q",
        "beneficioTributario",
        "codigoPlanCuenta",
        "nemoFondoMutuo",
        "numeroCuenta"
})

@Data
@NoArgsConstructor
public class OperacionFondosMutuos {
    public String indicadorRescateTotal;
    public String codigoOperacion;
    public String indicador18q;
    public String beneficioTributario;
    public int codigoPlanCuenta;
    public String nemoFondoMutuo;
    public int numeroCuenta;
}