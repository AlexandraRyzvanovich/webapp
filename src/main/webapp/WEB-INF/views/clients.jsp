<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<mtt:mainlayout>
    <section>
    <h1>Список пользователей</h1>
        <div class="team-row">
            <table cellspacing="0">
                    <tr>
                        <th>Имя</th>
                        <th>Фамилия</th>
                        <th>Email</th>
                        <th>Айди тренера</th>
                        <th>Выбрать тренера</th>
                        <th></th>
                    </tr>
                    <c:forEach var = "client" items="${requestScope.clients}">
                    <tr>
                        <td>${client.firstName}</td>
                        <td>${client.lastName}</td>
                        <td>${client.email}</td>
                        <td>${client.trainerId}</td>
                        <td>
                            <select>
                                <c:forEach var = "trainer" items="${requestScope.trainers}">
                                <option>${trainer.firstName} ${trainer.lastName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <form method="post" action="clients">
                                <input type="hidden" name="command" value="setTrainer">
                                <input hidden name="trainerId" value=""/>
                                <input type="submit" value="Submit"/>
                            </form>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
    </section>
</mtt:mainlayout>