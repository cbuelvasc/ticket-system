package com.xeppelin.ticketsystem.domain.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QrCode {

    private UUID id;

    private QrCodeStatusEnum status;

    private String value;

    private Ticket ticket;
} 