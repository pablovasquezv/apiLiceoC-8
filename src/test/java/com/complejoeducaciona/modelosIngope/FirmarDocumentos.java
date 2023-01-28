package com.complejoeducaciona.modelosIngope;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "identificadorContrato",
        "cuentaCliente",
        "gFirmantess",
        "nombrePlantilla"
})

@Data
@NoArgsConstructor
public class FirmarDocumentos {
    public int identificadorContrato;
    public CuentaCliente cuentaCliente;
    public GFirmantess gFirmantess;
    public String nombrePlantilla;
}