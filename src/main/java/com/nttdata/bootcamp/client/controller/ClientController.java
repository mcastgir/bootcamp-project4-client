/**
 * Resumen.
 * Objeto                   : ClientController.java
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

import com.nttdata.bootcamp.client.model.document.Client;
import com.nttdata.bootcamp.client.service.ClientService;
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
@RequestMapping("/api/clients")
public class ClientController {

    /** Declaración de la clase service */
    @Autowired
    private ClientService clientService;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el Client, tipo Mono
     */
    @PostMapping
    public Mono<ResponseEntity<Client>> create(@RequestBody Client client){
        return this.clientService.insert(client)
                .map(c -> new ResponseEntity<>(c, HttpStatus.OK));
    }


    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el Client, tipo Mono
     */
    @PutMapping
    public Mono<ResponseEntity<Client>> update(@RequestBody Client client){
        return this.clientService.update(client)
                .map(c -> new ResponseEntity<>(c, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return this.clientService.delete(id)
                .map(v -> new ResponseEntity<>(v, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el Client, tipo String
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Client>> find(@PathVariable String id) {
        return this.clientService.find(id)
                .map(client -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(client));
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el Client, tipo String
     */
    @GetMapping("/findByCode/{code}")
    public Mono<ResponseEntity<Client>> findByCode(@PathVariable String code) {
        return this.clientService.findByCode(code)
                .map(client -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(client));
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el Client, tipo Flux
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<Client>>> findAll() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(this.clientService.findAll())
        );
    }

}
