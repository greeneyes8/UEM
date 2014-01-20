<%@page import="javassist.expr.NewArray"%>
<%@page import="it.unical.uniexam.hibernate.domain.Group"%>
<%@page import="it.unical.uniexam.hibernate.domain.DegreeCourse"%>
<%@page import="java.util.Set" %>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script type="text/javascript">
	$(document).ready(function() {
		selectingFromDashBoard(document.getElementById("courseButton"));
		$("#sorting").tablesorter();
	});
</script>
<div class="container-center">
	<script type="text/javascript">
		var oldString = "";
		function aler() {
			// 					alert("ciao");
		}
		function storeOld(item) {
// 			alert("ciao");
			// 			oldString = $("#" + item.id).children().html();
			// 			$("#" + item.id).children().html().select();
			oldString = $("#" + item.id).children().html();
			$("#" + item.id).children().select();
			// 			oldString.parent().select();
		}
		function beforeChangeNote(item, idCourse) {
			var newString = $("#" + item.id).children().html();
			if (newString == oldString || newString == "") {
				// 						alert("sono Uguali");
				return;
			}
			// 					alert("sono Diversi");
			changeNote(item, idCourse);
		}
		// 				$(document).ready(function(){
		// 					$("#clearH").click(function(){
		// 						clear(this);
		// 					});
		// 				});
	</script>
	<fieldset>
		<legend><spring:message
								code="message.manager.course.container.center.legendCourses" /></legend>
		<ol id="#sorting">
			<%
// 				ArrayList<ArrayList<Object>> struct = new ArrayList<ArrayList<Object>>();
				Set<DegreeCourse> courses = (Set<DegreeCourse>) request.getAttribute("courses");
// 				int count = 0;
				if (courses != null && courses.size() > 0) {
					for (DegreeCourse c : courses) {
// 						System.out.print(count+" ");
// 						struct.add(new ArrayList<Object>());
// 						struct.get(count).add(c);
// 						struct.get(count).addAll(c.getGroups());
			%>
			<li class="list_course">
				<article>
					<section id="<%="course" + c.getId()%>">
						<a id="<%="acourse" + c.getId()%>" href="#" onclick="getDataFromAjax(this);"><h1><%=c.getName()%></h1></a>
					</section>
					
				</article>
<%-- 				<a href="${pageContext.request.contextPath}/professor/ajax/course/course_details">LINK TO TRY</a> --%>
			</li>
			<%
				}
				} else {
			%>
			<spring:message
				code="message.professor.course.container.center.nocourse" />
			<%
				}
			%>
		</ol>
	</fieldset>
</div>
<%-- 						<input id="<%="noteInput" + (count)%>" type="text" --%>
<!-- 							style="border: none; background: inherit; dispay: none;" -->
<%-- 							placeholder="<spring:message code='message.professor.course.container.center.nonote' />" /> --%>