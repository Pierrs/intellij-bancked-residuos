package com.sistema.residuos.exceptiones;

public class UsuarioNotFoundException extends Exception {
    public UsuarioNotFoundException(){
        super("El usuario con ese username no existo en la base de datos, vuelva a intentarlo");
    }
    public UsuarioNotFoundException(String mensaje){
        super(mensaje);

    }
}
