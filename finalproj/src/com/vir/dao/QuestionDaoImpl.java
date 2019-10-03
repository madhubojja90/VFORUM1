package com.vir.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vir.model.Answer;
import com.vir.model.Employee;
import com.vir.model.Question;

public class QuestionDaoImpl implements QuestionDaoInterface
{

	public String addQuestion(Question question) 
	{   int empid=question.getEmpid();
		int qid = question.getQid();
		String qdesc= question.getQdesc();
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try
		{  
			con = DBConnection.createConnection();
			String query = "insert into question(empid,qdesc) values(?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		
			//preparedStatement.setInt(1, qid);
			preparedStatement.setInt(1,empid);
			preparedStatement.setString(2,qdesc);
			int i= preparedStatement.executeUpdate();
			if (i!=0)  //Just to ensure data has been inserted into the database
				return "SUCCESS"; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		
		}
		return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}
	
	/**
	 * @deprecated Use {@link #getQuestionByqid(int)} instead
	 */
	public Question getEmployeeById(int qid) {
		return getQuestionByqid(qid);
	}

	public Question getQuestionByqid(int qid) {
		  Question question=new Question();  
		  Connection con = null;
			
			try{
				con = DBConnection.createConnection();
				PreparedStatement ps=con.prepareStatement("select * from question where qid=?");
				ps.setInt(1,qid);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					
					question.setQid(rs.getInt(1));
					question.setEmpid(rs.getInt(2));
					question.setQdesc(rs.getString(3));
					
				}
				con.close();
			}catch(Exception ex){ex.printStackTrace();}
			
			return question;
	    }  

	public int update(Question question){
		
		
		  Connection con = null;
		  int status=0;
		try{
			con = DBConnection.createConnection();
			PreparedStatement ps=con.prepareStatement("update question set qdesc=? where qid=?");
			
			ps.setString(1,question.getQdesc());
			ps.setInt(2,question.getQid());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}


	public List<Question> getAllQuestion() {
		List<Question> list=new ArrayList<Question>();  
        
        try{  
        	Connection con = DBConnection.createConnection(); 
            PreparedStatement ps=con.prepareStatement("select * from Question");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Question question=new Question(); 
            	question.setQid(rs.getInt(1));
            	question.setEmpid(rs.getInt(2));
            	question.setQdesc(rs.getString(3));
                list.add(question);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }


	public int deleteQuestion(int qid) {
		   int status=0;  
	        try{  
	        	Connection con = DBConnection.createConnection(); 
	            PreparedStatement ps=con.prepareStatement("delete from Question where qid=?");  
	            ps.setInt(1,qid);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }

	@Override
	public List<Question> getQuestionByEmpid(int empid) {
List<Question> list=new ArrayList<Question>();  
        
        try{  
        	Connection con = DBConnection.createConnection(); 
            PreparedStatement ps=con.prepareStatement("select * from vforum.question where empid=?");  
            ps.setInt(1, empid);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Question question=new Question(); 
            	question.setQid(rs.getInt(1));
            	question.setEmpid(rs.getInt(2));
            	question.setQdesc(rs.getString(3));
                list.add(question);  
            }
           
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
        return list;
	}

}
	


	
		
		     
	
	
	


	

	
