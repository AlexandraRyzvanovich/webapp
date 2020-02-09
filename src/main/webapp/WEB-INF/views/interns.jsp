<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<mtt:mainlayout>
    <section>
        <h1>Список пользователей</h1>
        <div class="team-row">
                   <c:set var="s" value="${requestScope.interns}" scope="request"></c:set>
                     <c:forEach var = "intern" items="${s}">
                     <figure>
                         <a href="/internCard/${intern.userId}?command=getInternCard">
                             <img src="/resources/images/avatar.jpg" width="96" height="96" alt=""></a>
                         <figcaption>${intern.firstName} ${intern.lastName}
                             <span>ward</span>
                         </figcaption>
                     </figure>
                     </c:forEach>
        </div>
    </section>
</mtt:mainlayout>
