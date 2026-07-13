package com.taskkids.TasKKids.service;

import com.taskkids.TasKKids.entity.ChildrenEntity;
import com.taskkids.TasKKids.entity.ParentsEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.taskkids.TasKKids.repository.ParentsRepository;
import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentsService {

    private final ParentsRepository parentsRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public List<ParentsEntity> getAll() {
        return parentsRepository.findAll();
    }

    public ParentsEntity create(ParentsEntity newParent) {
        if (parentsRepository.findByEmail(newParent.getEmail()) != null) {
            throw new IllegalArgumentException("Cet email est déjà utilisé.");
        }
        newParent.setPassword(bCryptPasswordEncoder.encode(newParent.getPassword()));
        return parentsRepository.save(newParent);
    }

    public ParentsEntity login(String email, String password) {
        ParentsEntity parent = parentsRepository.findByEmail(email);

        if (parent == null || !passwordMatches(password, parent.getPassword())) {
            throw new IllegalArgumentException("Identifiants incorrects.");
        }

        if (!parent.getPassword().startsWith("$2")) {
            parent.setPassword(bCryptPasswordEncoder.encode(password));
            return parentsRepository.save(parent);
        }

        return parent;
    }

    private boolean passwordMatches(String rawPassword, String storedPassword) {
        if (rawPassword == null || storedPassword == null) {
            return false;
        }

        if (storedPassword.startsWith("$2")) {
            return bCryptPasswordEncoder.matches(rawPassword, storedPassword);
        }

        return rawPassword.equals(storedPassword);
    }

    public ParentsEntity getById(Long parentId) {
        Optional<ParentsEntity> optionalParent = parentsRepository.findById(parentId);
        if (optionalParent.isEmpty()) {
            throw new EntityNotFoundException("Parent introuvable.");
        }
        return optionalParent.get();
    }


    public ParentsEntity update(Long parentId, ParentsEntity updatedParent) {
        ParentsEntity parent = getById(parentId);

        parent.setEmail(updatedParent.getEmail());
        parent.setPassword(updatedParent.getPassword());
        parent.setNickname(updatedParent.getNickname());
        parent.setPicture(updatedParent.getPicture());

        return parentsRepository.save(parent);
    }


    public ParentsEntity addChildToParent(Long id, ChildrenEntity newChild) {
        ParentsEntity parent = this.getById(id);
        parent.getChildren().add(newChild);
        return parentsRepository.save(parent);
    }

}





    
