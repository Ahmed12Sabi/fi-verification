/*
package ai.lentra.service;


import ai.lentra.dto.commitment.CommitmentDTO;
import ai.lentra.modal.commitment.Commitment;
import ai.lentra.repository.commitment.CommitmentsRepository;
import ai.lentra.serviceImpl.commitments.CommitmentServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@SpringBootTest
// @RunWith(MockitoJUnitRunner.class)
@Scope("ai.lentra.service.*")
public class CommitmentServiceImplTest {
    @MockBean
    CommitmentsRepository commitmentRepository;
    @Autowired
    CommitmentServiceImpl commitmentServiceImpl;
    CommitmentDTO commitmentDTO = new CommitmentDTO();
    Commitment commitment = new Commitment();

    @Test
    public void test_insertCommitment() {
        Commitment commitment = dummyCommitment();
        CommitmentDTO commitmentDTO = dummyCommitmentDTO();
        Integer response = commitmentServiceImpl.insertCommitment(commitmentDTO);
        when(commitment).thenReturn(commitment);
        assertNotNull(response);

    }

    public CommitmentDTO dummyCommitmentDTO() {
        commitmentDTO.setCommitmentId(1);
        commitmentDTO.setInsurance_type("car");
        commitmentDTO.setLife_insurance_amt(String.valueOf(113));
        commitmentDTO.setLife_insurance_duration(String.valueOf(2));
        commitmentDTO.setCar_insurance_amt(String.valueOf(113));
        commitmentDTO.setCar_insurance_duration(String.valueOf(2));
        commitmentDTO.setHealth_insurance_amt(String.valueOf(113));
        commitmentDTO.setHealth_insurance_duration(String.valueOf(2));
        commitmentDTO.setTwoWheeler_insurance_amt(String.valueOf(113));
        commitmentDTO.setTwoWheeler_insurance_duration(String.valueOf(2));
        commitmentDTO.setHome_insurance_amt(String.valueOf(113));
        commitmentDTO.setHome_insurance_duration(String.valueOf(2));
        commitmentDTO.setTerm_insurance_amt(String.valueOf(113));
        commitmentDTO.setTerm_insurance_duration(String.valueOf(2));
        commitmentDTO.setLoc_amt(String.valueOf(113));
        commitmentDTO.setLoc_expiry_date("12/12/2022");
        commitmentDTO.setNps_applicant_name("jagruti");
        commitmentDTO.setNps_amt(String.valueOf(113));
        commitmentDTO.setNps_duration(String.valueOf(2));
        commitmentDTO.setBank_name_loc("abcd");
        return commitmentDTO;
    }



    public Commitment dummyCommitment() {
        CommitmentDTO commitmentDTO = dummyCommitmentDTO();
        commitment.setCommitmentId(commitmentDTO.getCommitmentId());
        commitment.setInsurance_type(commitmentDTO.getInsurance_type());
        commitment.setLife_insurance_amt(commitmentDTO.getLife_insurance_amt());
        commitment.setLife_insurance_duration(commitmentDTO.getLife_insurance_duration());
        commitment.setCar_insurance_amt(commitmentDTO.getCar_insurance_amt());
        commitment.setCar_insurance_duration(commitmentDTO.getCar_insurance_duration());
        commitment.setHealth_insurance_amt(commitmentDTO.getHealth_insurance_amt());
        commitment.setHealth_insurance_duration(commitmentDTO.getHealth_insurance_duration());
        commitment.setTwoWheeler_insurance_amt(commitmentDTO.getTwoWheeler_insurance_amt());
        commitment.setTwoWheeler_insurance_duration(commitmentDTO.getTwoWheeler_insurance_duration());
        commitment.setHome_insurance_amt(commitmentDTO.getHome_insurance_amt());
        commitment.setHome_insurance_duration(commitmentDTO.getHome_insurance_duration());
        commitment.setTerm_insurance_amt(commitmentDTO.getTerm_insurance_amt());
        commitment.setTerm_insurance_duration(commitmentDTO.getTerm_insurance_duration());
        commitment.setLoc_amt(commitmentDTO.getLoc_amt());
        commitment.setLoc_expiry_date(commitmentDTO.getLoc_expiry_date());
        commitment.setNps_applicant_name(commitmentDTO.getNps_applicant_name());
        commitment.setNps_amt(commitmentDTO.getNps_amt());
        commitment.setNps_duration(commitmentDTO.getNps_duration());
        commitment.setBank_name_loc(commitmentDTO.getBank_name_loc());

        commitmentRepository.save(commitment);
        return commitment;

    }

    @Test
    public void test_getCommitmentById() {
        commitment = dummyCommitment();
        Integer id = 1;
        Optional<Commitment> response = commitmentServiceImpl.getcommitmentById(1);
        when(commitmentRepository.getById(1L)).thenReturn(commitment);
        Assertions.assertNotNull(commitment);
        Assertions.assertNotNull(response);


    }

    @Test
    public void test_getCommitmentList() {
        Commitment commitment = dummyCommitment();
        List<Commitment> commitments = commitmentRepository.findAll();
        when(commitmentRepository.findAll()).thenReturn(commitments);
        List<Commitment> response = commitmentServiceImpl.findAll();
        assertNotNull(response);
    }
    @Test
    public void test_updateCommitment(){
       CommitmentDTO commitmentDTO=dummyCommitmentDTO();
       Commitment commitment=dummyCommitment();
        when(commitmentRepository.save(Mockito.any(Commitment.class))).thenReturn(commitment);
        Commitment response = commitmentServiceImpl.updateCommitment(commitmentDTO);
        assertNotNull(response);
    }
    Commitment dummyCommitments(){
        Commitment commitment=new Commitment();
        commitment.setCommitmentId(1);
        commitment.setInsurance_type("car");
        commitment.setLife_insurance_amt(String.valueOf(11));
        commitment.setLife_insurance_duration(String.valueOf(2));
        commitment.setCar_insurance_amt(String.valueOf(11));
        commitment.setCar_insurance_duration(String.valueOf(2));
        commitment.setHealth_insurance_amt(String.valueOf(11));
        commitment.setHealth_insurance_duration(String.valueOf(2));
        commitment.setTwoWheeler_insurance_amt(String.valueOf(11));
        commitment.setTwoWheeler_insurance_duration(String.valueOf(2));
        commitment.setHome_insurance_amt(String.valueOf(11));
        commitment.setHome_insurance_duration(String.valueOf(2));
        commitment.setTerm_insurance_amt(String.valueOf(11));
        commitment.setTerm_insurance_duration(String.valueOf(2));
        commitment.setLoc_amt(String.valueOf(11));
        commitment.setLoc_expiry_date("12/12/2022");
        commitment.setNps_applicant_name("jagruti");
        commitment.setNps_amt(String.valueOf(11));
        commitment.setNps_duration(String.valueOf(2));
        commitment.setBank_name_loc("abcd");
        return commitment;

    }

}
*/
