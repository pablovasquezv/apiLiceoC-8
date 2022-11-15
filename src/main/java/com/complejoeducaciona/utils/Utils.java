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

    public String imprimirLogEntrada(E e) {
        String jsonResponse = null;
        try {
            jsonResponse = objectMapper.writeValueAsString(e);
        } catch (JsonProcessingException ex) {
            log.error("Ocurrio un Error =>" + e);
        }
        return jsonResponse;
    }

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
     * Función encargada de castera un Objeto a BigDecimal
     *
     * @param objACastear
     * @return BigDecimal
     */
    public static BigDecimal castBigDecimal(Object objACastear){
        BigDecimal value = new BigDecimal(0);
        try {
            if(objACastear instanceof BigDecimal){
                value =  BigDecimal.valueOf(Long.valueOf(objACastear.toString()));
            }else if(objACastear instanceof  String){
                if(objACastear.equals("") || ((String) objACastear).isEmpty()){
                    objACastear="0";
                }
                value = BigDecimal.valueOf(Double.parseDouble(objACastear.toString()));
            }else if(objACastear instanceof Integer){
                Integer integer = Integer.valueOf(objACastear.toString());
                value = BigDecimal.valueOf(integer);
            }else if(objACastear instanceof Float){
                Float numberFloat = Float.valueOf(objACastear.toString());
                value = BigDecimal.valueOf(numberFloat);
            }else if(objACastear instanceof Double){
                Double numberDouble= Double.valueOf(objACastear.toString());
                value = BigDecimal.valueOf(numberDouble);
            }
        }catch (Exception e){
            log.error("Ocurrio un error en castBigDecimal =>",e);
        }
        return value;
    }
}
