/**
 * Resumen.
 * Objeto                   : Client.java
 * Descripción              : Clase de tipo document para obtener o establecer los datos de cada atributo.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un campo nuevo.
 */

package com.nttdata.bootcamp.client.model.document;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de tipo document para obtener o establecer los datos de cada atributo.
 */
@Data
@ToString
@Document(collection="legal_representative")
public class LegalRepresentative {

    /** Identificador de la relación del Representante Legal con Cliente */
    @Id
    private String id;

    /** Código de la relación del Representante Legal con Cliente */
    /*private String code;*/

    /** Código del Cliente */
    private String codeClient;

    /** Código de la Persona */
    private String codePerson;

    /** Estado del registro */
    private boolean state;

}