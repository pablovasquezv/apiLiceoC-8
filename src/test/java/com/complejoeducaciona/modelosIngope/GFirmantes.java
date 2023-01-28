package com.complejoeducaciona.modelosIngope;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "nombreFirmante",
        "correoElectronico",
        "rutFirmante",
        "identificadorFirmante"
})
@Data
@NoArgsConstructor
public class GFirmantes {
    public String nombreFirmante;
    public String correoElectronico;
    public int rutFirmante;
    public String identificadorFirmante;
}