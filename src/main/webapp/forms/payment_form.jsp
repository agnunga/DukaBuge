<form class="well form-horizontal" action="pay" method="post"
      id="contact_form" style="max-width: 900px; margin: 50px auto auto auto;">
    <fieldset>
        <legend style="text-align: center;">Payment</legend>
         <div class="form-group">
            <label class="col-md-4 control-label">Amount </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="amount" placeholder="" class="form-control" type="text" >
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Order </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <select name="order">
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Payment Mode </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <select name="paymentMode">
                        <option value=""></option>
                    </select>
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Payment Time </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="paymentDatetime" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div>  
        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <button type="submit" class="btn btn-info">
                    Verify payment <span class=""></span>
                </button>
            </div>
        </div>

    </fieldset>
</form>
