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
package it.engim.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author svilupposw
 */
@Entity
@Table(name = "voci")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voci.findAll", query = "SELECT v FROM Voci v"),
    @NamedQuery(name = "Voci.findById", query = "SELECT v FROM Voci v WHERE v.id = :id"),
    @NamedQuery(name = "Voci.findByQuantita", query = "SELECT v FROM Voci v WHERE v.quantita = :quantita")})
public class Voci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantita")
    private Integer quantita;
    @JoinColumn(name = "id_ordini", referencedColumnName = "id")
    @ManyToOne
    private Ordini idOrdini;
    @JoinColumn(name = "id_articoli", referencedColumnName = "id")
    @ManyToOne
    private Articoli idArticoli;

    public Voci() {
    }

    public Voci(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public Ordini getIdOrdini() {
        return idOrdini;
    }

    public void setIdOrdini(Ordini idOrdini) {
        this.idOrdini = idOrdini;
    }

    public Articoli getIdArticoli() {
        return idArticoli;
    }

    public void setIdArticoli(Articoli idArticoli) {
        this.idArticoli = idArticoli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voci)) {
            return false;
        }
        Voci other = (Voci) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.engim.beans.Voci[ id=" + id + " ]";
    }
    
}
