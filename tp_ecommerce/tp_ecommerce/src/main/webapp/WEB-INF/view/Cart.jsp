<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="/continue" >DZ Shop</a>
      </div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="/continue" >Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <li><a href="/account"><span class="glyphicon glyphicon-user"></span> Mon compte</a></li>
        <li><a href="/cart"><span class="glyphicon glyphicon-shopping-cart"></span> Panier</a></li>
        <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Se deconnecter </a></li>
      </ul>
    </div>
  </nav>
<div class="container">
  <div class="row">
    <div class="col-sm-12 col-md-10 col-md-offset-1">
    <table class="table table-hover">
      <thead>
        <tr>
        <th>Produit</th>
        <th class="text-center">Prix</th>


        </tr>
      </thead>
      <tbody>
      <c:forEach items="${prods}" var="prod">
        <tr>
        <td class="col-sm-8 col-md-6">
        <div class="media">
          <a class="thumbnail pull-left" href="#"> <img class="media-object" src="../img/${prod.nomProduit}.jpg" style="width: 72px; height: 72px;"> </a>
          <div class="media-body">
            <h4 class="media-heading"><a href="#">${prod.nomProduit}</a></h4>
            <h5 class="media-heading">  <a href="#">${prod.description}</a></h5>
            <span>Statut: </span><span class="text-success"><strong>Quantit&eacute restante : ${prod.quantity}</strong></span>
          </div>
        </div></td>
        <td class="col-sm-1 col-md-1" style="text-align: center">
        </td>
        <td class="col-sm-1 col-md-1 text-center"><strong>${prod.prix} &#8364</strong></td>
        <td class="col-sm-1 col-md-1">
        <form action ="/remove/${prod.idProduct}">
        <button type="submit" class="btn btn-danger">
          <span class="glyphicon glyphicon-remove"></span> Enlever
        </button></form></td>
        </tr>
        </c:forEach>


        <td><h3>Total</h3></td>
        <td class="text-right"><h3><strong>${total}&#8364</strong></h3></td>
        </tr>
        <tr>
        <td></td>
        <td></td>
        <td></td>
        <td>
        <form action ="/continue">
        <button type="submit" class="btn btn-default">
          <span class="glyphicon glyphicon-shopping-cart"></span> Continuer les achats
        </button></form>
        </td>
        <td>
        <form action ="/valider">
        <button type="submit" class="btn btn-success">
          Valider la commande <span class="glyphicon glyphicon-play"></span>
        </button></form></td>
        </tr>
      </tbody>
    </table>
    </div>
  </div>
</div>
  </body>
