package com.github.springliquorbusiness.domain.address.repository;

import com.github.springliquorbusiness.domain.address.entity.AddressEntity;
import com.github.springliquorbusiness.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    List<AddressEntity> findAllByUser(UserEntity user);
}
