package com.cdac.irp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.irp.dao.IQuizDao;
import com.cdac.irp.models.AnswerModel;
import com.cdac.irp.models.QuestionModel;
import com.cdac.irp.pojos.Question;

@Service
public class QuizServiceImpl implements IQuizService {

	@Autowired
	private IQuizDao dao;

	@Override
	public List<QuestionModel> getTenQuestionList(/*
													 * add course id parameter later on and student id for randomizer
													 * seed
													 */) {
		List<Question> qts = dao.getQuestionList();
		Collections.shuffle(qts);
		qts = qts.subList(0, 10); // gives only 10 questions
		List<QuestionModel> lt = new ArrayList<>();
		for (Question question : qts) {
			QuestionModel qm = new QuestionModel();
			qm.setQuestionId(question.getQuestionId());
			qm.setQuestion(question.getQuestion());
			String[] o = { question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4() };
			qm.setOptions(o);
			lt.add(qm);
		}
		return lt;
	}
	
	@Override
	public List<AnswerModel> getAnswersList() {
		return dao.getAnswerList();	
	}

}
