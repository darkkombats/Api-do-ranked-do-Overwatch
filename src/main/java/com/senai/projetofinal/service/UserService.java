package com.senai.projetofinal.service;


import com.senai.projetofinal.model.Ranked;
import com.senai.projetofinal.model.User;
import com.senai.projetofinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        List<User> user = userRepository.findAll();
        return user;
    }

    @Transactional
    public User cadastrarUser(User user){
        Ranked ranked1 = new Ranked(1);
        Ranked ranked2 = new Ranked(2);
        Ranked ranked3 = new Ranked(3);
        Ranked ranked4 = new Ranked(4);
        Ranked ranked5 = new Ranked(5);
        Ranked ranked6 = new Ranked(6);
        Ranked ranked7 = new Ranked(7);

        if(user.getPontos()<=1499){
            user.setRanked(ranked1);
        } else if(user.getPontos()<=1999) {
            user.setRanked(ranked2);
        } else if (user.getPontos()<=2499) {
            user.setRanked(ranked3);
        } else if (user.getPontos()<=2999) {
            user.setRanked(ranked4);
        } else if (user.getPontos()<=3499) {
            user.setRanked(ranked5);
        } else if (user.getPontos()<=3999) {
            user.setRanked(ranked6);
        } else {
            user.setRanked(ranked7);
        }

        return userRepository.save(user);
    }

    public Optional<User> listarUser (Integer id){
        return  userRepository.findById(id);
    }

    @Transactional
    public void removerUser (Integer id){
        userRepository.deleteById(id);
    }
}
