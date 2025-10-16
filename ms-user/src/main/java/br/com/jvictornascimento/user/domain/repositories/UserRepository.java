package br.com.jvictornascimento.user.domain.repositories;

import br.com.jvictornascimento.user.domain.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
