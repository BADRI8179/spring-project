package com.healthcare.controller;

import com.healthcare.model.Appointment;
import com.healthcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/book")
	public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment) {
		Appointment newAppointment = appointmentService.bookAppointment(appointment);
		return ResponseEntity.ok(newAppointment);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Appointment>> getUserAppointments(@PathVariable Long userId) {
		List<Appointment> appointments = appointmentService.getAppointmentsByUserId(userId);
		return ResponseEntity.ok(appointments);
	}

	@GetMapping("/doctor/{doctorId}")
	public ResponseEntity<List<Appointment>> getDoctorAppointments(@PathVariable Long doctorId) {
		List<Appointment> appointments = appointmentService.getAppointmentsByDoctorId(doctorId);
		return ResponseEntity.ok(appointments);
	}
}