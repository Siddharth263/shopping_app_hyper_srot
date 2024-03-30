package com.hypersrot.shoppingapp.repository;

import com.hypersrot.shoppingapp.modals.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
