let hideEmployeeSavedAlertTimer = undefined;

document.addEventListener("DOMContentLoaded", () => {
	// TODO: Things that need doing when the view is loaded

	document.getElementById("saveEmployeeDetail").addEventListener("click", saveActionClick())
});

// Save
function saveActionClick(event) {
	// TODO: Actually save the employee via an AJAX call
	// Validate input
		// Display appropriate error,focus element, stop saving
	if(document.getElementById("employeeFirstName").value == "") {

		document.getElementById("employeeFirstName").focus();
	}
	if(document.getElementById("employeeLastName").value == "") {

		document.getElementById("employeeLastName").focus();
	}
	if(document.getElementById("employeePassword").value == "" || 
	   document.getElementById("employeePassword").value != document.getElementById("employeeConfirmPassword").value) {

		document.getElementById("employeePassword").focus();
	}
	if(document.getElementById("employeeClassification").value != (101 || 501 || 701)) {

		document.getElementById("employeeClassification").focus();
	}
	displayEmployeeSavedAlertModal();
}

function displayEmployeeSavedAlertModal() {
	if (hideEmployeeSavedAlertTimer) {
		clearTimeout(hideEmployeeSavedAlertTimer);
	}

	const savedAlertModalElement = getSavedAlertModalElement();
	savedAlertModalElement.style.display = "none";
	savedAlertModalElement.style.display = "block";

	hideEmployeeSavedAlertTimer = setTimeout(hideEmployeeSavedAlertModal, 1200);
}

function hideEmployeeSavedAlertModal() {
	if (hideEmployeeSavedAlertTimer) {
		clearTimeout(hideEmployeeSavedAlertTimer);
	}

	getSavedAlertModalElement().style.display = "none";
}
// End save

//Getters and setters
function getSavedAlertModalElement() {
	return document.getElementById("employeeSavedAlertModal");
}
//End getters and setters
