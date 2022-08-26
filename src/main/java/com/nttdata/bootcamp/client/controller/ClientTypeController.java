/**
 * Resumen.
 * Objeto                   : ClientTypeController.java
 * Descripción              : Clase de controladora para invocar a métodos CRUD con rest api.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.client.controller;

import com.nttdata.bootcamp.client.model.document.ClientType;
import com.nttdata.bootcamp.client.service.ClientTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controladora para invocar a métodos CRUD con rest api.
 */
@RestController
@RequestMapping("/api/clienttypes")
public class ClientTypeController {

    /** Declaración de la clase service */
    @Autowired
    private ClientTypeService clientTypeService;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el ClientType, tipo Mono
     */
    @PostMapping
    public Mono<ResponseEntity<ClientType>> create(@RequestBody ClientType clientType){
        return this.clientTypeService.insert(clientType)
                .map(c -> new ResponseEntity<>(c, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el ClientType, tipo Mono
     */
    @PutMapping
    public Mono<ResponseEntity<ClientType>> update(@RequestBody ClientType clientType){
        return this.clientTypeService.update(clientType)
                .map(c -> new ResponseEntity<>(c, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return this.clientTypeService.delete(id)
                .map(v -> new ResponseEntity<>(v, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el ClientType, tipo String
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<ClientType>> find(@PathVariable String id) {
        return this.clientTypeService.find(id)
                .map(clientType -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(clientType));
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el ClientType, tipo String
     */
    @GetMapping("/findByCode/{code}")
    public Mono<ResponseEntity<ClientType>> findByCode(@PathVariable String code) {
        return this.clientTypeService.findByCode(code)
                .map(clientType -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(clientType));
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el ClientType, tipo Flux
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<ClientType>>> findAll() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(this.clientTypeService.findAll())
        );
    }

}
