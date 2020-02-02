<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>

<mtt:mainlayout>
    <section>
        <form action="/diet" method="post">
            <div id="myDIV" class="header">
                <h2 style="color: #E1D070;text-align: center;margin-bottom: 3%;">My Diet</h2>
                <input style="float: left; width: 300px; height: 36px; border-radius: 6px;" type="text" id="myInput">
                <span onclick="newElement()" class=" addBtn">Add</span>
            </div>

            <ul id="myUL">
                <li class="liwithclose">Hit the gym</li>
                <li class="liwithclose">Pay bills</li>
                <li class="liwithclose">Meet George</li>
                <li class="liwithclose">Buy eggs</li>
                <li class="liwithclose">Read a book</li>
                <li class="liwithclose">Organize office</li>
            </ul>
            <a class="bot1" onclick="">Approve</a>
        </form>
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

    // Click on a close button to hide the current list item
    var close = document.getElementsByClassName("close");
    var i;
    for (i = 0; i < close.length; i++) {
        close[i].onclick = function() {
            var div = this.parentElement;
            div.style.display = "none";
        }
    }

    // Add a "checked" symbol when clicking on a list item
    var list = document.querySelector('ul');
    list.addEventListener('click', function(ev) {
        if (ev.target.tagName === 'LI') {
            ev.target.classList.toggle('checked');
        }
    }, false);

    // Create a new list item when clicking on the "Add" button
    function newElement() {
        var li = document.createElement("li");
        var inputValue = document.getElementById("myInput").value;
        var t = document.createTextNode(inputValue);
        li.appendChild(t);
        if (inputValue === '') {
            alert("You must write something!");
        } else {
            document.getElementById("myUL").appendChild(li);
        }
        document.getElementById("myInput").value = "";

        var span = document.createElement("SPAN");
        var txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        li.appendChild(span);

        for (i = 0; i < close.length; i++) {
            close[i].onclick = function() {
                var div = this.parentElement;
                div.style.display = "none";
            }
        }
    }
</script>