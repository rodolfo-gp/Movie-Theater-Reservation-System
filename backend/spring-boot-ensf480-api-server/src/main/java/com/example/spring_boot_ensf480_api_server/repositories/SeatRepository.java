package com.example.spring_boot_ensf480_api_server.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_boot_ensf480_api_server.models.Seat;

@Repository
public interface SeatRepository extends CrudRepository<Seat, String> {
    List<Seat> findByBookedFalse();
}

