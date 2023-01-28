package com.complejoeducaciona.modelosIngope;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tipoCliente",
        "rut",
        "nombredeCuenta",
        "accountId",
        "iDContacto",
        "digitoVerificador"
})

@Data
@NoArgsConstructor
public class CuentaCliente {
    public int tipoCliente;
    public int rut;
    public String nombredeCuenta;
    public String accountId;
    public String iDContacto;
    public int digitoVerificador;
}