package com.hsuan.ecommerce.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.hsuan.ecommerce.annotation.MaskData;

public class MaskingFilter extends SimpleBeanPropertyFilter {

    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer) throws Exception {
        // Check if the field has the @MaskData annotation
        MaskData maskData = writer.getAnnotation(MaskData.class);

        if (maskData != null && writer instanceof BeanPropertyWriter) {
            // Get the value of the field
            Object value = ((BeanPropertyWriter) writer).get(pojo);
            if (value instanceof String) {
                String maskedValue = maskValue((String) value, maskData.unmaskedLength());
                // Write the masked value
                jgen.writeStringField(writer.getName(), maskedValue);
                return;
            }
        }

        // If no masking is needed, write the field as usual
        writer.serializeAsField(pojo, jgen, provider);
    }

    private String maskValue(String value, int unmaskedLength) {
        // Mask all characters except the last 'unmaskedLength' characters
        if (value != null && value.length() > unmaskedLength) {
            return value.replaceAll(".(?=.{"+ unmaskedLength +"})", "X");
        }
        return value;
    }
}
