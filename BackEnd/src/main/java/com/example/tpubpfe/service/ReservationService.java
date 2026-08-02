package com.example.tpubpfe.service;

import com.example.tpubpfe.dto.ReservationRequest;
import com.example.tpubpfe.dto.ReservationResponse;
import com.example.tpubpfe.model.Reservation;
import com.example.tpubpfe.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationResponse create(ReservationRequest request) {
        Reservation reservation = new Reservation();
        reservation.setCampaignId(request.getCampaignId());
        reservation.setZoneId(request.getZoneId());
        reservation.setSupportId(request.getSupportId());
        reservation.setStartDate(request.getStartDate());
        reservation.setEndDate(request.getEndDate());
        reservation.setStartTime(request.getStartTime());
        reservation.setEndTime(request.getEndTime());
        reservation.setAvailabilityStatus(request.getAvailabilityStatus());
        reservation.setReservationStatus(request.getReservationStatus());
        reservation.setEstimatedViews(request.getEstimatedViews());
        reservation.setEstimatedCost(request.getEstimatedCost());
        return toResponse(reservationRepository.save(reservation));
    }

    public List<ReservationResponse> findAll() {
        return reservationRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public ReservationResponse update(Long id, ReservationRequest request) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
        reservation.setCampaignId(request.getCampaignId());
        reservation.setZoneId(request.getZoneId());
        reservation.setSupportId(request.getSupportId());
        reservation.setStartDate(request.getStartDate());
        reservation.setEndDate(request.getEndDate());
        reservation.setStartTime(request.getStartTime());
        reservation.setEndTime(request.getEndTime());
        reservation.setAvailabilityStatus(request.getAvailabilityStatus());
        reservation.setReservationStatus(request.getReservationStatus());
        reservation.setEstimatedViews(request.getEstimatedViews());
        reservation.setEstimatedCost(request.getEstimatedCost());
        return toResponse(reservationRepository.save(reservation));
    }

    public void delete(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
        reservationRepository.delete(reservation);
    }

    private ReservationResponse toResponse(Reservation reservation) {
        return new ReservationResponse(reservation.getId(), reservation.getCampaignId(), reservation.getZoneId(), reservation.getSupportId(), reservation.getStartDate(), reservation.getEndDate(), reservation.getStartTime(), reservation.getEndTime(), reservation.getAvailabilityStatus(), reservation.getReservationStatus(), reservation.getEstimatedViews(), reservation.getEstimatedCost());
    }
}
