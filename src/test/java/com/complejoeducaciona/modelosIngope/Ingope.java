package com.complejoeducaciona.modelosIngope;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "identificadorTransaccion",
        "producto",
        "operacion",
        "identificadorCliente",
        "cuentaInversion",
        "codigoMoneda",
        "montoOperacionString",
        "unidadesTransadas",
        "fechaIngreso",
        "fechaSolicitud",
        "rutEmpleadoEjecutivoConect",
        "usuarioEjecutivoConectado",
        "rutEmpleadoEjecutivoOperac",
        "canal",
        "identificadorCanalAtencion",
        "firmarDocumentos",
        "operacionMonedaExtranjera",
        "pIngresarInstruccions",
        "indicadorAvanzaAutomatico",
        "nombreSucursalRetiro",
        "observacion",
        "indicadorFirmaMiPass"
})
@XmlRootElement(name = "Ingope")
@Data
@NoArgsConstructor

public class Ingope {
    public double identificadorTransaccion;
    public String producto;
    public String operacion;
    public int identificadorCliente;
    public int cuentaInversion;
    public String codigoMoneda;
    public double montoOperacionString;
    public double unidadesTransadas;
    public Date fechaIngreso;
    public Date fechaSolicitud;
    public int rutEmpleadoEjecutivoConect;
    public String usuarioEjecutivoConectado;
    public int rutEmpleadoEjecutivoOperac;
    public String canal;
    public int identificadorCanalAtencion;
    public FirmarDocumentos firmarDocumentos;
    public OperacionMonedaExtranjera operacionMonedaExtranjera;
    public PIngresarInstruccions pIngresarInstruccions;
    public boolean indicadorAvanzaAutomatico;
    public String nombreSucursalRetiro;
    public String observacion;
    public boolean indicadorFirmaMiPass;
}
