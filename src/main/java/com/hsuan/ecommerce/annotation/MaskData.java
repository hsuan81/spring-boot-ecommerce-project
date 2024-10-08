package com.hsuan.ecommerce.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hsuan.ecommerce.serializer.MaskDataSerializer;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonSerialize(using = MaskDataSerializer.class)
public @interface MaskData {
    /**
     * Specify how many characters from the end should remain unmasked.
     * Default is 4 characters.
     */
    int unmaskedLength() default 4;
}
