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
@Document(collection="client")
public class Client {

    /** Identificador del Cliente */
    @Id
    private String id;

    /** Código de Cliente */
    private String code;

    /** Nombre de Cliente */
    private String name;

    /** Código de Tipo de Documento */
    private String codeDocumentType;

    /** Número de Documento */
    private String documentNumber;

    /** Código de Tipo de Cliente */
    private String codeClientType;

    /** Número de Teléfono */
    private String phoneNumber;

    /** Correo Electrónico */
    private String email;

    /** Estado del registro */
    private boolean state;

}
