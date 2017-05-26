<form class="well form-horizontal" action="add_catalog" method="post"
      id="contact_form" style="max-width: 900px; margin: 50px auto auto auto;">
    <fieldset>
        <legend style="text-align: center;">Add Catalog</legend>
         <div class="form-group">
            <label class="col-md-4 control-label">Name </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="name" placeholder="" class="form-control" type="text" >
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Number of Books </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="quantity" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div>  
        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <button type="submit" class="btn btn-info">
                    Add <span class=""></span>
                </button>
            </div>
        </div>

    </fieldset>
</form>
