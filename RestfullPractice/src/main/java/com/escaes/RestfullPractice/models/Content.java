package com.escaes.RestfullPractice.models;


import java.time.LocalDateTime;

public record Content(
  Integer id,
  String title,
  String description,
  Status status,
  Type type,
  LocalDateTime createdDate,
  LocalDateTime updatedDate,
  String url) {

}
