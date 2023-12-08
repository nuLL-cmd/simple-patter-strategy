package br.com.automatodev.strategy.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ReturnProcess implements Serializable{

    private static final long serialVersionUID = 1L;

    private String message;

    private HttpStatus status;

}