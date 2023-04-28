package ai.lentra.serviceImpl.masterconfig;



//import ai.lentra.core.i18n.api.I18nHelper;
import ai.lentra.config.I18nMessageKeys;
import ai.lentra.core.i18n.api.I18nHelper;
import ai.lentra.dto.masterConfig.RolesDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.masterconfig.RolesEntity;
import ai.lentra.repository.masterconfig.RolesRepository;
import ai.lentra.service.masterconfig.RolesConfigService;
import ai.lentra.utils.Level;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static ai.lentra.commons.ResponeGen.getResponse;

@Service
public class RoleConfigServiceImpl implements RolesConfigService {

    private final Logger logger = LoggerFactory.getLogger(RoleConfigServiceImpl.class);
    @Autowired
    RolesRepository repository;

    @Autowired
    MessageSource messageSource;

    @Override
    public ResponseEntity<ResponseDTO> saveRole(RolesDTO rolesDTO) throws ResourceNotFoundException, DuplicateResourceException
    {
            try{
            if(rolesDTO.getRoleName().trim().isEmpty() || rolesDTO.getVmsRoleName().trim().isEmpty() || ( rolesDTO.getStatus() == null) ){
                if(rolesDTO.getStatus() == null ){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(400,I18nHelper.msg(I18nMessageKeys.status_not_null),"ERROR"));
                }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(400,I18nHelper.msg(I18nMessageKeys.name_role_not_null),"ERROR"));
            }}
            catch (Exception e){
                logger.info(" saveRole : "+e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(400,I18nHelper.msg(I18nMessageKeys.something_went_wrong) , "ERROR"));
            }
            Long role = repository.countByRoleNameAndVmsRoleName(rolesDTO.getRoleName(),rolesDTO.getVmsRoleName());
            ObjectMapper objectMapper = new ObjectMapper();
            RolesEntity roles = objectMapper.convertValue(rolesDTO, RolesEntity.class);
        Level level = Level.LOW;
            if (role > 0) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(getResponse(403, I18nHelper.msg(I18nMessageKeys.role_already_mapped),"ERROR"));

            }else if(role == 0){
                Long vmsRoleCount =repository.countByRoleName(rolesDTO.getRoleName());
                Optional<RolesEntity> optionalDuplicate = Optional.ofNullable(repository.findByRoleName(rolesDTO.getRoleName()));
                if(( vmsRoleCount>0 && optionalDuplicate.get().getVmsRoleName().substring(3,10).equals(rolesDTO.getVmsRoleName().substring(3,10))) ){
                    repository.save(roles);
                }else if(( vmsRoleCount>0 && !(optionalDuplicate.get().getVmsRoleName().substring(3,10).equals(rolesDTO.getVmsRoleName().substring(3,10))))){
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(getResponse(403,"Role is not mapping to related VMS role","ERROR"));
                }else{
                    repository.save(roles);
                }
            }


            return ResponseEntity.status(HttpStatus.CREATED).body(getResponse(201,"Role has been added successfully ","CREATED"));

    }

    @Override
    public ResponseEntity<ResponseDTO> updateRole(RolesDTO rolesDTO) throws ResourceNotFoundException, DuplicateResourceException
    {
        try{
            try{
                if(rolesDTO.getRoleName().trim().isEmpty() || rolesDTO.getVmsRoleName().trim().isEmpty() || ( rolesDTO.getStatus() == null) ){
                    if(rolesDTO.getStatus() == null ){
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(400,"Status should not be null / empty ","ERROR"));
                    }
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(400,"Role name / Vms role name should not be blank ","ERROR"));
                }}
            catch (Exception e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(400,"Role name / Vms role name should not be null ","ERROR"));
            }
            Optional<RolesEntity> optionalRole = Optional.ofNullable(repository.findByRoleId(rolesDTO.getRoleId()));
            if (!optionalRole.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Role Not Found ","ERROR"));
            }

            RolesEntity existingRoles = optionalRole.get();
            if (rolesDTO.getRoleName() != null) {
                existingRoles.setRoleName(rolesDTO.getRoleName());
            }
            if (rolesDTO.getVmsRoleName() != null) {
                existingRoles.setVmsRoleName(rolesDTO.getVmsRoleName());
            }
            if (rolesDTO.getStatus() != null) {
                existingRoles.setStatus(rolesDTO.getStatus());
            }
            Long optionalDuplicate =repository.countByRoleIdAndRoleNameAndVmsRoleName(existingRoles.getRoleId(),existingRoles.getRoleName(),existingRoles.getVmsRoleName());
            if (optionalDuplicate>0) {
                repository.save(existingRoles);
            }else{
            Long role = repository.countByRoleNameAndVmsRoleName(rolesDTO.getRoleName(),rolesDTO.getVmsRoleName());
            ObjectMapper objectMapper = new ObjectMapper();
            RolesEntity roles = objectMapper.convertValue(rolesDTO, RolesEntity.class);
            if (role > 0) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(getResponse(403,messageSource.getMessage("role_already_mapped",null,Locale.US),"ERROR"));
                //return ResponseEntity.status(HttpStatus.FORBIDDEN).body(getResponse(403,"This Role Already mapped ","ERROR"));
            }else if(role == 0){
                Long vmsRoleCount =repository.countByRoleName(rolesDTO.getRoleName());
                List<RolesEntity> optionalDuplicates = repository.findAllByRoleName(rolesDTO.getRoleName());
                for(RolesEntity optionalDuplicat : optionalDuplicates) {
                    Optional<RolesEntity> optional = Optional.ofNullable(optionalDuplicat);
                    if ((vmsRoleCount > 0 && !(optional.get().getVmsRoleName().substring(3, 10).equalsIgnoreCase(rolesDTO.getVmsRoleName().substring(3, 10))))) {
                        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(getResponse(403, "Role is not mapping to related VMS role", "ERROR"));
                    }
                    }
                repository.save(existingRoles);
                }
            }

            return ResponseEntity.status(HttpStatus.OK).body(getResponse(200,"Role has been updated successfully ","CREATED"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getResponse(500,"error while updating role config ","ERROR"));
        }
    }

    @Override
    public ResponseEntity<Object> getAllRoles() throws ResourceNotFoundException, DuplicateResourceException
    {
        try{
        List<RolesEntity> rolesEntity =repository.findAll();
            // return  repository.findAll() ; //ResponseEntity.status(HttpStatus.OK).body(a.getData());
           return ( rolesEntity == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404," no results" ,"ERROR")) : ResponseEntity.status(HttpStatus.OK).body(rolesEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getResponse(500,"error while fetching role config data","ERROR"));
        }
    }

    @Override
    public ResponseEntity<Object> getRole(Long applicantId ) throws ResourceNotFoundException, DuplicateResourceException
    {
        RolesEntity rolesEntity = repository.findByRoleId(applicantId);
        return (rolesEntity == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Role Not Found " ,"ERROR")) : ResponseEntity.status(HttpStatus.OK).body(rolesEntity));
    }

}
