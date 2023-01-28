package com.complejoeducaciona.modelosIngreope;

import com.complejoeducaciona.modelosIngope.GFirmantes;

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
    private List<com.complejoeducaciona.modelosIngope.GFirmantes> gFirmantes;

    public List<com.complejoeducaciona.modelosIngope.GFirmantes> getgFirmantes() {
        if (gFirmantes == null) {
            gFirmantes = new ArrayList<com.complejoeducaciona.modelosIngope.GFirmantes>();
        }
        return this.gFirmantes;
    }

    public void setgFirmantes(List<GFirmantes> gFirmantes) {
        this.gFirmantes = gFirmantes;
    }
}
