package com.encomienda.entities;

import com.encomienda.entities.Ciudades;
import com.encomienda.entities.Clientes;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T07:14:28")
@StaticMetamodel(Encomienda.class)
public class Encomienda_ { 

    public static volatile SingularAttribute<Encomienda, String> descripcion;
    public static volatile SingularAttribute<Encomienda, Ciudades> idCiudadEmisor;
    public static volatile SingularAttribute<Encomienda, Clientes> idClienteReceptor;
    public static volatile SingularAttribute<Encomienda, Integer> id;
    public static volatile SingularAttribute<Encomienda, String> pesoEncomienda;
    public static volatile SingularAttribute<Encomienda, BigDecimal> valorEnvioEncomienda;
    public static volatile SingularAttribute<Encomienda, Ciudades> idCiudadReceptor;
    public static volatile SingularAttribute<Encomienda, Clientes> idClienteEmisor;

}