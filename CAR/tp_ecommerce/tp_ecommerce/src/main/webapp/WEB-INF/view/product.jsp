<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;


}

.price {
  color: grey;
  font-size: 22px;
}

.card button {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.card button:hover {
  opacity: 0.7;
}


#card {
  column-count: 4;

}

ul {
  position: relative;
  display: flex;
  flex: 1 1 auto;
  margin: 0;
  padding: 0 30px;
  list-style-type: none;
  li:not(:last-child) {
    margin-right: 40px;
  }
  li {
    border: 2px solid transparent;
    border-radius: 5px;
    padding: 10px;
    transition: background 0.2s;
    a {
      color: #2375D8;
      text-decoration: none;
      text-transform: uppercase;
      transition: color 0.2s;
    }
    ul {
      visibility: hidden;
      opacity: 0;
      position: absolute;
      display: block;
      margin: 12px -12px;
      padding: 0;
      background: #FFA91B;
      border: 2px solid #F7C833;
      border-right: 2px solid #F89329;
      border-bottom: 2px solid #F89329;
      border-radius: 5px;
      transition: opacity 0.2s, visibility 0.2s;
      li {
        margin: -2px 0 0 -2px;
        width: calc(100% - 20px);
        line-height: 1.7;
        a {
          color: #2375D8;
        }
      }
    }
    &:hover {
      background: #EC4138;
      border: 2px solid #F05749;
      border-right: 2px solid #E02A21;
      border-bottom: 2px solid #E02A21;
      a {
        color: #F9F8FD;
      }
      ul {
        visibility: visible;
        opacity: 1;
        box-shadow: 0px 3px 5px 2px #EBECF1;
        li {
          a {
            color: #F9F8FD;
          }
        }
      }
    }
  }
}

@keyframes slide-in {
  0% {
    top: -50px;
  }
  40% {
    top: 20px;
  }
  70% {
    top: 10px;
  }
  100% {
    top: 15px;
  }
}


</style>
</head>
<body>
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="/home">shop</a>
      </div>

      <ul class="nav navbar-nav navbar-right">
        <li><a href="/login"><span class="glyphicon glyphicon-user"></span> S'inscrire </a></li>
        <li><a href="/signinForm"><span class="glyphicon glyphicon-log-in"></span> Se connecter </a></li>
      </ul>
    </div>
  </nav>

<div id="card">
<c:forEach items="${prods}" var="prod">
<div class="card">
  <img src="img/${prod.nomProduit}.jpg" alt="Denim Jeans" style="width:100%">
  <h1>${prod.nomProduit}</h1>
  <p class="price">${prod.prix} &#8364</p>
  <p>${prod.description}</p>
  <p><button>Ajouter au panier</button></p>
</div>
</c:forEach>
</div>
