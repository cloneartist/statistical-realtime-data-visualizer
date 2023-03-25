package com.stackroute.dataingestionservice.model;

import java.time.Instant;

import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class IngestionServiceLog {

	private String id;
	private String customer_id;
	private String packet_status;
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
