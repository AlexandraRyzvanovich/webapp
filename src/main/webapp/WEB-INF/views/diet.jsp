<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>

<mtt:mainlayout>
    <section>
        <form action="/diet" method="post">
            <label>
                Description
                <input name="Description">
            </label>
            <button type="submit">Save</button>
        </form>
    </section>
</mtt:mainlayout>