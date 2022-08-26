/**
 * Resumen.
 * Objeto                   : ClientServiceImpl.java
 * Descripción              : Clase para los métodos de la implementación de servicio del cliente.
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

import com.nttdata.bootcamp.client.model.dao.ClientDao;
import com.nttdata.bootcamp.client.model.document.Client;
import com.nttdata.bootcamp.client.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase para los métodos de la implementación de servicio del cliente.
 */
@Service
public class ClientServiceImpl implements ClientService {

    /** Declaración de la variable de log */
    private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    /** Declaración de la clase dao */
    @Autowired
    private ClientDao clientDao;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el Client, tipo Mono
     */
    @Override
    public Mono<Client> insert(Client client) {
        return clientDao.save(client)
                .doFirst(() -> log.info("Begin Insert Client"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Insert Client"));
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el Client, tipo Mono
     */
    @Override
    public Mono<Client> update(Client client) {
        return clientDao.findById(client.getId())
                .doFirst(() -> log.info("Begin Update Client"))
                .map(c -> client)
                .flatMap(this.clientDao::save)
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Update Client"));
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @Override
    public Mono<Void> delete(String id) {
        return clientDao.deleteById(id)
                .doFirst(() -> log.info("Begin Delete Client"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Delete Client"));
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el Client, tipo String
     */
    @Override
    public Mono<Client> find(String id) {
        return clientDao.findById(id)
                .doFirst(() -> log.info("Begin Find Client"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish Find Client"));
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el Client, tipo String
     */
    @Override
    public Mono<Client> findByCode(String code) {
        return clientDao.findByCode(code)
                .doFirst(() -> log.info("Begin FindByCode Client"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish FindByCode Client"));
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Mono retorna el Client, tipo String
     */
    @Override
    public Flux<Client> findAll() {
        return clientDao.findAll()
                .doFirst(() -> log.info("Begin FindAll Client"))
                .doOnNext(c -> log.info(c.toString()))
                .doAfterTerminate(() -> log.info("Finish FindAll Client"));
    }

}
