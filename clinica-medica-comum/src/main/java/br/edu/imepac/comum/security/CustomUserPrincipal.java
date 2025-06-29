package br.edu.imepac.comum.security;

import br.edu.imepac.comum.models.Funcionario;
import br.edu.imepac.comum.models.Perfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserPrincipal implements UserDetails {

    private final Funcionario funcionario;

    public CustomUserPrincipal(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        Perfil perfil = funcionario.getPerfil();
        if (perfil != null) {
            if (perfil.isCadastrarFuncionario()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.CADASTRAR_FUNCIONARIO));
            }
            if (perfil.isLerFuncionario()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LER_FUNCIONARIO));
            }
            if (perfil.isAtualizarFuncionario()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.ATUALIZAR_FUNCIONARIO));
            }
            if (perfil.isDeletarFuncionario()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.DELETAR_FUNCIONARIO));
            }
            if (perfil.isListarFuncionario()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LISTAR_FUNCIONARIO));
            }

            if (perfil.isCadastrarPaciente()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.CADASTRAR_PACIENTE));
            }
            if (perfil.isLerPaciente()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LER_PACIENTE));
            }
            if (perfil.isAtualizarPaciente()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.ATUALIZAR_PACIENTE));
            }
            if (perfil.isDeletarPaciente()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.DELETAR_PACIENTE));
            }
            if (perfil.isListarPaciente()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LISTAR_PACIENTE));
            }

            if (perfil.isCadastrarConsulta()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.CADASTRAR_CONSULTA));
            }
            if (perfil.isLerConsulta()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LER_CONSULTA));
            }
            if (perfil.isAtualizarConsulta()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.ATUALIZAR_CONSULTA));
            }
            if (perfil.isDeletarConsulta()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.DELETAR_CONSULTA));
            }
            if (perfil.isListarConsulta()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LISTAR_CONSULTA));
            }

            if (perfil.isCadastrarEspecialidade()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.CADASTRAR_ESPECIALIDADE));
            }
            if (perfil.isLerEspecialidade()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LER_ESPECIALIDADE));
            }
            if (perfil.isAtualizarEspecialidade()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.ATUALIZAR_ESPECIALIDADE));
            }
            if (perfil.isDeletarEspecialidade()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.DELETAR_ESPECIALIDADE));
            }
            if (perfil.isListarEspecialidade()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LISTAR_ESPECIALIDADE));
            }
            if (perfil.isCadastrarConvenio()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.CADASTRAR_CONVENIO));
            }
            if (perfil.isLerConvenio()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LER_CONVENIO));
            }
            if (perfil.isAtualizarConvenio()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.ATUALIZAR_CONVENIO));
            }
            if (perfil.isDeletarConvenio()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.DELETAR_CONVENIO));
            }
            if (perfil.isListarConvenio()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LISTAR_CONVENIO));
            }

            if (perfil.isCadastrarProntuario()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.CADASTRAR_PRONTUARIO));
            }
            if (perfil.isLerProntuario()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LER_PRONTUARIO));
            }
            if (perfil.isAtualizarProntuario()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.ATUALIZAR_PRONTUARIO));
            }
            if (perfil.isDeletarProntuario()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.DELETAR_PRONTUARIO));
            }
            if (perfil.isListarProntuario()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LISTAR_PRONTUARIO));
            }

            if (perfil.isCadastrarPerfil()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.CADASTRAR_PERFIL));
            }
            if (perfil.isLerPerfil()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LER_PERFIL));
            }
            if (perfil.isAtualizarPerfil()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.ATUALIZAR_PERFIL));
            }
            if (perfil.isDeletarPerfil()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.DELETAR_PERFIL));
            }
            if (perfil.isListarPerfil()) {
                authorities.add(new SimpleGrantedAuthority(Permissao.LISTAR_PERFIL));
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return funcionario.getSenha();
    }

    @Override
    public String getUsername() {
        return funcionario.getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
