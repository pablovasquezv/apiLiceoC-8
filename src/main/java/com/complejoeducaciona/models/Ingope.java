package com.complejoeducaciona.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"identificadorTransaccion", "producto", "operacion", "identificadorCliente", "cuentaInversion", "codigoMoneda", "montoOperacionString", "correlativo", "unidadesTransadas", "fechaCurse", "fechaIngreso", "fechaSolicitud", "fechaPago", "rutEmpleadoEjecutivoConect", "usuarioEjecutivoConectado", "rutEmpleadoEjecutivoOperac", "observacion", "numeroDeOrden", "mensaje", "canal", "identificadorCanalAtencion", "indicadorAvanzaAutomatico", "pIngresarInstruccions", "operacionMonedaExtranjera", "operacionFondosMutuos", "operacionAcciones"}
)
@XmlRootElement(
        name = "Ingope"
)
public class Ingope {
    protected long identificadorTransaccion;
    protected String producto;
    protected String operacion;
    protected int identificadorCliente;
    protected byte cuentaInversion;
    protected String codigoMoneda;
    protected float montoOperacionString;
    protected String correlativo;
    protected float unidadesTransadas;
    protected String fechaCurse;
    @XmlSchemaType(
            name = "dateTime"
    )
    protected XMLGregorianCalendar fechaIngreso;
    @XmlSchemaType(
            name = "dateTime"
    )
    protected XMLGregorianCalendar fechaSolicitud;
    protected String fechaPago;
    protected int rutEmpleadoEjecutivoConect;
    protected String usuarioEjecutivoConectado;
    protected int rutEmpleadoEjecutivoOperac;
    protected String observacion;
    protected String numeroDeOrden;
    protected String mensaje;
    protected String canal;
    protected byte identificadorCanalAtencion;
    /***
    protected String indicadorAvanzaAutomatico;
    protected PIngresarInstruccions pIngresarInstruccions;
    protected OperacionMonedaExtranjera operacionMonedaExtranjera;
    protected OperacionFondosMutuos operacionFondosMutuos;
    protected OperacionAcciones operacionAcciones;
    public long getIdentificadorTransaccion() {
        return this.identificadorTransaccion;
    }
    public String getProducto() {
        return this.producto;
    }
    public String getOperacion() {
        return this.operacion;
    }
    public int getIdentificadorCliente() {
        return this.identificadorCliente;
    }
    public byte getCuentaInversion() {
        return this.cuentaInversion;
    }
    public String getCodigoMoneda() {
        return this.codigoMoneda;
    }
    public float getMontoOperacionString() {
        return this.montoOperacionString;
    }
    public String getCorrelativo() {
        return this.correlativo;
    }
    public float getUnidadesTransadas() {
        return this.unidadesTransadas;
    }
    public String getFechaCurse() {
        return this.fechaCurse;
    }
    public XMLGregorianCalendar getFechaIngreso() {
        return this.fechaIngreso;
    }
    public XMLGregorianCalendar getFechaSolicitud() {
        return this.fechaSolicitud;
    }
    public String getFechaPago() {
        return this.fechaPago;
    }
    public int getRutEmpleadoEjecutivoConect() {
        return this.rutEmpleadoEjecutivoConect;
    }
    public String getUsuarioEjecutivoConectado() {
        return this.usuarioEjecutivoConectado;
    }
    public int getRutEmpleadoEjecutivoOperac() {
        return this.rutEmpleadoEjecutivoOperac;
    }
    public String getObservacion() {
        return this.observacion;
    }
    public String getNumeroDeOrden() {
        return this.numeroDeOrden;
    }
    public String getMensaje() {
        return this.mensaje;
    }
    public String getCanal() {
        return this.canal;
    }
    public byte getIdentificadorCanalAtencion() {
        return this.identificadorCanalAtencion;
    }
    public String getIndicadorAvanzaAutomatico() {
        return this.indicadorAvanzaAutomatico;
    }
    public PIngresarInstruccions getPIngresarInstruccions() {
        return this.pIngresarInstruccions;
    }
    public OperacionMonedaExtranjera getOperacionMonedaExtranjera() {
        return this.operacionMonedaExtranjera;
    }
    public OperacionFondosMutuos getOperacionFondosMutuos() {
        return this.operacionFondosMutuos;
    }
    public OperacionAcciones getOperacionAcciones() {
        return this.operacionAcciones;
    }
    public void setIdentificadorTransaccion(long identificadorTransaccion) {
        this.identificadorTransaccion = identificadorTransaccion;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    public void setIdentificadorCliente(int identificadorCliente) {
        this.identificadorCliente = identificadorCliente;
    }
    public void setCuentaInversion(byte cuentaInversion) {
        this.cuentaInversion = cuentaInversion;
    }
    public void setCodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }
    public void setMontoOperacionString(float montoOperacionString) {
        this.montoOperacionString = montoOperacionString;
    }
    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }
    public void setUnidadesTransadas(float unidadesTransadas) {
        this.unidadesTransadas = unidadesTransadas;
    }
    public void setFechaCurse(String fechaCurse) {
        this.fechaCurse = fechaCurse;
    }
    public void setFechaIngreso(XMLGregorianCalendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public void setFechaSolicitud(XMLGregorianCalendar fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
    public void setRutEmpleadoEjecutivoConect(int rutEmpleadoEjecutivoConect) {
        this.rutEmpleadoEjecutivoConect = rutEmpleadoEjecutivoConect;
    }
    public void setUsuarioEjecutivoConectado(String usuarioEjecutivoConectado) {
        this.usuarioEjecutivoConectado = usuarioEjecutivoConectado;
    }
    public void setRutEmpleadoEjecutivoOperac(int rutEmpleadoEjecutivoOperac) {
        this.rutEmpleadoEjecutivoOperac = rutEmpleadoEjecutivoOperac;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public void setNumeroDeOrden(String numeroDeOrden) {
        this.numeroDeOrden = numeroDeOrden;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public void setCanal(String canal) {
        this.canal = canal;
    }
    public void setIdentificadorCanalAtencion(byte identificadorCanalAtencion) {
        this.identificadorCanalAtencion = identificadorCanalAtencion;
    }
    public void setIndicadorAvanzaAutomatico(String indicadorAvanzaAutomatico) {
        this.indicadorAvanzaAutomatico = indicadorAvanzaAutomatico;
    }
    public void setPIngresarInstruccions(PIngresarInstruccions pIngresarInstruccions) {
        this.pIngresarInstruccions = pIngresarInstruccions;
    }
    public void setOperacionMonedaExtranjera(OperacionMonedaExtranjera operacionMonedaExtranjera) {
        this.operacionMonedaExtranjera = operacionMonedaExtranjera;
    }
    public void setOperacionFondosMutuos(OperacionFondosMutuos operacionFondosMutuos) {
        this.operacionFondosMutuos = operacionFondosMutuos;
    }
    public void setOperacionAcciones(OperacionAcciones operacionAcciones) {
        this.operacionAcciones = operacionAcciones;
    }
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Ingope)) {
            return false;
        } else {
            Ingope other = (Ingope)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getIdentificadorTransaccion() != other.getIdentificadorTransaccion()) {
                return false;
            } else {
                label257: {
                    Object this$producto = this.getProducto();
                    Object other$producto = other.getProducto();
                    if (this$producto == null) {
                        if (other$producto == null) {
                            break label257;
                        }
                    } else if (this$producto.equals(other$producto)) {
                        break label257;
                    }
                    return false;
                }
                Object this$operacion = this.getOperacion();
                Object other$operacion = other.getOperacion();
                if (this$operacion == null) {
                    if (other$operacion != null) {
                        return false;
                    }
                } else if (!this$operacion.equals(other$operacion)) {
                    return false;
                }
                if (this.getIdentificadorCliente() != other.getIdentificadorCliente()) {
                    return false;
                } else if (this.getCuentaInversion() != other.getCuentaInversion()) {
                    return false;
                } else {
                    label240: {
                        Object this$codigoMoneda = this.getCodigoMoneda();
                        Object other$codigoMoneda = other.getCodigoMoneda();
                        if (this$codigoMoneda == null) {
                            if (other$codigoMoneda == null) {
                                break label240;
                            }
                        } else if (this$codigoMoneda.equals(other$codigoMoneda)) {
                            break label240;
                        }
                        return false;
                    }
                    if (Float.compare(this.getMontoOperacionString(), other.getMontoOperacionString()) != 0) {
                        return false;
                    } else {
                        label232: {
                            Object this$correlativo = this.getCorrelativo();
                            Object other$correlativo = other.getCorrelativo();
                            if (this$correlativo == null) {
                                if (other$correlativo == null) {
                                    break label232;
                                }
                            } else if (this$correlativo.equals(other$correlativo)) {
                                break label232;
                            }
                            return false;
                        }
                        if (Float.compare(this.getUnidadesTransadas(), other.getUnidadesTransadas()) != 0) {
                            return false;
                        } else {
                            Object this$fechaCurse = this.getFechaCurse();
                            Object other$fechaCurse = other.getFechaCurse();
                            if (this$fechaCurse == null) {
                                if (other$fechaCurse != null) {
                                    return false;
                                }
                            } else if (!this$fechaCurse.equals(other$fechaCurse)) {
                                return false;
                            }
                            label217: {
                                Object this$fechaIngreso = this.getFechaIngreso();
                                Object other$fechaIngreso = other.getFechaIngreso();
                                if (this$fechaIngreso == null) {
                                    if (other$fechaIngreso == null) {
                                        break label217;
                                    }
                                } else if (this$fechaIngreso.equals(other$fechaIngreso)) {
                                    break label217;
                                }
                                return false;
                            }
                            Object this$fechaSolicitud = this.getFechaSolicitud();
                            Object other$fechaSolicitud = other.getFechaSolicitud();
                            if (this$fechaSolicitud == null) {
                                if (other$fechaSolicitud != null) {
                                    return false;
                                }
                            } else if (!this$fechaSolicitud.equals(other$fechaSolicitud)) {
                                return false;
                            }
                            label203: {
                                Object this$fechaPago = this.getFechaPago();
                                Object other$fechaPago = other.getFechaPago();
                                if (this$fechaPago == null) {
                                    if (other$fechaPago == null) {
                                        break label203;
                                    }
                                } else if (this$fechaPago.equals(other$fechaPago)) {
                                    break label203;
                                }
                                return false;
                            }
                            if (this.getRutEmpleadoEjecutivoConect() != other.getRutEmpleadoEjecutivoConect()) {
                                return false;
                            } else {
                                label195: {
                                    Object this$usuarioEjecutivoConectado = this.getUsuarioEjecutivoConectado();
                                    Object other$usuarioEjecutivoConectado = other.getUsuarioEjecutivoConectado();
                                    if (this$usuarioEjecutivoConectado == null) {
                                        if (other$usuarioEjecutivoConectado == null) {
                                            break label195;
                                        }
                                    } else if (this$usuarioEjecutivoConectado.equals(other$usuarioEjecutivoConectado)) {
                                        break label195;
                                    }
                                    return false;
                                }
                                if (this.getRutEmpleadoEjecutivoOperac() != other.getRutEmpleadoEjecutivoOperac()) {
                                    return false;
                                } else {
                                    label187: {
                                        Object this$observacion = this.getObservacion();
                                        Object other$observacion = other.getObservacion();
                                        if (this$observacion == null) {
                                            if (other$observacion == null) {
                                                break label187;
                                            }
                                        } else if (this$observacion.equals(other$observacion)) {
                                            break label187;
                                        }
                                        return false;
                                    }
                                    Object this$numeroDeOrden = this.getNumeroDeOrden();
                                    Object other$numeroDeOrden = other.getNumeroDeOrden();
                                    if (this$numeroDeOrden == null) {
                                        if (other$numeroDeOrden != null) {
                                            return false;
                                        }
                                    } else if (!this$numeroDeOrden.equals(other$numeroDeOrden)) {
                                        return false;
                                    }
                                    Object this$mensaje = this.getMensaje();
                                    Object other$mensaje = other.getMensaje();
                                    if (this$mensaje == null) {
                                        if (other$mensaje != null) {
                                            return false;
                                        }
                                    } else if (!this$mensaje.equals(other$mensaje)) {
                                        return false;
                                    }
                                    label166: {
                                        Object this$canal = this.getCanal();
                                        Object other$canal = other.getCanal();
                                        if (this$canal == null) {
                                            if (other$canal == null) {
                                                break label166;
                                            }
                                        } else if (this$canal.equals(other$canal)) {
                                            break label166;
                                        }
                                        return false;
                                    }
                                    if (this.getIdentificadorCanalAtencion() != other.getIdentificadorCanalAtencion()) {
                                        return false;
                                    } else {
                                        label158: {
                                            Object this$indicadorAvanzaAutomatico = this.getIndicadorAvanzaAutomatico();
                                            Object other$indicadorAvanzaAutomatico = other.getIndicadorAvanzaAutomatico();
                                            if (this$indicadorAvanzaAutomatico == null) {
                                                if (other$indicadorAvanzaAutomatico == null) {
                                                    break label158;
                                                }
                                            } else if (this$indicadorAvanzaAutomatico.equals(other$indicadorAvanzaAutomatico)) {
                                                break label158;
                                            }
                                            return false;
                                        }
                                        Object this$pIngresarInstruccions = this.getPIngresarInstruccions();
                                        Object other$pIngresarInstruccions = other.getPIngresarInstruccions();
                                        if (this$pIngresarInstruccions == null) {
                                            if (other$pIngresarInstruccions != null) {
                                                return false;
                                            }
                                        } else if (!this$pIngresarInstruccions.equals(other$pIngresarInstruccions)) {
                                            return false;
                                        }
                                        Object this$operacionMonedaExtranjera = this.getOperacionMonedaExtranjera();
                                        Object other$operacionMonedaExtranjera = other.getOperacionMonedaExtranjera();
                                        if (this$operacionMonedaExtranjera == null) {
                                            if (other$operacionMonedaExtranjera != null) {
                                                return false;
                                            }
                                        } else if (!this$operacionMonedaExtranjera.equals(other$operacionMonedaExtranjera)) {
                                            return false;
                                        }
                                        label137: {
                                            Object this$operacionFondosMutuos = this.getOperacionFondosMutuos();
                                            Object other$operacionFondosMutuos = other.getOperacionFondosMutuos();
                                            if (this$operacionFondosMutuos == null) {
                                                if (other$operacionFondosMutuos == null) {
                                                    break label137;
                                                }
                                            } else if (this$operacionFondosMutuos.equals(other$operacionFondosMutuos)) {
                                                break label137;
                                            }
                                            return false;
                                        }
                                        Object this$operacionAcciones = this.getOperacionAcciones();
                                        Object other$operacionAcciones = other.getOperacionAcciones();
                                        if (this$operacionAcciones == null) {
                                            if (other$operacionAcciones != null) {
                                                return false;
                                            }
                                        } else if (!this$operacionAcciones.equals(other$operacionAcciones)) {
                                            return false;
                                        }
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    protected boolean canEqual(Object other) {
        return other instanceof Ingope;
    }
    public int hashCode() {
        int PRIME = true;
        int result = 1;
        long $identificadorTransaccion = this.getIdentificadorTransaccion();
        int result = result * 59 + (int)($identificadorTransaccion >>> 32 ^ $identificadorTransaccion);
        Object $producto = this.getProducto();
        result = result * 59 + ($producto == null ? 43 : $producto.hashCode());
        Object $operacion = this.getOperacion();
        result = result * 59 + ($operacion == null ? 43 : $operacion.hashCode());
        result = result * 59 + this.getIdentificadorCliente();
        result = result * 59 + this.getCuentaInversion();
        Object $codigoMoneda = this.getCodigoMoneda();
        result = result * 59 + ($codigoMoneda == null ? 43 : $codigoMoneda.hashCode());
        result = result * 59 + Float.floatToIntBits(this.getMontoOperacionString());
        Object $correlativo = this.getCorrelativo();
        result = result * 59 + ($correlativo == null ? 43 : $correlativo.hashCode());
        result = result * 59 + Float.floatToIntBits(this.getUnidadesTransadas());
        Object $fechaCurse = this.getFechaCurse();
        result = result * 59 + ($fechaCurse == null ? 43 : $fechaCurse.hashCode());
        Object $fechaIngreso = this.getFechaIngreso();
        result = result * 59 + ($fechaIngreso == null ? 43 : $fechaIngreso.hashCode());
        Object $fechaSolicitud = this.getFechaSolicitud();
        result = result * 59 + ($fechaSolicitud == null ? 43 : $fechaSolicitud.hashCode());
        Object $fechaPago = this.getFechaPago();
        result = result * 59 + ($fechaPago == null ? 43 : $fechaPago.hashCode());
        result = result * 59 + this.getRutEmpleadoEjecutivoConect();
        Object $usuarioEjecutivoConectado = this.getUsuarioEjecutivoConectado();
        result = result * 59 + ($usuarioEjecutivoConectado == null ? 43 : $usuarioEjecutivoConectado.hashCode());
        result = result * 59 + this.getRutEmpleadoEjecutivoOperac();
        Object $observacion = this.getObservacion();
        result = result * 59 + ($observacion == null ? 43 : $observacion.hashCode());
        Object $numeroDeOrden = this.getNumeroDeOrden();
        result = result * 59 + ($numeroDeOrden == null ? 43 : $numeroDeOrden.hashCode());
        Object $mensaje = this.getMensaje();
        result = result * 59 + ($mensaje == null ? 43 : $mensaje.hashCode());
        Object $canal = this.getCanal();
        result = result * 59 + ($canal == null ? 43 : $canal.hashCode());
        result = result * 59 + this.getIdentificadorCanalAtencion();
        Object $indicadorAvanzaAutomatico = this.getIndicadorAvanzaAutomatico();
        result = result * 59 + ($indicadorAvanzaAutomatico == null ? 43 : $indicadorAvanzaAutomatico.hashCode());
        Object $pIngresarInstruccions = this.getPIngresarInstruccions();
        result = result * 59 + ($pIngresarInstruccions == null ? 43 : $pIngresarInstruccions.hashCode());
        Object $operacionMonedaExtranjera = this.getOperacionMonedaExtranjera();
        result = result * 59 + ($operacionMonedaExtranjera == null ? 43 : $operacionMonedaExtranjera.hashCode());
        Object $operacionFondosMutuos = this.getOperacionFondosMutuos();
        result = result * 59 + ($operacionFondosMutuos == null ? 43 : $operacionFondosMutuos.hashCode());
        Object $operacionAcciones = this.getOperacionAcciones();
        result = result * 59 + ($operacionAcciones == null ? 43 : $operacionAcciones.hashCode());
        return result;
    }
    public String toString() {
        return "Ingope(identificadorTransaccion=" + this.getIdentificadorTransaccion() + ", producto=" + this.getProducto() + ", operacion=" + this.getOperacion() + ", identificadorCliente=" + this.getIdentificadorCliente() + ", cuentaInversion=" + this.getCuentaInversion() + ", codigoMoneda=" + this.getCodigoMoneda() + ", montoOperacionString=" + this.getMontoOperacionString() + ", correlativo=" + this.getCorrelativo() + ", unidadesTransadas=" + this.getUnidadesTransadas() + ", fechaCurse=" + this.getFechaCurse() + ", fechaIngreso=" + this.getFechaIngreso() + ", fechaSolicitud=" + this.getFechaSolicitud() + ", fechaPago=" + this.getFechaPago() + ", rutEmpleadoEjecutivoConect=" + this.getRutEmpleadoEjecutivoConect() + ", usuarioEjecutivoConectado=" + this.getUsuarioEjecutivoConectado() + ", rutEmpleadoEjecutivoOperac=" + this.getRutEmpleadoEjecutivoOperac() + ", observacion=" + this.getObservacion() + ", numeroDeOrden=" + this.getNumeroDeOrden() + ", mensaje=" + this.getMensaje() + ", canal=" + this.getCanal() + ", identificadorCanalAtencion=" + this.getIdentificadorCanalAtencion() + ", indicadorAvanzaAutomatico=" + this.getIndicadorAvanzaAutomatico() + ", pIngresarInstruccions=" + this.getPIngresarInstruccions() + ", operacionMonedaExtranjera=" + this.getOperacionMonedaExtranjera() + ", operacionFondosMutuos=" + this.getOperacionFondosMutuos() + ", operacionAcciones=" + this.getOperacionAcciones() + ")";
    }
    public Ingope() {
    }*/
}

