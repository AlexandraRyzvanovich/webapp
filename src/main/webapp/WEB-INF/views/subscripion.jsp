<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>

<mtt:mainlayout>
    <jsp:attribute name="main"></jsp:attribute>
    <jsp:body>
        <h1 style="text-align: center">Your Subscription</h1>
        <div  style="overflow: hidden; _zoom: 1; padding-left: 5%">

            <table  style="float: left; width: 45%">
                <tr>
                    <td colspan="2">Subscription Name</td>
                </tr>
                <tr>
                    <td colspan="2">Subscription Description</td>
                </tr>
                <tr>
                    <td>Price</td><td>100$</td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Buy</button></td>
                </tr>

            </table>



        <table style="float: right; width: 45%">
            <tr>
                <td colspan="2">Subscription Name2</td>
            </tr>
            <tr>
                <td colspan="2">Subscription Description2</td>
            </tr>
            <tr>
                <td>Price</td><td>200$</td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Buy</button></td>
            </tr>

        </table>

            <table  style="float: left; width: 45%; padding-top: 5%">
                <tr>
                    <td colspan="2">Subscription Name</td>
                </tr>
                <tr>
                    <td colspan="2">Subscription Description</td>
                </tr>
                <tr>
                    <td>Price</td><td>100$</td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Buy</button></td>
                </tr>

            </table>



            <table style="float: right; width: 45%;  padding-top: 5%">
                <tr>
                    <td colspan="2">Subscription Name2</td>
                </tr>
                <tr>
                    <td colspan="2">Subscription Description2</td>
                </tr>
                <tr>
                    <td>Price</td><td>200$</td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Buy</button></td>
                </tr>

            </table>
        </div>
    </jsp:body>
</mtt:mainlayout>