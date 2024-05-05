package com.github.springliquorbusiness.domain.address.service;

import com.github.springliquorbusiness.domain.address.dto.AddressDto;
import com.github.springliquorbusiness.domain.address.dto.ResAddressDto;
import com.github.springliquorbusiness.domain.address.entity.AddressEntity;
import com.github.springliquorbusiness.domain.address.repository.AddressRepository;
import com.github.springliquorbusiness.domain.user.entity.UserEntity;
import com.github.springliquorbusiness.domain.user.repository.UserRepository;
import com.github.springliquorbusiness.exception.AppException;
import com.github.springliquorbusiness.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public List<AddressDto> getAddressesByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(
                () -> new AppException(ErrorCode.USER_EMAIL_NOT_FOUND.getMessage(), ErrorCode.USER_EMAIL_NOT_FOUND)
        );

        List<AddressEntity> address = addressRepository.findAllByUser(user);

        return address.stream().map(AddressDto::toAddressDto).toList();
    }

    @Transactional
    public ResAddressDto addAddress(AddressDto addressDto, String userId) {
        UserEntity user = userRepository.findByEmail(userId).orElseThrow(
                () -> new AppException(ErrorCode.USER_EMAIL_NOT_FOUND.getMessage(), ErrorCode.USER_EMAIL_NOT_FOUND)
        );

        AddressEntity address = AddressEntity.toEntity(user, addressDto);

        if (addressDto.getIsDefault()) user.setDefaultAddress(address);

        addressRepository.save(address);

        return new ResAddressDto("배송지가 등록되었습니다.", user.getUsername(), addressDto);
    }

    @Transactional
    public ResAddressDto updateAddress(Long addressIdx, AddressDto modifiedAddress, String email) {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(
                () -> new AppException(ErrorCode.USER_EMAIL_NOT_FOUND.getMessage(), ErrorCode.USER_EMAIL_NOT_FOUND)
        );

        AddressEntity address = addressRepository.findById(addressIdx).orElseThrow(
                () -> new AppException(ErrorCode.ADDRESS_NOT_FOUND.getMessage(), ErrorCode.ADDRESS_NOT_FOUND)
        );

        if (modifiedAddress.getIsDefault()) user.setDefaultAddress(address);

        address.update(modifiedAddress);

        return new ResAddressDto("배송지가 수정되었습니다.", user.getUsername(), modifiedAddress);
    }
}
