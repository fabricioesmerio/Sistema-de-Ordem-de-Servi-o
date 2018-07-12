
package br.com.ordemDeServico.converter;


import br.com.ordemDeServico.model.StatusFuncionario;
import br.com.ordemDeServico.model.StatusFuncionarioDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter (value = "statusFuncionarioConverter", forClass = StatusFuncionario.class)
public class StatusFuncionarioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0){
            Integer codigo = Integer.valueOf(value);
            StatusFuncionarioDAO statusDAO = new StatusFuncionarioDAO();
            return statusDAO.getByID(codigo);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            StatusFuncionario status = (StatusFuncionario) value;
            return status.getId().toString();
        }
        return null;
    }
    
}
