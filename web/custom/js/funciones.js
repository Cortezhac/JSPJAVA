var memoriaDui = document.getElementById("dui");
var memoriaNombre = document.getElementById("nombre");
var memoriaApellido = document.getElementById("apellido");

function editarDui(){
    var boton = document.getElementById("editar");
    var dui = document.getElementById("txtDui");
    var apellidos = document.getElementById("txtApellidos");
    var nombre = document.getElementById("txtNombre");
    console.log("Memoria dui: " + memoriaDui.value);

    if(dui.getAttribute("readonly") == null){// Si cancela la edicion de DUI

        dui.setAttribute("readonly", true);
        dui.value = memoriaDui.value; //campos de rastauracion
        apellidos.value = memoriaApellido.value; //campos de rastauracion
        nombre.value = memoriaNombre.value; //campos de rastauracion
        apellidos.removeAttribute("readonly", false);
        nombre.removeAttribute("readonly", false);
        boton.value = "Editar"
    }else {// SI desea editar el dui
        console.log(dui.getAttribute("readonly"));
        dui.removeAttribute("readonly", false);
        apellidos.setAttribute("readonly", true);
        nombre.setAttribute("readonly", true);
        boton.value = "Cancelar";
    }
}