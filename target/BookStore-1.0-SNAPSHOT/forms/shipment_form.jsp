<form class="well form-horizontal" action="shipment" method="post"
      id="contact_form" style="max-width: 900px; margin: 50px auto auto auto;">
    <fieldset>
        <legend style="text-align: center;">Shipment</legend>
         <div class="form-group">
            <label class="col-md-4 control-label">Origin </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="origin" placeholder="" class="form-control" type="text" >
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Shipment Cost </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="shipmentCost" placeholder="" class="form-control" type="text" >
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Destination </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="destination" placeholder="" class="form-control" type="text" >
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
            <label class="col-md-4 control-label">Shipment Time </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="shipmentDateTime" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Delivery Time </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="deliveryDateTime" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div>  
        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <button type="submit" class="btn btn-info">
                    Record <span class=""></span>
                </button>
            </div>
        </div>

    </fieldset>
</form>
