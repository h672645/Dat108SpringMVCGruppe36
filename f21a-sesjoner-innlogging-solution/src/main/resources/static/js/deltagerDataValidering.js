/**
 * Validerer data i skjema.
 */

 function validatePasswordMatch() {
  var password = document.getElementById("passord").value;
  var confirmPassword = document.getElementById("passordRepetert").value;
  var errorDiv = document.getElementById("passwordError");

  if (password !== confirmPassword) {
    errorDiv.innerText = "Passwords do not match. Please re-enter.";
    return false;
  } else {
    errorDiv.innerText = "";
  }

  return true;
}

function validateFornavn() {
  var fornavn = document.getElementById("fornavn").value;
  var fornavnPattern = /^[A-Za-z\s-]{2,20}$/;
  var errorDiv = document.getElementById("fornavnError");

  if (!fornavnPattern.test(fornavn)) {
    errorDiv.innerText = "Fornavn must be 2-20 characters long and only contain letters, spaces, or dashes";
    return false;
  } else {
    errorDiv.innerText = "";
  }

  return true;
}

function validateEtternavn() {
  var etternavn = document.getElementById("etternavn").value;
  var etternavnPattern = /^[A-Za-z\s-]{2,20}$/;
  var errorDiv = document.getElementById("etternavnError");

  if (!etternavnPattern.test(etternavn)) {
    errorDiv.innerText = "Etternavn must be 2-20 characters long and only contain letters, spaces, or dashes";
    return false;
  } else {
    errorDiv.innerText = "";
  }

  return true;
}

function validateMobil() {
  var mobil = document.getElementById("mobil").value;
  var mobilPattern = /^[0-9]{8}$/;
  var errorDiv = document.getElementById("mobilError");

  if (!mobilPattern.test(mobil)) {
    errorDiv.innerText = "Mobil must contain exactly 8 numbers";
    return false;
  } else {
    errorDiv.innerText = "";
  }

  return true;
}

function validateKjonn() {
  var kjonnRadios = document.getElementsByName("kjonn");
  var errorDiv = document.getElementById("kjonnError");
  var selectedKjonn = false;

  for (var i = 0; i < kjonnRadios.length; i++) {
    if (kjonnRadios[i].checked) {
      selectedKjonn = true;
      break;
    }
  }

  if (!selectedKjonn) {
    errorDiv.innerText = "Please select a gender (mann or kvinne)";
    return false;
  } else {
    errorDiv.innerText = "";
  }

  return true;
}

