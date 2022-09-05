<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>
<body>
<div id="nav-placeholder">

</div>


<div class="container">
  <h2>Login form</h2>
 <form class="form-horizontal" action="/api/login" id="loginForm" method="post">
 <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-10">
        <input type="email" class="form-control" id="email" placeholder="Enter email" name="emailId" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-10">
        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" required>
      </div>
    </div>
     <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <input type="submit"  value="Submit" style="margin-top:10px;" class="btn btn-primary"/>
          </div>
        </div>
    </form>
    </div>

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