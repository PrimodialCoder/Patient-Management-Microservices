package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatient(){

        List<Patient>  patientList = patientRepository.findAll();
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        List<PatientResponseDTO> patientResponseDTOList = new ArrayList<>();

        for(Patient patient : patientList){
            patientResponseDTO = new PatientResponseDTO();
            patientResponseDTO.setName(patient.getName());
            patientResponseDTO.setId(String.valueOf(patient.getId()));
            patientResponseDTO.setEmail(patient.getEmail());
            patientResponseDTO.setAddress(patient.getAddress());
            patientResponseDTO.setDateOfBirth(patient.getDateOfBirth().toString());
            patientResponseDTOList.add(patientResponseDTO);
        }
        return List.of(patientResponseDTO);
    }
}
