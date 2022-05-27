package com.renukumar.learningspring.util;

import com.renukumar.learningspring.data.Room;
import com.renukumar.learningspring.data.RoomRepository;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
  private RoomRepository roomRepository;
  public AppStartupEvent(RoomRepository roomRepository){
    this.roomRepository = roomRepository;
  }
  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    Iterable<Room> rooms = this.roomRepository.findAll();
    rooms.forEach(System.out::println);
  }

  
}
