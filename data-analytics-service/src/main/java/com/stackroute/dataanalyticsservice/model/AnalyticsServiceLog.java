package com.stackroute.dataanalyticsservice.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AnalyticsServiceLog {
	@Id
	@Column(name = "id")
	private UUID id;
	@Column(name = "customer_id", length = 30)
	private String customer_id;
	@Column(name = "packet_status", length = 30)
	private String packet_status;
	@Column(name = "createdAt")
	private Date createdAt;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getPacket_status() {
		return packet_status;
	}

	public void setPacket_status(String packet_status) {
		this.packet_status = packet_status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "LogModel [id=" + id + ", customer_id=" + customer_id + ", packet_status=" + packet_status
				+ ", createdAt=" + createdAt + "]";
	}
}
