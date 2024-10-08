package com.hsuan.ecommerce.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hsuan.ecommerce.annotation.MaskData;

import java.io.IOException;

public class MaskDataSerializer extends JsonSerializer<String> implements ContextualSerializer {

    private int unmaskedLength = 4;  // Default to 4 characters

    public MaskDataSerializer() {
        // Default constructor
    }

    public MaskDataSerializer(int unmaskedCharacters) {
        this.unmaskedLength = unmaskedCharacters;
    }

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String maskedValue = maskValue(value, unmaskedLength);
        gen.writeString(maskedValue);
    }

    // This method will be called to find the annotation and configure the serializer
    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        MaskData maskData = property != null ? property.getAnnotation(MaskData.class) : null;

        if (maskData != null) {
            // Return a new instance of MaskDataSerializer with the unmaskedCharacters parameter from the annotation
            return new MaskDataSerializer(maskData.unmaskedLength());
        }

        // Return the default instance if no annotation is present
        return this;
    }

    private String maskValue(String value, int unmaskedLength) {
        if (value == null || value.length() <= unmaskedLength) {
            return value; // Return as is if the length is shorter than the number of unmasked characters
        }
        // Mask all characters except the last 'unmaskedLength'
        return value.replaceAll(".(?=.{"+ unmaskedLength +"})", "X");
    }
}
