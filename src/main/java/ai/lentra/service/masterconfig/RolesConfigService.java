package ai.lentra.service.masterconfig;


import ai.lentra.dto.masterconfig.RolesDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.Locale;

public interface RolesConfigService {
    ResponseEntity<ResponseDTO> saveRole(RolesDTO rolesDTO) throws ResourceNotFoundException, DuplicateResourceException;

    public ResponseEntity<ResponseDTO> updateRole(RolesDTO rolesDTO) throws ResourceNotFoundException, DuplicateResourceException;

    public ResponseEntity<Object>getAllRoles() throws ResourceNotFoundException, DuplicateResourceException;

    public ResponseEntity<Object> getRole(Long applicantId) throws ResourceNotFoundException, DuplicateResourceException;


}
