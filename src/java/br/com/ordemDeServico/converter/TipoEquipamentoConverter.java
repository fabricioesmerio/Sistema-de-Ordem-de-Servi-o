
package br.com.ordemDeServico.converter;

import br.com.ordemDeServico.model.TipoEquipamento;
import br.com.ordemDeServico.model.TipoEquipamentoDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tipoEquipamentoConverter", forClass = TipoEquipamento.class)
public class TipoEquipamentoConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0){
            Integer codigo = Integer.valueOf(value);
            TipoEquipamentoDAO tipoEqpDAO = new TipoEquipamentoDAO();
            return tipoEqpDAO.getById(codigo);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            TipoEquipamento tipo = (TipoEquipamento) value;
            return tipo.getId().toString();
        }
        return null;
    }
}
