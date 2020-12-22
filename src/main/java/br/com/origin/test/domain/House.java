package br.com.origin.test.domain;

import br.com.origin.test.domain.enums.OwnershipStatus;
import lombok.Data;

@Data
public class House {

    private OwnershipStatus ownershipStatus;

}
