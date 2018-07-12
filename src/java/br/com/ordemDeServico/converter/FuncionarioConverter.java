
package br.com.ordemDeServico.converter;

import br.com.ordemDeServico.model.Funcionario;
import br.com.ordemDeServico.model.FuncionarioDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "funcionarioConverter", forClass = Funcionario.class)
public class FuncionarioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String codigoString) {
        if(codigoString != null && codigoString.trim().length() > 0){
            Integer codigo = Integer.valueOf(codigoString);
            FuncionarioDAO funcioDAO = new FuncionarioDAO();
            return funcioDAO.getById(codigo);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object funcionarioObjeto) {
        if(funcionarioObjeto != null){
            Funcionario funcionario = (Funcionario) funcionarioObjeto;
            return funcionario.getId().toString();
        }
        return null;
    }
    
}
