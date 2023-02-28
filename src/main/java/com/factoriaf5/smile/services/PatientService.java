package com.factoriaf5.smile.services;

import java.util.List;



import com.factoriaf5.smile.models.Patient;
import com.factoriaf5.smile.repositories.PatientRepository;

public class PatientService {
    private PatientRepository repository;


    
    public PatientService (PatientRepository repository) {
        this.repository = repository;
}



    public List<Patient> getAll() {
        return repository.findAll();
    }
}