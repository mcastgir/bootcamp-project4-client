/**
 * Resumen.
 * Objeto                   : ClientService.java
 * Descripción              : Clase para los métodos de la interface de servicio del cliente.
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

import com.nttdata.bootcamp.client.model.document.Client;
import reactor.core.publisher.Mono;

/**
 * Clase para los métodos de la interface de servicio del cliente.
 */
public interface ClientService extends GenericService<Client, String> {

    /**
     * Método que obtiene los datos del document Client
     * @return Mono retorna el Client, tipo Mono
     */
    Mono<Client> findByCode(String code);
}
