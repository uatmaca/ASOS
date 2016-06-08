package com.asos.core.beanconverter;

import com.asos.core.bo.ProductBO;
import com.asos.core.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Umut on 22.2.2016.
 */
@Service
@ManagedBean(name = "productConverter")
@FacesConverter(forClass=Product.class)
public class ProductConverter implements Converter{

    @Autowired
    private ProductBO productBO;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uıComponent, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            return productBO.getProductById(Long.parseLong(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid User ID"));
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uıComponent, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Product) {
            return String.valueOf(((Product) modelValue).getProductId());
        } else {
            throw new ConverterException(new FacesMessage(modelValue + "is not a valid User entity"));
        }
    }


}
