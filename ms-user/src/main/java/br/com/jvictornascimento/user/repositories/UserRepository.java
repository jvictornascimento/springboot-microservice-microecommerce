package br.com.jvictornascimento.user.repositories;

import br.com.jvictornascimento.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
