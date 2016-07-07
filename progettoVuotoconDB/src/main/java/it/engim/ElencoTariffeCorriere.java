
package it.engim;

import it.engim.*;
import it.engim.beans.TariffeCorriere;
import java.util.ArrayList;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

public class ElencoTariffeCorriere extends WebPage {
    
    public ElencoTariffeCorriere()
    {
        ArrayList<IColumn<TariffeCorriere, String>> colonne
                = new ArrayList<IColumn<TariffeCorriere, String>>();
        
        colonne.add(new PropertyColumn<TariffeCorriere, String>
            (Model.of("Nome corriere"),"nomeCorriere"));
        colonne.add(new PropertyColumn<TariffeCorriere, String>
            (Model.of("Nome tariffa"),"nomeTariffa"));
        colonne.add(new PropertyColumn<TariffeCorriere, String>
            (Model.of("Peso"),"pesoMassimo"));
        colonne.add(new PropertyColumn<TariffeCorriere, String>
            (Model.of("Costo"),"costo"));
        
        add(new DefaultDataTable<TariffeCorriere, String>(
            "tariffeCorriere",colonne,
            new TariffeCorriereDataProvider(),11));
        
        add(new MenuPanel("menu"));
    }
    
}
