package com.marhashoft.repositories;

import com.marhashoft.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    public User getUserById(Long id) {

        if (id == null) {
            throw new RuntimeException("Por favor, informe um id para pesquisar");
        }

        Optional<User> user = getAll().stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

        if (!user.isPresent() ) {
            throw new RuntimeException("Registro não encontrado com o id: "+id);
        }

        return user.get();

    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Moab", "moab@gmail.com"));
        users.add(new User(2L, "Pedro", "pedro@gmail.com"));
        users.add(new User(3L, "Samuel", "samuel@gmail.com"));

        return users;
    }

    public void save(User user) {
        if (user.getId() != null) {
            System.out.println("Usuário atualizado com sucesso!");
        }
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void delete(User user) {
        System.out.println("Usuário deletado com sucesso!");
    }
}
