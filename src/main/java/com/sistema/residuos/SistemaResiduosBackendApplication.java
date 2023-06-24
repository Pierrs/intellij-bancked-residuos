package com.sistema.residuos;


import com.sistema.residuos.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaResiduosBackendApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(SistemaResiduosBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			/*
			Usuario usuario = new Usuario();

			usuario.setNombre("Pieers");
			usuario.setApellido("Del Aguila");
			usuario.setUsername("Pieers");
			usuario.setPassword("12345");
			usuario.setEmail("Pieers@gmail.com");
			usuario.setTelefono("988212020");
			usuario.setPerfil("foto.png");

			Rol rol = new Rol();
			rol.setRolId(2L);
			rol.setRolNombre("ADMIN");

			Set<UsuarioRol> usuariosRoles = new HashSet<>();
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setRol(rol);
			usuarioRol.setUsuario(usuario);
			usuariosRoles.add(usuarioRol);

			Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario,usuariosRoles);
			System.out.println(usuarioGuardado.getUsername());

			 */

	}

}