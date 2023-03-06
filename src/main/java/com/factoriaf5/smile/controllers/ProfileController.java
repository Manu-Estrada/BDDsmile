package com.factoriaf5.smile.controllers;

import com.factoriaf5.smile.models.Profile;

@RestController
@RequestMapping (path = "/api/profile")
public class ProfileController {
    private ProfileService service;
    
    public ProfileController(ProfileService service) {
        this.service = service;   
}
@GetMapping(path = "")
public List<Profile>getAll(){
    return service.getAll();
    
}

@GetMapping(path = "/{dni}")
public Profile getOne(@PathVariable String dni){
    return service.getOne(dni);
}

@PostMapping(path = "")
public void save(@RequestBody ProfilePayload patient){
    service.save(Profile);
}

@DeleteMapping(path = "/{dni}")
public List<Profile> delete(@PathVariable String dni){
    return service.delete(dni);
}



@PutMapping(path = "/{dni}")
public ResponseEntity<Profile> update(@PathVariable String dni, @RequestBody ProfilePayload profile){
    Profile profileTemporal = service.getOne(dni);

    try {
        if(profileTemporal !=null){
            profile.setDni(dni);
            service.save(profile);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }
}
