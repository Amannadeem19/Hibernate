package com.aman.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	private int quest_id;
	private String question;
//	achieving uni-directional
	@OneToOne
	@JoinColumn(name = "ans_id")
	private Answer answer;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int quest_id, String question, Answer answer) {
		super();
		this.quest_id = quest_id;
		this.question = question;
		this.answer = answer;
	}
	public int getQuest_id() {
		return quest_id;
	}
	public void setQuest_id(int quest_id) {
		this.quest_id = quest_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	
	
	
}
