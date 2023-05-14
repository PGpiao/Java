<%@ tag pageEncoding="UTF-8"%>
<%--导入JSTL库 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--处理器属性包含了用户注册请求所指向的页面地址。
用户注册请求 --%>
<%@ attribute name="processor" required="true" rtexprvalue="true"%>
<%-- 注册链接只在用户当前是
用户没有经过验证、
即在会话区的authUser变量中没有存储JavaBean。
用户 --%>
<c:if test="${sessionScope.authUser==null}">
	<a href="${processor}">Зарегистрироваться</a>
</c:if>
