/* var modal = document.getElementById("mainModal");

// Get the button that opens the modal
var btn = document.getElementById("modify-addlink-button");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
btn.onclick = function () {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
} */

const toggleModal = (element) => {
  var modal = document.getElementById("mainModal-" + element.id);
  modal.style.display = "block";
  // Get the button that opens the modal
  //var btn = document.getElementById("modalToggle-" + element.id);
  console.log("JOtain tekee!")
  // Get the <span> element that closes the modal
  /* var span = document.getElementsByClassName("close")[0]; */
  const span = document.getElementById("test-"+element.id);

  // When the user clicks on the button, open the modal


  // When the user clicks on <span> (x), close the modal
  span.onclick = function () {
    modal.style.display = "none";
    console.log("Pitäisi mennä kiinni")
  }

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function (event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }

};