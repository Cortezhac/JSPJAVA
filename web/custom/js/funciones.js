var memoriaDui = document.getElementById("dui");
var memoriaNombre = document.getElementById("nombre");
var memoriaApellido = document.getElementById("apellido");

function editarDui(){
    var boton = document.getElementById("editar");
    var dui = document.getElementById("txtDui");
    var apellidos = document.getElementById("txtApellidos");
    var nombre = document.getElementById("txtNombre");
    console.log("Memoria dui: " + memoriaDui);

    if(dui.disabled == false){// Si cancela la edicion de DUI
        dui.setAttribute("disabled", true);
        dui.value = memoriaDui.value; //campos de rastauracion
        apellidos.value = memoriaApellido.value; //campos de rastauracion
        nombre.value = memoriaNombre.value; //campos de rastauracion
        apellidos.removeAttribute("disabled");
        nombre.removeAttribute("disabled");
        boton.value = "Editar"
    }else {// SI desea editar el dui
        dui.removeAttribute("disabled");
        apellidos.setAttribute("disabled", true);
        nombre.setAttribute("disabled", true);
        boton.value = "Cancelar";
    }
}