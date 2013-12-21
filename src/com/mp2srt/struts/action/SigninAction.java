/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.mp2srt.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.TextAction;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mp2srt.hibernate.Compte;
import com.mp2srt.hibernate.CompteDAO;
import com.mp2srt.struts.form.SigninForm;

/** 
 * MyEclipse Struts
 * Creation date: 12-18-2013
 * 
 * XDoclet definition:
 * @struts.action path="/signin" name="signinForm" input="/index.jsp" scope="request" validate="true"
 * @struts.action-forward name="super" path="/superviser.jsp" redirect="true"
 * @struts.action-forward name="admin" path="/adminappjsa.jsp" redirect="true"
 * @struts.action-forward name="wrong" path="/index.jsp" redirect="true"
 * @struts.action-forward name="user" path="/usersend.jsp" redirect="true"
 */
public class SigninAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SigninForm signinForm = (SigninForm) form;// TODO Auto-generated method stub


		String output ="wrong";
		String login = signinForm.getLogin();
		String password = signinForm.getPassword();
		
		
		CompteDAO ud = new CompteDAO();
		Compte us = ud.findById(login);
		
		
		
		Logger log = Logger.getLogger(TextAction.class);
		request.getSession().setAttribute("invalid", " ");
		request.getSession().setAttribute("mail", " ");
		request.getSession().setAttribute("name", " ");
		
		
		if(us != null && us.getPassword().equals(password))
		{
			
			if (us.getPrivilege().getStatus().equals("user"))
			{
				
				log.info("The user" + login + " has connected.");
				output ="user";
				
				request.getSession().setAttribute("name", us.getTitre() + " " + us.getNom() + " " + us.getPrenom() +  ".");
				request.getSession().setAttribute("mail", " " + us.getAdresseMail());
					
			}
			else if (us.getPrivilege().getStatus().equals("admin"))
			{
				log.info("The Adminisrator" + login + " has connected.");
				request.getSession().setAttribute("name", us.getTitre() + " " + us.getNom() + " " + us.getPrenom() +  ".");
				
				output ="admin";
			}
			else if (us.getPrivilege().getStatus().equals("super"))
			{
				
				log.info("The Superviser" + login + " has connected.");
				request.getSession().setAttribute("name", us.getTitre() + " " + us.getNom() + " " + us.getPrenom() +  ".");
				output ="super";
			}
			else
			{
				log.error(login + " failed an attempts to login.");
				request.getSession().setAttribute("invalid", us.getTitre() + " " + us.getNom() + " " + us.getPrenom() +  " you wrote a wrong password.");
				output = "wrong";
				
			}
				
		}
		else
		{
			log.error("An attempts to login by this id " + login + " has failed.");
			request.getSession().setAttribute("invalid", "Invalid login and password.");
		}
		return mapping.findForward(output);
	}
}