package com.onboading.intellipick.domain.user.repository;

import com.onboading.intellipick.domain.user.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
