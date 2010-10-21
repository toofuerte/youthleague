//Utah Polka Dots Form Validation Javascript Sheet
//By Gary Acton


function isRequired(e){
    var entryReq = /./;
    if (entryReq.test(e.value)) 
        return true;
    return false;
}

function isValidEmail(e){
    var validEmail = /^[^@]+@[^@.]+\.[^@]*\w\w$/;
    if (validEmail.test(e.value)) 
        return true;
    return false;
}

function isValidPass(e){
    var validPass = /^.{8,12}$/;
    if (validPass.test(e.value)) 
        return true;
    return false;
}

function isNumeric(e){
    var v = parseFloat(e.value);
    if (isNaN(v)) 
        return true;
    return false;
    
}

function ValidatePhone(e) 
{
      var regPhone = /^(\+\d)*\s*(\(\d{3}\)\s*)*\d{3}(-{0,1}|\s{0,1})\d{2}(-{0,1}|\s{0,1})\d{2}$/; 
        if (e.match(regPhone))
                return true;
        else
                return false;
}







function validate(f){
    var msg = "";
    for (var i = 0; i < f.length; i++) {
        var e = f.elements[i];
        if (e.style.backgroundColor) 
            e.style.backgroundColor = "white";
        
        var numeric = e.getAttribute("numeric");
        if (numeric) {
            if (!isNumeric(e)) {
                msg += generateErrorMessage(e, " must be numbers.")
                continue;
            }
        }
        
        var required = e.getAttribute("required");
        if (required) {
            if (!isRequired(e)) {
                msg += generateErrorMessage(e, " must be entered.");
                continue;
            }
        }
        
        var validEmail = e.getAttribute("validEmail");
        if (validEmail) {
            if (!isValidEmail(e)) {
                msg += generateErrorMessage(e, " Does not appear to be a valid e-mail address.");
                continue;
            }
        }
        
        var validPass = e.getAttribute("validPass");
        if (validPass) {
            if (!isValidPass(e)) {
                msg += generateErrorMessage(e, " Password must be between 8 and 12 characters.");
                continue;
            }
        }

        
         var phone = e.getAttribute("phone");
         if (phone) {
            if (!isValidatePhone(e)) {
               msg += generateErrorMessage(e, " must be valid.")
               continue;
            }
         }		
    }
    if (!msg) {
		return ("Thank You for creating an account with us")
		return true;
		
	}	
    return msg;
}

function generateErrorMessage(e, str){
    e.style.backgroundColor = "pale yellow";
    return ("* " + e.name + str + "<br />");
}


