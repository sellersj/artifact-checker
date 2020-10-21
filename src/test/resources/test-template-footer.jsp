<%@ include file="/WEB-INF/content/includes.jspf" %>

<template:write templateName="usability-2-col-template" sectionName="EPIC_FOOTER">
    <template:insert key="EPIC_LEFT_NAV" action="replace"><%@ include file="/WEB-INF/content/common/sidenav/sidenav.jsp" %></template:insert>
	<template:insert key="EPIC_DATE">
		<dl>
		  <dt><f:message key="jsp.footer.modified"/><f:message key="jsp.global.separator"/></dt>
		  <dd><time><f:message key="project.build.date" /></time></dd>
		</dl>
	</template:insert>
</template:write>