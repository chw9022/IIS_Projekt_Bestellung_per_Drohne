
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
	<head>
	  <meta charset="UTF-8">
	  <title>Create Order</title>
	  <style>
		/* Elemente positionieren und Formular ausrichten */
		label {
			min-width: 6em;
			display: inline-block;
			text-align: left;
		}
		input {
			width: 20em;
		}
		
		label {
			vertical-align: top;
		}
		button {
			width: 10em;
		}
		
		/* Formular optisch stylen.		  *
		 * Vorgehen: von innen nach auÃŸen */
		fieldset {
			width: 30em;
			padding-top: 1.5em;
			padding-left: 1.5em;
			background: #e6eeff;
			border: 1px solid #000330;
			border-radius: 5px;
		}
		legend {
			background: white;
			padding: 0.2em;
			border: 1px solid #000330;
			border-radius: 5px;
		}
		
		/* Interaktionen Ã¼ber Pseudoklassen */
		input:hover {
			background: #fffff0;
			border: 2px solid #efe816;
			box-shadow: 0 0 10px rgba(0,0,0,0.2);
		}
		button:hover {
			background: #c9c9c9;
			border: 2px solid #6c6c6c;
		}
		button:active {
			background: #8f8f8f;
		}
		

		/* Damit Felder nicht zu dicht folgen */
		form div { 
			padding: 0.2em; 
		}
	  </style>
	</head>
	<body>
		<c:if test="${orders != null}">
		<c:forEach items="${orders}" var="order">
			<br><em>Product : </em>${order.product}
			<br><em>Quantity: </em>${order.amount}
		</c:forEach>
		</c:if>
		<c:if test="${confirmed != null}">
			<p>${confirmed}</p>
		</c:if>
		<form id="myForm" method="post" action="createorder">
			<fieldset><legend>Create new order</legend>
				<input type="hidden" id="user" name="user" value="1" />
				<div>
				  <label for="product">Product:</label>
				  <select name="product" id="product">
				  	<option value="1;Tomaten">Tomaten<option>
				  	<option value="2;Bananen">Bananen<option>
				  	<option value="3;Fraenkische Bratwuerste">Fraenkische Bratwuerste<option>
				  </select>
				</div>
				<div>
				  <label for="quantity">Quantity:</label>
				  <input type="number" min="0" name="quantity" id="quantity" placeholder="Quantity" required>
				</div>

				<div>
				  <button name="add" value="add" type="submit">Bestellung hinzufügen</button>
				  <button name="completed" value="completed" type="submit">Bestellung abschließen</button>
				</div>
			</fieldset>
		</form>
		<footer class="foot"><br>Design based on: Wolf, JÃ¼rgen: HTML5 und CSS3, Das umfassende Handbuch, Bonn: Rheinwerk, 2015</footer>
	</body>
</html>