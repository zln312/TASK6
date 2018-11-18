<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:property name="student" value="${student}"/>
</json:object>