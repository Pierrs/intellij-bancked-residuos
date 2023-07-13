package com.sistema.residuos.exceptiones;

import com.sistema.residuos.modelo.Usuario;

public class UsuarioFoundException extends Exception  {
    public UsuarioFoundException(){
        super("El usuario con ese username ya existo en la base de datos, vuelva a intentarlo");
    }
    public UsuarioFoundException(String mensaje){
        super(mensaje);

    }
}
