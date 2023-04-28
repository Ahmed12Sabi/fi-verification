package ai.lentra.controller.configuration.roles;



import ai.lentra.dto.masterConfig.RolesDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.service.masterconfig.RolesConfigService;
import ai.lentra.serviceImpl.masterconfig.RoleConfigServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Validated
@RestController
@RequestMapping(value = "/role-config")
public class RoleConfigController {

	private final Logger logger = LoggerFactory.getLogger(RoleConfigController.class);
	@Autowired
	RolesConfigService rolesService;
	@PostMapping("")
	public ResponseEntity<ResponseDTO> saveRole( @RequestBody RolesDTO rolesDTO,
												 @RequestHeader(name = "Accept-Language",required=false) Locale locale) throws ResourceNotFoundException, DuplicateResourceException {
		logger.info("Entered into saveRole");
		return rolesService.saveRole(rolesDTO);
	}

	@PutMapping("")
	public ResponseEntity<ResponseDTO> updateRole( @RequestBody RolesDTO rolesDTO,@RequestHeader(name = "Accept-Language",required=false)  Locale locale)throws ResourceNotFoundException, DuplicateResourceException  {
		logger.info("Entered into updateRole");
		return rolesService.updateRole(rolesDTO);
	}

	@GetMapping("")
	public ResponseEntity<Object> getAllRoles() throws ResourceNotFoundException, DuplicateResourceException {
		logger.info("Entered into getAllRoles");
		return rolesService.getAllRoles();
	}

	@GetMapping("/{applicantId}")
	public ResponseEntity<Object> getRole(@PathVariable Long applicantId ,@RequestHeader(name = "Accept-Language",required=false) Locale locale)  throws ResourceNotFoundException, DuplicateResourceException {
		logger.info("Entered into getRole : ");
		return rolesService.getRole(applicantId);
	}

}
