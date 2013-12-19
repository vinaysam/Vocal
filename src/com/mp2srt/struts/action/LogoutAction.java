/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.mp2srt.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.mp2srt.struts.form.LogoutForm;

/** 
 * MyEclipse Struts
 * Creation date: 12-19-2013
 * 
 * XDoclet definition:
 * @struts.action path="/logout" name="logoutForm" input="/usersend.jsp" scope="request" validate="true"
 * @struts.action-forward name="logout" path="/index.jsp" redirect="true"
 */
public class LogoutAction extends Action {
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
		LogoutForm logoutForm = (LogoutForm) form;// TODO Auto-generated method stub
		return mapping.findForward("logout");
	}
}