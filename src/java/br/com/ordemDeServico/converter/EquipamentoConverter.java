package br.com.ordemDeServico.converter;

import br.com.ordemDeServico.model.Equipamento;
import br.com.ordemDeServico.model.EquipamentoDAO;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "equipamentoConverter", forClass = Equipamento.class)
public class EquipamentoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value != null && value.trim().length() > 0) {
            Integer cod = Integer.valueOf(value);
            EquipamentoDAO eqpDAO = new EquipamentoDAO();
            return eqpDAO.getByID(cod);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Equipamento eqp = (Equipamento) value;
            return eqp.getId().toString();
        }
        return null;
    }

}
