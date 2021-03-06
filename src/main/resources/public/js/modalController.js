
const toggleModal = (element) => {
  var modal = document.getElementById("mainModal-" + element.id);
  modal.style.display = "block";
  // Get the button that opens the modal
  // Get the <span> element that closes the modal
  const span = document.getElementById("closing-"+element.id);

  // When the user clicks on <span> (x), close the modal
  span.onclick = function () {
    modal.style.display = "none";
  }

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function (event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }

};