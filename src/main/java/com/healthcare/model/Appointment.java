package com.healthcare.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Long userId;
	private Long doctorId;
	private LocalDateTime appointmentTime;
	private String status;

	// Constructors
	public Appointment() {
	}

	public Appointment(Long userId, Long doctorId, LocalDateTime appointmentTime, String status) {
		this.userId = userId;
		this.doctorId = doctorId;
		this.appointmentTime = appointmentTime;
		this.status = status;
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}