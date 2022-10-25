package org.serratec.ecommerce.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.serratec.ecommerce.api.domain.Perfil;
import org.serratec.ecommerce.api.domain.Usuario;
import org.serratec.ecommerce.api.domain.UsuarioPerfil;
import org.serratec.ecommerce.api.domain.dto.UsuarioDTO;
import org.serratec.ecommerce.api.domain.dto.UsuarioInserirDTO;
import org.serratec.ecommerce.api.repository.UsuarioRepository;
import org.serratec.ecommerce.api.security.EmailException;
import org.serratec.ecommerce.api.security.SenhaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    BCryptPasswordEncoder encoder;	
    
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
        for (Usuario usuario : usuarios) {
            usuariosDTO.add(new UsuarioDTO(usuario));
        }
        return usuariosDTO;

    }

    public Usuario inserir(Usuario user) throws EmailException {
        Usuario usuario = usuarioRepository.findByEmail(user.getEmail());
        if (usuario != null) {
            throw new EmailException("Email já existente");
        }
        return usuarioRepository.save(user);
    }
    @Transactional
    public UsuarioDTO inserir(UsuarioInserirDTO user) throws EmailException {
        if (!user.getSenha().equalsIgnoreCase(user.getConfirmaSenha())) {
            throw new SenhaException("Senha e Confirma Senha não são iguais");
        }
        if (usuarioRepository.findByEmail(user.getEmail()) != null) {
            throw new EmailException("Email já existente");
        }
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(user.getNome());
        usuario.setEmail(user.getEmail());
        usuario.setSenha(encoder.encode(user.getSenha()));
        
        Set<UsuarioPerfil> perfis = new HashSet<>();
        for (Perfil perfil : user.getPerfis()) {
            perfil = perfilService.buscar(perfil.getId());
            UsuarioPerfil usuarioPerfil = new UsuarioPerfil(usuario, perfil, LocalDate.now());
            perfis.add(usuarioPerfil);
        }
        usuario.setUsuarioPerfis(perfis);
        usuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }

}
