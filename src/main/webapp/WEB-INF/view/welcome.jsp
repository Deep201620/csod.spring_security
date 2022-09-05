<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>
<body>
<div id="nav-placeholder">

</div>
<h1>Welcome User!</h1>
<a href="../logout"/>Logout</a>
 <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>
$.get("navbar.html", function(data){
    $("#nav-placeholder").replaceWith(data);
});
</script>
   <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<body>
</html>