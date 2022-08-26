/**
 * Resumen.
 * Objeto                   : ClientTypeService.java
 * Descripción              : Clase para los métodos de la interface de servicio del tipo de cliente.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.client.service;

import com.nttdata.bootcamp.client.model.document.ClientType;
import reactor.core.publisher.Mono;

/**
 * Clase para los métodos de la interface de servicio del tipo de cliente.
 */
public interface ClientTypeService extends GenericService<ClientType, String> {

    /**
     * Método que obtiene los datos del document ClientType
     * @return Mono retorna el ClientType, tipo Mono
     */
    Mono<ClientType> findByCode(String code);
}
