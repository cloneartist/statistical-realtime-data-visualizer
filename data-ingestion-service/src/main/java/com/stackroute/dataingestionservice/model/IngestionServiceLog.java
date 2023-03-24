package com.stackroute.dataingestionservice.model;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ingestion_log")
public class IngestionServiceLog {
	@Id
	@Column(name = "id", length = 45)
	private String id;
	@Column(name = "customer_id", length = 30)
	private String customer_id;
	@Column(name = "packet_status", length = 30)
	private String packet_status;
	@Column(name = "createdAt")
	private Instant createdAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "LogModel [id=" + id + ", customer_id=" + customer_id + ", packet_status=" + packet_status
				+ ", createdAt=" + createdAt + "]";
	}
}
