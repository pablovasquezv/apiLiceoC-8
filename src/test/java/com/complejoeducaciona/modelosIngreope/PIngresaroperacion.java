package com.complejoeducaciona.modelosIngreope;

import java.util.Date;
import java.util.List;


public class PIngresaroperacion {
    public double IdentificadorTransaccion;
    public String Producto;
    public String Operacion;
    public int IdentificadorCliente;
    public int CuentaInversion;
    public String CodigoMoneda;
    public double MontoOperacionString;
    public double UnidadesTransadas;
    public Date FechaIngreso;
    public Date FechaSolicitud;
    public int RutEmpleadoEjecutivoConect;
    public String UsuarioEjecutivoConectado;
    public int RutEmpleadoEjecutivoOperac;
    public String Canal;
    public int IdentificadorCanalAtencion;
    public FirmarDocumentos FirmarDocumentos;
    public OperacionMonedaExtranjera OperacionMonedaExtranjera;
    public PIngresarInstruccions PIngresarInstruccions;
    private List<PIngresarInstruccion> listaInstruccion;
    public boolean IndicadorAvanzaAutomatico;
    public String NombreSucursalRetiro;
    public String Observacion;
    public boolean IndicadorFirmaMiPass;
}
