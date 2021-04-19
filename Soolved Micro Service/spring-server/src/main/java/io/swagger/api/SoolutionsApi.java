package io.swagger.api;

import io.swagger.model.Bug;
import io.swagger.annotations.*;
import io.swagger.model.Soolution;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-04-18T16:20:25.506Z")

@Validated
@Api(value = "soolutions", description = "the soolutions API")
@RequestMapping(value = "/ascarneiro/Soolved/1.0.0")
public interface SoolutionsApi {

    @ApiOperation(value = "Adiciona nova Soolution", nickname = "add", notes = "Adicionar Soolution", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Soolution cadastrada com sucesso"),
        @ApiResponse(code = 400, message = "Falha ao cadastrar Soolution"),
        @ApiResponse(code = 500, message = "Erro interno") })
    @RequestMapping(value = "/soolutions",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> add(@ApiParam(value = "Soolution a cadastrar"  )  @Valid @RequestBody Soolution soolution);


    @ApiOperation(value = "Remove uma Soolution já existente", nickname = "delete", notes = "Remover Soolution", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Soolution excluida com sucesso"),
        @ApiResponse(code = 400, message = "Falha ao excluir Soolution"),
        @ApiResponse(code = 500, message = "Erro interno") })
    @RequestMapping(value = "/soolutions",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> delete(@ApiParam(value = "Soolution a remover"  )  @Valid @RequestBody Soolution soolution);


    @ApiOperation(value = "Busca por possiveis Soolutions para determinado Bug", nickname = "find", notes = "Busca uma ou mais Soolution ja resolvidadas e que possui mesma causa do Bug", response = Soolution.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Soolution", response = Soolution.class),
        @ApiResponse(code = 400, message = "Soolution para o bug ainda nao localizada"),
        @ApiResponse(code = 500, message = "Erro interno") })
    @RequestMapping(value = "/soolutions",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Soolution>> find(@ApiParam(value = "Bug a pesquisar por Soolution"  )  @Valid @RequestBody Bug bug);


    @ApiOperation(value = "Atualizar Soolution", nickname = "update", notes = "Atualizar Soolution", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Soolution atualizada com sucesso"),
        @ApiResponse(code = 400, message = "Falha ao atualizar Soolution"),
        @ApiResponse(code = 500, message = "Erro interno") })
    @RequestMapping(value = "/soolutions",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> update(@ApiParam(value = "Soolution a atualizar"  )  @Valid @RequestBody Soolution soolution);

}
