
package br.com.ordemDeServico.converter;

import br.com.ordemDeServico.model.CargoFuncionario;
import br.com.ordemDeServico.model.CargoFuncionarioDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cargoConverter", forClass = CargoFuncionario.class)
public class CargoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0){
            Integer codigo = Integer.valueOf(value);
            CargoFuncionarioDAO cargoDAO = new CargoFuncionarioDAO();
            return cargoDAO.getByID(codigo);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            CargoFuncionario cargo = (CargoFuncionario) value;
            return cargo.getId().toString();
        }
        return null;
    }
    
}
