package com.farmer.farmermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
	private String street;
	private String city;
	private String district;
	private String state;
	private String pincode;
    public void setVillage(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVillage'");
    }
	public Object getVillage() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getVillage'");
	}
}
