
package br.com.ordemDeServico.converter;

import br.com.ordemDeServico.model.Fornecedor;
import br.com.ordemDeServico.model.FornecedorDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "fornecedorConverter", forClass = Fornecedor.class)
public class FornecedorConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0){
            Integer codigo = Integer.valueOf(value);
            FornecedorDAO fornDAO = new FornecedorDAO();
            return fornDAO.getById(codigo);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            Fornecedor forn = (Fornecedor) value;
            return forn.getId().toString();
        }
        return null;
    }
    
}
