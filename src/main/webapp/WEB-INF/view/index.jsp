<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>
<body>
<div id="nav-placeholder">

</div>
<h2 style="margin: 20%;">Hello User</h2>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
 <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>
$.get("navbar", function(data){
    $("#nav-placeholder").replaceWith(data);
});
</script>
</body>
</html>