package frbouhadjacheurfarobardet.entities;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.entities.Creneau;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-29T15:47:13")
@StaticMetamodel(RdvCommercial.class)
public class RdvCommercial_ { 

    public static volatile SingularAttribute<RdvCommercial, Creneau> creneau;
    public static volatile SingularAttribute<RdvCommercial, Long> idCommercial;
    public static volatile SingularAttribute<RdvCommercial, Affaire> affaire;
    public static volatile SingularAttribute<RdvCommercial, Long> id;

}