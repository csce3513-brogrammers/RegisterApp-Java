document.addEventListener("DOMContentLoaded", function(event) {
	// TODO: Anything you want to do when the page is loaded?
});

function validateForm() {
	// TODO: Validate the user input
	var x = document.forms['signInForm'].employee.value;
	var y = document.forms['signInForm'].password.value;
	    if (x == "" || y == ""){
            if (x == "" && y == ""){
                text = "The Employee ID field must not be empty. The password field must not be empty.";
                document.getElementById("validation").innerHTML = text;
            }
            else if (x == ""){
                text = "The Employee field must not be empty. "
                document.getElementById("validation").innerHTML = text;
            }
            else if (y == ""){
                text = "The password field must not be empty. ";
                document.getElementById("validation").innerHTML = text;
            }
            document.getElementById("validation").style.visibility = "visible";
            return false;
        }
	return true;
}
