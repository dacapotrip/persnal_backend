package com.persnal.persnal_backend.borad.dao;

import org.apache.ibatis.annotations.Mapper;

import com.persnal.persnal_backend.borad.domain.user.UserRequestDTO;

@Mapper
public interface UserMapper {

    public void saveUser(UserRequestDTO userRequestDTO);

    public UserRequestDTO findByEmail(String email);


}
