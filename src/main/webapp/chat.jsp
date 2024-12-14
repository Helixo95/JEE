<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 String username = request.getParameter("username");
  if (username == null || username.isEmpty()) {
    response.sendRedirect("login.jsp");
    return;
  }
%>
<!DOCTYPE html>
<html>
<head>
  <title>Chat - WebSocket</title>
</head>
<body>
<h3>Bienvenue, <%= username %>!</h3>
<textarea id="output" rows="10" cols="50" readonly></textarea><br>
<input type="text" id="message" placeholder="Entrez un message">
<button onclick="sendMessage()">Envoyer</button>
<button onclick="closeSocket()">Fermer</button>

<script type="text/javascript">
  const username = "<%= username %>";
  const socket = new WebSocket("ws://localhost:8080/websocket_war_exploded/text");

  socket.onopen = () => {
    socket.send(JSON.stringify({ username: username, message: "Joined the conversation ! " }));
  };

  socket.onmessage = (event) => {
    const data = JSON.parse(event.data); // Analyse le message JSON
    document.getElementById("output").value += data.username + " : " + data.message + "\n";
  };

  socket.onclose = () => {
    socket.send(JSON.stringify({ username: username, message: "Left the conversation..." }));
  };

  function sendMessage() {
    const message = document.getElementById("message").value;
    const payload = JSON.stringify({ username: username, message: message });
    socket.send(payload);
    document.getElementById("message").value = ""; // Efface le champ de saisie
  }

  function closeSocket() {
    socket.send(JSON.stringify({ username: username, message: "Left the conversation..." }));
    socket.close();
    window.location.replace('login.jsp');
  }
</script>
</body>
</html>
