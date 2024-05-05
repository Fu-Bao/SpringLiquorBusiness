package com.github.springliquorbusiness.domain.address.dto;

import com.github.springliquorbusiness.domain.address.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {

    private String receiver;
    private String recPhone;
    private String addressName;
    private String address;
    private String addressDetail;
    private String zipcode;
    private Boolean isDefault;

    public static AddressDto toAddressDto(AddressEntity address) {
        return AddressDto.builder()
                .receiver(address.getReceiver())
                .recPhone(address.getRecPhone())
                .addressName(address.getAddressName())
                .address(address.getAddress())
                .addressDetail(address.getAddressDetail())
                .zipcode(address.getZipcode())
                .isDefault(address.getIsDefault())
                .build();
    }
}
