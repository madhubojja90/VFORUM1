package com.vir.service;

import java.util.List;

import com.vir.model.Question;

public interface QuestionServiceInterface 
{
	public String addQuestion(Question question);

	public int deleteQuestion(int qid);
	public Question getEmployeeById(int qid);
	public int update(Question  qid);
	 public List<Question> getAllQuestion();
	 public List<Question> getQuestionByEmpid(int empid);
	
}
