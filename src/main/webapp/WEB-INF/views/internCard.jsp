<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<mtt:mainlayout>
    <section>
        <h1>Intern Card</h1>
        <div>
            <h3>Diet</h3>
        <form method="post" action="clients">
        <table cellspacing="0">
            <tr>
                <th>Diet</th>
                <th>Strat date</th>
                <th>End date</th>
                <th>status</th>
            </tr>
            <tr>
                <td>Diet name</td>
                <td>01-01-2020</td>
                <td>01-02-2020</td>
                <td>Good status</td>
            </tr>
        </table>
        <input title="Submit" type="submit"/>
        </form>
        </div>
        <div>
            <h3>Training program</h3>
            <table cellspacing="0">
                <tr>
                    <th>Exercise name</th>
                    <th>Frequency</th>
                </tr>
                <tr>
                    <td>Jump</td>
                    <td>20</td>
                </tr>
                <tr>
                    <td>ABS</td>
                    <td>20</td>
                </tr>
                <tr>
                    <td>steps</td>
                    <td>2020</td>
                </tr>
            </table>
            <form method="post" action="training-program">
                <select>
                    <option>Exercise name1</option>
                    <option>Exercise name2</option>
                    <option>Exercise name3</option>
                    <option>Exercise name4</option>
                </select>
                <input type="text">
                <input type="submit">
            </form>
        </div>
    </section>
</mtt:mainlayout>