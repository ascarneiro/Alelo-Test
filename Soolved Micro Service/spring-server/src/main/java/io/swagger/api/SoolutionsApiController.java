package io.swagger.api;

import io.swagger.model.Bug;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.model.SoolutionRepository;
import io.swagger.model.Soolution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-04-18T16:20:25.506Z")

@Controller
public class SoolutionsApiController implements SoolutionsApi {

    @Autowired
    SoolutionRepository soolutionRepository;

    private static final Logger log = LoggerFactory.getLogger(SoolutionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private boolean isValidJson(HttpServletRequest request) {
        String header = request.getHeader("Accept");
        return header != null && header.contains("application/json");
    }

    @org.springframework.beans.factory.annotation.Autowired
    public SoolutionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> add(@ApiParam(value = "Soolution a cadastrar") @Valid @RequestBody Soolution soolution) {
        if (isValidJson(request)) {
            soolutionRepository.save(soolution);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Void> delete(@ApiParam(value = "Soolution a remover") @Valid @RequestBody Soolution soolution) {
        if (isValidJson(request)) {
            soolutionRepository.delete(soolution.getId());
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Soolution>> find(@ApiParam(value = "Bug a pesquisar por Soolution") @Valid @RequestBody Bug bug) {
        if (isValidJson(request)) {


            List<Soolution> soolutions = soolutionRepository.findAll().stream()
                    .filter(soolution -> soolution.getDescription().
                            contains(bug.getCausa())).collect(Collectors.toList());
            if (soolutions != null
                    || soolutions.isEmpty()) {
                soolutions = soolutionRepository.findAll().stream()
                        .filter(soolution -> soolution.getCausa().
                                contains(bug.getCausa())).collect(Collectors.toList());
            }


            HttpStatus status = HttpStatus.BAD_REQUEST;
            if (soolutions != null
                    && !soolutions.isEmpty()) {
                status = HttpStatus.OK;
            }

            ResponseEntity response = new ResponseEntity(soolutions, status);
            return response;
        }
        return new ResponseEntity<List<Soolution>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Void> update(@ApiParam(value = "Soolution a atualizar") @Valid @RequestBody Soolution soolution) {
        if (isValidJson(request)) {

            Soolution registro = soolutionRepository.findOne(soolution.getId());
            registro.setDescription(soolution.getDescription());
            registro.setCausa(soolution.getCausa());
            registro.setSolution(soolution.getSolution());
            registro.setStatus(soolution.getStatus());
            Soolution updated = soolutionRepository.save(registro);
            if (updated != null) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
}
