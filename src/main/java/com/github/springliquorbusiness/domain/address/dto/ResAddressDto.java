package com.github.springliquorbusiness.domain.address.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResAddressDto {
    private String message;
    private String username;
    private AddressDto address;
}
