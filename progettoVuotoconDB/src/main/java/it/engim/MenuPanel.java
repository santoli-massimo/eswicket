
package it.engim;

import org.apache.wicket.core.request.handler.BookmarkableListenerInterfaceRequestHandler;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author svilupposw
 */
public class MenuPanel extends Panel{
    
    public MenuPanel(String id) {
        
        super(id);
        
        BookmarkablePageLink home = new BookmarkablePageLink("home", HomePage.class);
        BookmarkablePageLink articoli = new BookmarkablePageLink("articoli", ElencoArticoli.class);
        BookmarkablePageLink tariffeCorriere = new BookmarkablePageLink("tariffeCorriere", ElencoTariffeCorriere.class);
        BookmarkablePageLink ordini = new BookmarkablePageLink("ordini", ElencoOrdini.class);
        
        add(home);
        add(articoli);
        add(tariffeCorriere);
        add(ordini);
        
    }
    
}
