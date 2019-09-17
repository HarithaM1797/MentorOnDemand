package com.mentorondemand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "proposal_request")
public class ProposalRequest {
	public ProposalRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="proposal_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long proposalId;
	@Column(name="user_id")
	private long userId;
	@Column(name="mentor_id")
	private long mentorId;
	@Column(name="technology_id")
	private long technologyId;
	@Column(name="status")
	private String Status;

	public long getProposalId() {
		return proposalId;
	}

	public void setProposalId(long proposalId) {
		this.proposalId = proposalId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getMentorId() {
		return mentorId;
	}

	public void setMentorId(long mentorId) {
		this.mentorId = mentorId;
	}

	public long getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(long technologyId) {
		this.technologyId = technologyId;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public ProposalRequest( long userId, long mentorId, long technologyId, String status) {
		super();
		
		this.userId = userId;
		this.mentorId = mentorId;
		this.technologyId = technologyId;
		Status = status;
	}

}
