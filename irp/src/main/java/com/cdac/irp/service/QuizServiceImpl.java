package com.cdac.irp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.irp.dao.IQuizDao;
import com.cdac.irp.dao.IQuizJpaDao;
import com.cdac.irp.dao.ISubjectDao;
import com.cdac.irp.models.AnswerRequestModel;
import com.cdac.irp.models.AnswerResponseModel;
import com.cdac.irp.models.QuestionRequestModel;
import com.cdac.irp.models.QuestionResponseModel;
import com.cdac.irp.pojos.Question;
import com.cdac.irp.pojos.Subject;

@Service
public class QuizServiceImpl implements IQuizService {

	@Autowired
	private IQuizDao dao;

	@Autowired
	private IQuizJpaDao jpaDao;

	@Autowired
	private ISubjectDao subDao;

	@Override
	public List<QuestionResponseModel> getTenQuestionList() throws Exception {
		List<Question> qts = dao.getQuestionList();
		Collections.shuffle(qts);
		if (qts.size() >= 10)
			qts = qts.subList(0, 10); // gives only 10 questions
		List<QuestionResponseModel> lt = new ArrayList<>();
		for (Question question : qts) {
			QuestionResponseModel qm = new QuestionResponseModel();
			qm.setQuestionId(question.getQuestionId());
			qm.setQuestion(question.getQuestion());
			String[] o = { question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4() };
			qm.setOptions(o);
			lt.add(qm);
		}
		return lt;
	}

	@Override
	public List<AnswerResponseModel> getAnswersList(List<AnswerRequestModel> qstIds) throws Exception {
		return dao.getAnswerList(qstIds);
	}

	@Override
	public List<QuestionResponseModel> getQuestionsBySubject(Integer subId) throws Exception {
		List<Question> qts = dao.getQuestionbySubject(subId);
		Collections.shuffle(qts);
		if (qts.size() >= 10)
			qts = qts.subList(0, 10); // gives only 10 questions
		List<QuestionResponseModel> lt = new ArrayList<>();
		for (Question question : qts) {
			QuestionResponseModel qm = new QuestionResponseModel();
			qm.setQuestionId(question.getQuestionId());
			qm.setQuestion(question.getQuestion());
			String[] o = { question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4() };
			qm.setOptions(o);
			lt.add(qm);
		}
		return lt;
	}

	@Override
	public Question putQuestion(QuestionRequestModel qst) throws Exception {
		Subject subject = subDao.getSubject(qst.getSubjectId());
		Question q= new Question();
		q.setSubject(subject);
		q.setQuestion(qst.getQuestion());
		q.setOption1(qst.getOption1());
		q.setOption2(qst.getOption2());
		q.setOption3(qst.getOption3());
		q.setOption4(qst.getOption4());
		q.setAnswer(qst.getAnswer());
		return jpaDao.save(q);
	}

}
