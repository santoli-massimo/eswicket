
package it.engim;

import it.engim.*;
import it.engim.beans.Articoli;
import java.util.ArrayList;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

public class ElencoArticoli extends WebPage {
    
    public ElencoArticoli()
    {
        ArrayList<IColumn<Articoli, String>> colonne
                = new ArrayList<IColumn<Articoli, String>>();
        
        colonne.add(new PropertyColumn<Articoli, String>
            (Model.of("CODICE"),"codice"));
        colonne.add(new PropertyColumn<Articoli, String>
            (Model.of("DESCRIZIONE"),"descrizione"));
        colonne.add(new PropertyColumn<Articoli, String>
            (Model.of("PESO"),"peso"));
        
        add(new DefaultDataTable<Articoli, String>(
            "articoli",colonne,
            new ArticoliDataProvider(),11));
        
        add(new MenuPanel("menu"));
    }
    
}
