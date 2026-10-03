package br.ufms.cpcx.api.demo.Dtos;

import java.util.Date;

public record StandardErrorMessageDto(Date timestamp, int status, String message) {
}