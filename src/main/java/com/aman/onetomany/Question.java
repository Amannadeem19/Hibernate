package com.aman.onetomany;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Question {
	@Id
	private int quest_id;
	private String question;

	@OneToMany(mappedBy = "question", fetch=FetchType.EAGER)
	private List<Answer> ans;
	
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Question(int quest_id, String question, List<Answer> ans) {
		super();
		this.quest_id = quest_id;
		this.question = question;
		this.ans = ans;
	}
	
	public List<Answer> getAns() {
		return ans;
	}

	public void setAns(List<Answer> ans) {
		this.ans = ans;
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
	
	
	
	
	
}
