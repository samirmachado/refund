package br.com.zup.refund.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.refund.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
