<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<style>
    * {
        box-sizing: border-box;
    }

    #myUL > {
        margin: 0;
        padding: 0;
    }

    #myUL > li {
        cursor: pointer;
        position: relative;
        padding: 12px 8px 12px 40px;
        background: #eee;
        font-size: 18px;
        transition: 0.2s;

        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
    }

    #myUL > li:nth-child(odd) {
        background: #f9f9f9;
    }

    #myUL > li:hover {
        background: #ddd;
    }

    #myUL > li.checked {
        background: #888;
        color: #fff;
        text-decoration: line-through;
    }

    #myUL > li.checked::before {
        content: '';
        position: absolute;
        border-color: #fff;
        border-style: solid;
        border-width: 0 2px 2px 0;
        top: 10px;
        left: 16px;
        transform: rotate(45deg);
        height: 15px;
        width: 7px;
    }

    .close {
        position: absolute;
        right: 0;
        top: 0;
        padding: 12px 16px 12px 16px;
    }

    .close:hover {
        background-color: #f44336;
        color: white;
    }

    .header {
        background-color: #ADC5FF;
        padding: 10px 40px;
        color: white;
        text-align: center;
        height: 8%;
    }

    .header:after {
        content: "";
        display: table;
        clear: both;
    }

     input {
        margin: 0;
        border: none;
        border-radius: 0;
        width: 75%;
        padding: 10px;
        float: left;
        font-size: 16px;
    }

    .addBtn {
        padding: 10px;
        width: 25%;
        background: #d9d9d9;
        color: #555;
        float: left;
        text-align: center;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
        border-radius: 0;
    }

    .addBtn:hover {
        background-color: #bbb;
    }
</style>

<mtt:mainlayout>
    <section>
        <form action="/diet" method="post">
            <div id="myDIV" class="header">
                <h2>My To Do List</h2>
                <input type="text" id="myInput" placeholder="Title...">
                <span onclick="newElement()" class="addBtn">Add</span>
            </div>

            <ul id="myUL">
                <li class="liwithclose">Hit the gym</li>
                <li class="liwithclose">Pay bills</li>
                <li class="liwithclose">Meet George</li>
                <li class="liwithclose">Buy eggs</li>
                <li class="liwithclose">Read a book</li>
                <li class="liwithclose">Organize office</li>
            </ul>
            <button type="submit">Approve</button>
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