package br.com.origin.test.domain;

import br.com.origin.test.domain.enums.OwnershipStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {

    private OwnershipStatus ownershipStatus;

}
