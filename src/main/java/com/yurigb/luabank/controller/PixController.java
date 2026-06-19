package com.yurigb.luabank.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yurigb.luabank.dto.request.CriarChavePixDTO;
import com.yurigb.luabank.dto.request.PixDTO;
import com.yurigb.luabank.dto.response.ChavePixResponseDTO;
import com.yurigb.luabank.service.ChavePixService;
import com.yurigb.luabank.service.ContaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Pix", description = "Gerenciamento de chaves e transferências Pix")
@RequestMapping("/pix")
public class PixController {

    private final ChavePixService chavePixService;
    private final ContaService contaService;

    public PixController(
            ChavePixService chavePixService,
            ContaService contaService) {

        this.chavePixService = chavePixService;
        this.contaService = contaService;
    }

    private String obterEmailLogado() {
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
    }

    @PostMapping("/chaves")
    public void cadastrarChave(
            @Valid @RequestBody CriarChavePixDTO dados) {

        chavePixService.cadastrarChave(
                obterEmailLogado(),
                dados);
    }

    @GetMapping("/chaves")
    public List<ChavePixResponseDTO> listarChaves() {

        return chavePixService.listarChaves(
                obterEmailLogado());
    }

    @DeleteMapping("/chaves/{id}")
    public void removerChave(
            @PathVariable Long id) {

        chavePixService.removerChave(
                id,
                obterEmailLogado());
    }

    @Operation(summary = "Realizar transferência Pix", description = "Efetua uma transferência Pix para outra conta.")
    @PostMapping
    public void enviarPix(
            @Valid @RequestBody PixDTO dados) {

        contaService.enviarPix(
                obterEmailLogado(),
                dados.chavePix(),
                dados.valor());
    }
}