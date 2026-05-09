package dev.java10x.cadastroDeNinjas.Ninjas.Controller;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import dev.java10x.cadastroDeNinjas.Ninjas.dto.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.dto.NinjaErrorResponse;
import dev.java10x.cadastroDeNinjas.Ninjas.exception.NinjaNotFoundException;
import dev.java10x.cadastroDeNinjas.Ninjas.mapper.NinjaMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @PostMapping
    @Operation(summary = "Cria um novo Ninja", description = "Rota realiza a criação de um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<NinjaDTO> criarNinja(@RequestBody NinjaDTO novoNinja) {

        Ninja ninjaCriado = ninjaService.criarNinja(NinjaMapper.toEntity(novoNinja));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(NinjaMapper.toDTO(ninjaCriado));
    }


    @GetMapping("/{id}")
    @Operation(
            summary = "Busca Ninja por ID",
            description = "Rota realiza a busca de um ninja pelo seu ID"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ninja encontrado com sucesso",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = NinjaDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404",
                            description = "Ninja não encontrado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = NinjaErrorResponse.class)
                            )
                    )
            }
    )
    public ResponseEntity<?> buscarNinjaPorId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(NinjaMapper.toDTO(ninjaService.findById(id)));
    }

    // READ ALL
    @GetMapping
    @Operation(summary = "Retorna todos os Ninjas", description = "Rota retorna uma lista contendo todos os Ninjas do banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas listados com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(implementation = NinjaDTO.class)
                            )
                    )),
            @ApiResponse(responseCode = "400", description = "Erro ao listar ninjas")
    })
    public ResponseEntity<List<NinjaDTO>> buscarTodos() {


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ninjaService.findAllNinjas()
                                .stream()
                                .map(NinjaMapper::toDTO)
                                .toList()
                );

    }

    // UPDATE
    @PutMapping("/{id}")
    @Operation(summary = "Altera um Ninja", description = "Rota altera um Ninja de acordo com o id e Ninja enviado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = NinjaDTO.class)
                    )),
            @ApiResponse(responseCode = "404", description = "Erro ao alterar ninja, não encontrado no banco de dados",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = NinjaErrorResponse.class)
                    ))
    })
    public ResponseEntity<NinjaDTO> alterarNinja
    (@Parameter(description = "Usuario manda o id no PathVariable da requisição")
            @PathVariable Long id,
     @io.swagger.v3.oas.annotations.parameters.RequestBody(
             description = "Usuario envia os dados modificados no RequestBody"
     )
            @RequestBody NinjaDTO ninjaAlterado
    ) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(NinjaMapper.toDTO(ninjaService.atualizarNinja(id, ninjaAlterado)));
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um Ninja", description = "Rota deleta um Ninja de acordo com o id enviado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Erro ao deletar ninja, não encontrado no banco de dados")
    })
    public ResponseEntity<Map<String, String>> deletarNinja(@PathVariable Long id) {

        ninjaService.deleteNinja(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("response", "ninja com ID=" + id + " deletado com sucesso."));

    }

}