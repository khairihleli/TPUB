package com.example.tpubpfe.service;

import com.example.tpubpfe.dto.ReservationRequest;
import com.example.tpubpfe.dto.ReservationResponse;
import com.example.tpubpfe.dto.SupportRequest;
import com.example.tpubpfe.dto.SupportResponse;
import com.example.tpubpfe.dto.ZoneRequest;
import com.example.tpubpfe.dto.ZoneResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ZoneSupportReservationServiceTest {

    @Autowired
    private ZoneService zoneService;

    @Autowired
    private SupportService supportService;

    @Autowired
    private ReservationService reservationService;

    @Test
    void shouldCreateZoneSupportAndReservation() {
        ZoneResponse zone = zoneService.create(new ZoneRequest("Tunis Center", "Central zone", 36.8065, 10.1815, 3.0, "Tunis"));
        SupportResponse support = supportService.create(new SupportRequest("Ecran 01", "SCREEN", zone.getId(), "ACTIVE", 120));

        ReservationResponse reservation = reservationService.create(new ReservationRequest(
                null,
                zone.getId(),
                support.getId(),
                "2026-06-01",
                "2026-06-07",
                "08:00",
                "20:00",
                "AVAILABLE",
                "TEMPORARY",
                1200L,
                3500.0
        ));

        assertThat(zone.getId()).isNotNull();
        assertThat(support.getId()).isNotNull();
        assertThat(reservation.getId()).isNotNull();
        assertThat(reservation.getSupportId()).isEqualTo(support.getId());
    }
}
