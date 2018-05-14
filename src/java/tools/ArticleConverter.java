/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashMap;
import java.util.Map;
import javabeans.Article;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("articleConverter")
public class ArticleConverter implements Converter {

    private static final String key = "forum.tools.ArticleConverter";
    private static final String empty = "";

    private Map<String, Object> getViewMap(FacesContext context) {
        Map<String, Object> viewMap = context.getViewRoot().getViewMap();
        @SuppressWarnings({"unchecked", "rawtypes"})
        Map<String, Object> idMap = (Map) viewMap.get(key);
        if (idMap == null) {
            idMap = new HashMap<String, Object>();
            viewMap.put(key, idMap);
        }
        return idMap;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent c, String value) {
        if (value.isEmpty()) {
            return null;
        }
        return getViewMap(context).get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent c, Object value) {
        if (value == null) {
            return empty;
        }
        //REMPLACER ICI Article PAR LE BON OBJET A CONVERTIR
        String id = String.valueOf(((Article) value).getId());
        getViewMap(context).put(id, value);
        return id;
    }
}
