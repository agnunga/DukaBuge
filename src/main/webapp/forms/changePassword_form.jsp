
<form class="well form-horizontal" action="change_password" method="post"
      id="contact_form" style="max-width: 700px; margin: 50px auto auto auto;">
    <fieldset>
        <legend style="text-align: center;">Change Password</legend>
         <div class="form-group">
            <label class="col-md-4 control-label">Current Password: </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group"> 
                    <input name="password" placeholder="" class="form-control" type="password" required>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">New Password: </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group"> 
                    <input name="newPassword" placeholder="" class="form-control" type="password" required>
                </div>
            </div>
        </div>
        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <button type="submit" class="btn btn-warning">
                    Change Password <span class=""></span>
                </button>
            </div>
        </div>

    </fieldset>
</form>
