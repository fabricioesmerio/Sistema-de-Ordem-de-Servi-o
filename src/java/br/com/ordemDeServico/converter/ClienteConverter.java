package br.com.ordemDeServico.converter;

import br.com.ordemDeServico.model.Cliente;
import br.com.ordemDeServico.model.ClienteDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "clienteConverter", forClass = Cliente.class)
public class ClienteConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            Integer cod = Integer.valueOf(value);
            ClienteDAO cliDAO = new ClienteDAO();
            return cliDAO.getById(cod);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Cliente cli = (Cliente) value;
            return cli.getId().toString();
        }
        return null;
    }

}
