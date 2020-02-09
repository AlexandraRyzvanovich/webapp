<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<mtt:mainlayout>
    <section>
        <h2>UserName Card</h2>
        <div class="card">
            <table>

                <tr>
                    <td>
                        Name
                    </td>
                    <td>
                        val
                    </td>
                </tr>
                <tr>
                    <td>
                        Age
                    </td>
                    <td>
                        val
                    </td>
                </tr>
                <tr>
                    <td>
                        Status
                    </td>
                    <td>
                        val
                    </td>
                </tr>
            </table>
            <form action="/diet" method="post" style="float: left; width: 45%">
                <div id="myDIV2" class="header">
                    <h2>Create Diet</h2>
                    <input type="text" id="myInput2" placeholder="Title...">
                    <span onclick="newElement2()" class="addBtn" style="float: right;">Add</span>
                </div>

                <ul id="myUL2">
                    <li class="liwithclose">Hit the gym</li>
                    <li class="liwithclose">Pay bills</li>
                    <li class="liwithclose">Meet George</li>
                    <li class="liwithclose">Buy eggs</li>
                    <li class="liwithclose">Read a book</li>
                    <li class="liwithclose">Organize office</li>
                </ul>
                <button type="submit">Approve</button>
            </form>
            <form action="/diet" method="post" style="float: right; width: 45%">
                <div id="myDIV1" class="header">
                    <h2>Add Exercises</h2>
                    <input type="text" id="myInput1" placeholder="Title...">
                    <span onclick="newElement()" class="addBtn" style="float: right;">Add</span>
                </div>

                <ul id="myUL1">
                    <li class="liwithclose2">Hit the gym</li>
                    <li class="liwithclose2">Pay bills</li>
                    <li class="liwithclose2">Meet George</li>
                    <li class="liwithclose2">Buy eggs</li>
                    <li class="liwithclose2">Read a book</li>
                    <li class="liwithclose2">Organize office</li>
                </ul>
                <button type="submit">Approve</button>
            </form>
        </div>
    </section>
</mtt:mainlayout>
<script type="text/javascript">
    var myNodelist = document.getElementsByClassName("liwithclose");
    var i;
    for (i = 0; i < myNodelist.length; i++) {
        var span = document.createElement("SPAN");
        var txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        myNodelist[i].appendChild(span);
    }

    var close = document.getElementsByClassName("close");
    var i;
    for (i = 0; i < close.length; i++) {
        close[i].onclick = function () {
            var div = this.parentElement;
            div.style.display = "none";
        }
    }

    var list = document.querySelector('ul');
    list.addEventListener('click', function (ev) {
        if (ev.target.tagName === 'LI') {
            ev.target.classList.toggle('checked');
        }
    }, false);

    function newElement() {
        var li = document.createElement("li");
        var inputValue = document.getElementById("myInput1").value;
        var t = document.createTextNode(inputValue);
        li.appendChild(t);
        if (inputValue === '') {
            alert("You must write something!");
        } else {
            document.getElementById("myUL1").appendChild(li);
        }
        document.getElementById("myInput1").value = "";

        var span = document.createElement("SPAN");
        var txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        li.appendChild(span);

        for (i = 0; i < close.length; i++) {
            close[i].onclick = function () {
                var div = this.parentElement;
                div.style.display = "none";
            }
        }
    }

    var myNodelist2 = document.getElementsByClassName("liwithclose2");
    var u;
    for (i = 0; u < myNodelist2.length; u++) {
        var span = document.createElement("SPAN");
        var txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        myNodelist2[u].appendChild(span);
    }

    var close = document.getElementsByClassName("close");
    var i;
    for (i = 0; i < close.length; i++) {
        close[i].onclick = function () {
            var div = this.parentElement;
            div.style.display = "none";
        }
    }

    var list = document.querySelector('ul');
    list.addEventListener('click', function (ev) {
        if (ev.target.tagName === 'LI') {
            ev.target.classList.toggle('checked');
        }
    }, false);

    function newElement2() {
        var li = document.createElement("li");
        var inputValue = document.getElementById("myInput2").value;
        var t = document.createTextNode(inputValue);
        li.appendChild(t);
        if (inputValue === '') {
            alert("You must write something!");
        } else {
            document.getElementById("myUL2").appendChild(li);
        }
        document.getElementById("myInput2").value = "";

        var span = document.createElement("SPAN");
        var txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        li.appendChild(span);

        for (i = 0; i < close.length; i++) {
            close[i].onclick = function () {
                var div = this.parentElement;
                div.style.display = "none";
            }
        }
    }
</script>