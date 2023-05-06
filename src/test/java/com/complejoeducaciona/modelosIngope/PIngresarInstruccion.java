package com.complejoeducaciona.modelosIngope;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "monto",
        "codigoModalidad",
        "bancoOrigen",
        "bancoDeposito",
        "moneda",
        "tipoInstruccion",
        "rutEmpleadoIngreso",
        "canalIngreso",
        "indicadorPagoTerceros",
        "cuenta",
        "indicadorAvanzaAutomatico",
        "indicadorReinversion",
        "datosReinversion",
        "numeroCuentaCorriente"
})

@Data
@NoArgsConstructor
public class PIngresarInstruccion {
    public double monto;
    public int codigoModalidad;
    public int bancoOrigen;
    public int bancoDeposito;
    public String moneda;
    public String tipoInstruccion;
    public int rutEmpleadoIngreso;
    public String canalIngreso;
    public boolean indicadorPagoTerceros;
    public Cuenta cuenta;
    public boolean indicadorAvanzaAutomatico;
    public boolean indicadorReinversion;
    public DatosReinversion datosReinversion;
    public double numeroCuentaCorriente;
}