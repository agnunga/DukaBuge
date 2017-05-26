<form class="well form-horizontal" action="login" method="post"
      id="contact_form" style="max-width: 700px; margin: 50px auto auto auto;">
    <fieldset>
        <legend style="text-align: center;">Welcome, Login</legend>
         <div class="form-group">
            <label class="col-md-4 control-label">Username: </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="username" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Password: </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group"> 
                    <input name="password" placeholder="" class="form-control" type="password" required>
                </div>
            </div>
        </div>
        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <button type="submit" class="btn btn-warning">
                    Sign In <span class=""></span>
                </button>
            </div>
        </div>
        <div style="text-align: right;">
            <p>Have no account? <a href="register">Register Here</a></p>
        </div>
    </fieldset>
</form>
