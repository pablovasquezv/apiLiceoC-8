package com.complejoeducaciona.modelosIngope;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tipoCliente",
        "digitoVerificador",
        "rut",
        "numerodeCuenta",
        "accountId",
        "iDContacto"
})

@Data
@NoArgsConstructor
public class Cuenta {
    public int tipoCliente;
    public int digitoVerificador;
    public int rut;
    public String numerodeCuenta;
    public String accountId;
    public String iDContacto;
}