package com.complejoeducaciona.modelosIngope;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "gFirmantes"
})

public class GFirmantess {
    @XmlElement(name = "gFirmantes", required = true)
    private List<GFirmantes> gFirmantes;

    public List<GFirmantes> getgFirmantes() {
        if (gFirmantes == null) {
            gFirmantes = new ArrayList<GFirmantes>();
        }
        return this.gFirmantes;
    }

    public void setgFirmantes(List<GFirmantes> gFirmantes) {
        this.gFirmantes = gFirmantes;
    }
}


