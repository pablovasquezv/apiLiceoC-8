package com.complejoeducaciona.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.regex.Pattern;

@Component
@Slf4j
public class Utils<E> {
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Función encargada de imprimir un Json de salida.
     *
     * @param e
     * @return jsonResponse
     */
    public String imprimirLogEntrada(E e) {
        String jsonResponse = null;
        try {
            jsonResponse = objectMapper.writeValueAsString(e);
        } catch (JsonProcessingException ex) {
            log.error("Ocurrio un Error =>" + e);
        }
        return jsonResponse;
    }

    /**
     * Función encargada de imprimir un Json de salida.
     *
     * @param e
     * @return jsonResponse
     */
    public String imprimirLogSalida(E e) {
        String jsonResponse = null;
        try {
            jsonResponse = objectMapper.writeValueAsString(e);
        } catch (JsonProcessingException ex) {
            log.error("Ocurrio un Error =>" + e);
        }
        return jsonResponse;
    }

    /**
     * Función encargada de Limpiar un xml
     *
     * @param xml
     * @return xml
     */
    public static String removeChildEmpty(String xml) {
        Pattern emptyValueTag = Pattern.compile("\\s*<\\w+/>");
        Pattern emptyTagMultiLine = Pattern.compile("\\s*<\\w+>\n*\\s*</\\w+>");
        xml = emptyValueTag.matcher(xml).replaceAll("");
        while (xml.length() != (xml = emptyTagMultiLine.matcher(xml).replaceAll("")).length()) {
        }
        return xml;
    }

    /**
     * Función encargada de castera un Objeto a tipo de dato por referencia a BigDecimal
     *
     * @param objACastear
     * @return BigDecimal
     */
    public static BigDecimal castBigDecimal(Object objACastear) {
        BigDecimal value = new BigDecimal(0);
        try {
            /*instanceof: verifica que contiene la variable objACastear
             * SI el objACastear contiene un dato Short
             */
            if (objACastear instanceof BigDecimal) {
                value = BigDecimal.valueOf(Long.valueOf(objACastear.toString()));
            } else if (objACastear instanceof String) {
                if (objACastear.equals("") || ((String) objACastear).isEmpty()) {
                    objACastear = "0";
                }
                value = BigDecimal.valueOf(Double.parseDouble(objACastear.toString()));
            } else if (objACastear instanceof Integer) {
                Integer integer = Integer.valueOf(objACastear.toString());
                value = BigDecimal.valueOf(integer);
            } else if (objACastear instanceof Float) {
                Float numberFloat = Float.valueOf(objACastear.toString());
                value = BigDecimal.valueOf(numberFloat);
            } else if (objACastear instanceof Double) {
                Double numberDouble = Double.valueOf(objACastear.toString());
                value = BigDecimal.valueOf(numberDouble);
            }
        } catch (Exception e) {
            log.error("Ocurrio un error en castBigDecimal =>", e);
        }
        return value;
    }

    /**
     * Función encargada de castera un Objeto a tipo de dato por referencia a Long
     *
     * @param objACastear
     * @return Long
     */
    public static Long castLong(Object objACastear) {
        Long value = 0L;
        try {
            /*instanceof: verifica que contiene la variable objACastear
             * SI el objACastear contiene un dato Short
             */
            if (objACastear instanceof Long) {
                value = Long.valueOf(objACastear.toString());
            } else if (objACastear instanceof String) {
                if (("").equals(objACastear) || ((String) objACastear).isEmpty()) {
                    objACastear = "0";
                }
                value = Long.valueOf(objACastear.toString());
            } else if (objACastear instanceof Integer) {
                Integer integer = Integer.valueOf(objACastear.toString());
                value = Long.valueOf(integer);
            } else if (objACastear instanceof Float) {
                value = Long.valueOf(objACastear.toString());
            } else if (objACastear instanceof Byte) {
                value = Long.valueOf(objACastear.toString());
            }
        } catch (NumberFormatException e) {
            log.error("Ocurrio un error en castLong => ", e);
        }
        return value;
    }

    /**
     * Función encargada de castera un Objeto a tipo de dato por referencia Integer
     * Object: permite recibir cualquiere clase.
     *
     * @param objACastear
     * @return Integer
     */
    public static Integer castInteger(Object objACastear) {
        Integer value = 0;
        try {
            /*instanceof: verifica que contiene la variable objACastear
             * SI el objACastear contiene un dato Short
             */
            if (objACastear instanceof Long) {
                value = Integer.valueOf(objACastear.toString());
            } else if (objACastear instanceof String) {
                if (("").equals(objACastear) || ((String) objACastear).isEmpty()) {
                    objACastear = "0";
                }
                value = Integer.valueOf(objACastear.toString());
            } else if (objACastear instanceof Integer) {
                value = Integer.valueOf(objACastear.toString());
            }
        } catch (NumberFormatException e) {
            log.error("Ocurrio un error en castInteger => ", e);
        }
        return value;
    }

    /**
     * Función encargada de castera un Objeto a tipo de dato por referencia Byte
     * Object: permite recibir cualquiere clase.
     *
     * @param objACastear
     * @return Byte
     */
    public static Byte castByte(Object objACastear) {
        Byte value = 0;
        try {
            /*instanceof: verifica que contiene la variable objACastear
             * SI el objACastear contiene un dato Short
             */
            if (objACastear instanceof Byte) {
                value = Byte.valueOf(objACastear.toString());
            } else if (objACastear instanceof String) {
                if (("").equals(objACastear) || ((String) objACastear).isEmpty()) {
                    objACastear = "0";
                }
                value = Byte.valueOf(objACastear.toString());
            } else if (objACastear instanceof Integer) {
                value = Byte.valueOf(objACastear.toString());
            }
        } catch (NumberFormatException e) {
            log.error("Ocurrio un error en castByte => ", e);
        }
        return value;
    }

    /**
     * Función encargada de castera un Objeto a tipo de dato por referencia String
     * Object: permite recibir cualquiere clase.
     *
     * @param objACastear
     * @return String
     */
    public static String castString(Object objACastear) {
        String value = "";
        try {
            value = objACastear.toString();
        } catch (RuntimeException e) {
            log.error("Ocurrio un error en castString => ", e);
        }
        return value;
    }

    /**
     * Función encargada de castera un Objeto a tipo de dato por referencia Short
     * Object: permite recibir cualquiere clase.
     *
     * @param objACastear
     * @return Short
     */
    public static Short castShort(Object objACastear) {
        Short value = 0;
        try {
            /*instanceof: verifica que contiene la variable objACastear
             * SI el objACastear contiene un dato Short
             */
            if (objACastear instanceof Short) {
                value = Short.valueOf(objACastear.toString());
            } else if (objACastear instanceof String) {
                if (("").equals(objACastear) || ((String) objACastear).isEmpty()) {
                    objACastear = "0";
                }
                value = Short.valueOf(objACastear.toString());
            } else if (objACastear instanceof Integer) {
                value = Short.valueOf(objACastear.toString());
            }
        } catch (NumberFormatException e) {
            log.error("Ocurrio un error en castShort => ", e);
        }
        return value;
    }

    /**
     * Función encargada de castera un Objeto a tipo de dato por referencia Float
     * Object: permite recibir cualquiere clase.
     *
     * @param objACastear
     * @return Float
     */
    public static Float castFloat(Object objACastear) {
        Float value = 0.0F;
        try {
            value = Float.parseFloat(objACastear.toString());
        } catch (NumberFormatException e) {
            log.error("Ocurrio un error en castFloat => ", e);
        }
        return value;
    }
}
