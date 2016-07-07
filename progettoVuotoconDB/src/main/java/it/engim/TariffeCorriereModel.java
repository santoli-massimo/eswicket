/*
 * Copyright 2016 svilupposw.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.engim;


import it.engim.*;
import it.engim.beans.TariffeCorriere;
import javax.persistence.EntityManager;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author svilupposw
 */
public class TariffeCorriereModel extends LoadableDetachableModel<TariffeCorriere>{

    private int id;
    
    public TariffeCorriereModel(int id){
    
    this.id = id;
        
    }
    
    @Override
    protected TariffeCorriere load() {
        
        //Carica un cliente dal db
        EntityManager em = PM.getEM();
        try
        {
        
            TariffeCorriere l = em.find(TariffeCorriere.class, id);
            return l;
        
        }
        finally
        
        {    
            em.close();
        
        }
        
        
    }

    
}
