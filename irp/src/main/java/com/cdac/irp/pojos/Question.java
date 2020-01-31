package com.cdac.irp.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer questionId;

	private String question;
	// private String imageName;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private Integer answer;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	public Question() {
//		System.out.println("in question pojo");
	}

	public Question(Integer questionId, String question, String option1, String option2, String option3, String option4,
			Integer answer, Subject subject) {
		super();
		this.questionId = questionId;
		this.question = question;
		// this.imageName = imageName;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.subject = subject;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public Integer getAnswer() {
		return answer;
	}

	public void setAnswer(Integer answer) {
		this.answer = answer;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", answer=" + answer + ", subject="
				+ subject + "]";
	}
	
	

}
