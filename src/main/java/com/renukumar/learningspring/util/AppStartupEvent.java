package com.renukumar.learningspring.util;

import com.renukumar.learningspring.data.Guest;
import com.renukumar.learningspring.data.GuestRepository;
import com.renukumar.learningspring.data.Reservation;
import com.renukumar.learningspring.data.ReservationRepository;
import com.renukumar.learningspring.data.Room;
import com.renukumar.learningspring.data.RoomRepository;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
  private RoomRepository roomRepository;
  private GuestRepository guestRepository;
  private ReservationRepository reservationRepository;

  public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository){
    this.roomRepository = roomRepository;
    this.guestRepository = guestRepository;
    this.reservationRepository =  reservationRepository;
  }
  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    Iterable<Room> rooms = this.roomRepository.findAll();
    rooms.forEach(System.out::println);

    Iterable<Guest> guests = this.guestRepository.findAll();
    guests.forEach(System.out::println);

    Iterable<Reservation> reservations = this.reservationRepository.findAll();
    reservations.forEach(System.out::println);
  }

  
}
