
package br.com.ordemDeServico.converter;

import br.com.ordemDeServico.model.Categoria;
import br.com.ordemDeServico.model.CategoriaDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "categoriaConverter", forClass = Categoria.class)
public class CategoriaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0){
            Integer codigo = Integer.valueOf(value);
            CategoriaDAO categoraDAO = new CategoriaDAO();
            return categoraDAO.getById(codigo);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            Categoria cat = (Categoria) value;
            return cat.getId().toString();
        }
        return null;
    }
    
}
