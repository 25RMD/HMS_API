package com.postgresql.carehms;

import com.postgresql.carehms.repository.PatientBasicInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class CarehmsApplication extends SpringBootServletInitializer {

	@Autowired
	private PatientBasicInformationRepository mainRepo;

	public static void main(String[] args) {
		SpringApplication.run(CarehmsApplication.class, args);
	}


	@GetMapping("/api/patients")
	public ResponseEntity<List<PatientBasicInformation>> getAllPatients(){

		return ResponseEntity.ok(mainRepo.findAll());
	}


	@GetMapping("/api/patient/id")
	public ResponseEntity<?> getPatientById(@RequestBody PatientRequest patientRequest) {

		String id = patientRequest.getMrNumber();
		Optional<PatientBasicInformation> data = mainRepo.findByMrNumber(id);

		try{
			if(data.isPresent()) {
				return ResponseEntity.ok(data.get());

			}else {
				return ResponseEntity.notFound().build();
			}

		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred: " + e.getMessage());
		}
	}


	@PutMapping("/api/patient/update")
    public ResponseEntity<String> updatePatient(@RequestBody PatientBasicInformation patientBasicInformation){

		String mrNumber = patientBasicInformation.getMrNumber();
		Optional<PatientBasicInformation> data = mainRepo.findByMrNumber(mrNumber);

		try{

			if (data.isPresent()){

				mainRepo.save(patientBasicInformation);
				return ResponseEntity.ok("Data was saved successfully.");
			}else{
				return ResponseEntity.notFound().build();
			}
		}catch(Exception e){

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred: " + e.getMessage());
		}

	}


	@PostMapping("/api/patients")
	public ResponseEntity<String> addPatient(@RequestBody List<PatientBasicInformation> data){

		try{

			mainRepo.saveAll(data);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred: " + e.getMessage());

		}

        return ResponseEntity.ok("Successfully added");
	}


	@DeleteMapping("/api/patients")
	public ResponseEntity<String> removePatient(@RequestBody List<PatientBasicInformation> data){

		List<PatientBasicInformation> allData = mainRepo.findAll(); 	//might be an issue for larger datasets

		try{
			for(PatientBasicInformation patient : allData){

				if(data.contains(patient)){
					mainRepo.delete(patient);
				}
				else{
					return ResponseEntity.notFound().build();
				}
			}
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred: " + e.getMessage());
		}

        return ResponseEntity.ok("Data was deleted successfully.");
    }

	@DeleteMapping("/api/patients/id")
	public ResponseEntity<String> removePatientById(@RequestBody PatientRequest patientRequest) {
		String id = patientRequest.getMrNumber();
        Optional<PatientBasicInformation> data = mainRepo.findByMrNumber(id);

        try{
            if(data.isPresent()){
                mainRepo.delete(data.get());
                return ResponseEntity.ok("Data was deleted successfully.");
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred: " + e.getMessage());
        }

    }



	public static class PatientRequest{

		private String mrNumber;

		public String getMrNumber(){
			return mrNumber;
		}

		public void setMrNumber(String mrNumberValue){
			this.mrNumber = mrNumberValue;
		}
	}
}
