
package br.com.ordemDeServico.converter;

import br.com.ordemDeServico.model.StatusOs;
import br.com.ordemDeServico.model.StatusOsDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "statusOSConverter", forClass = StatusOs.class)
public class StatusOSConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0){
            Integer id = Integer.valueOf(value);
            StatusOsDAO osDAO = new StatusOsDAO();
            return osDAO.getByID(id);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            StatusOs status = (StatusOs) value;
            return status.getId().toString();
        }
        return null;
    }
    
}
