/**
 * Resumen.
 * Objeto                   : ClientServiceImpl.java
 * Descripción              : Clase para los métodos de la implementación de servicio del tipo de cliente.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.client.service.impl;

import com.nttdata.bootcamp.client.model.dao.ClientTypeDao;
import com.nttdata.bootcamp.client.model.document.ClientType;
import com.nttdata.bootcamp.client.service.ClientTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase para los métodos de la implementación de servicio del tipo de cliente.
 */
@Service
public class ClientTypeServiceImpl implements ClientTypeService {

    /** Declaración de la variable de log */
    private static final Logger log = LoggerFactory.getLogger(ClientTypeServiceImpl.class);

    /** Declaración de la clase dao */
    @Autowired
    private ClientTypeDao clientTypeDao;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el ClientType, tipo Mono
     */
    @Override
    public Mono<ClientType> insert(ClientType clientType) {
        return clientTypeDao.save(clientType)
                .doFirst(() -> log.info("Begin Insert ClientType"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Insert ClientType"));
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el ClientType, tipo Mono
     */
    @Override
    public Mono<ClientType> update(ClientType clientType) {
        return clientTypeDao.findById(clientType.getId())
                .doFirst(() -> log.info("Begin Update ClientType"))
                .map(c -> clientType)
                .flatMap(this.clientTypeDao::save)
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Update ClientType"));
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @Override
    public Mono<Void> delete(String id) {
        return clientTypeDao.deleteById(id)
                .doFirst(() -> log.info("Begin Delete ClientType"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Delete ClientType"));
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el ClientType, tipo String
     */
    @Override
    public Mono<ClientType> find(String id) {
        return clientTypeDao.findById(id)
                .doFirst(() -> log.info("Begin Find ClientType"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Find ClientType"));
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el ClientType, tipo String
     */
    @Override
    public Mono<ClientType> findByCode(String code) {
        return clientTypeDao.findByCode(code)
                .doFirst(() -> log.info("Begin FindByCode ClientType"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish FindByCode ClientType"));
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Mono retorna el ClientType, tipo String
     */
    @Override
    public Flux<ClientType> findAll() {
        return clientTypeDao.findAll()
                .doFirst(() -> log.info("Begin FindAll ClientType"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish FindAll ClientType"));
    }

}
