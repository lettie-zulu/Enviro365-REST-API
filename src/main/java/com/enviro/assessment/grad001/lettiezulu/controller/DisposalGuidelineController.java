package com.enviro.assessment.grad001.lettiezulu.controller;

//these are the import statements, they import various classes and packages needed for controller to function.
import com.enviro.assessment.grad001.lettiezulu.model.DisposalGuideline;//this is the model class representing the disposal guidelines.
import com.enviro.assessment.grad001.lettiezulu.service.DisposalGuidelineService;//this is the service class for handling business logic relate to disposal guidelines.
import org.springframework.beans.factory.annotation.Autowired;//this is used for injecting dependencies.
import org.springframework.http.HttpStatus;//this is used for building http responses.
import org.springframework.http.ResponseEntity;//this is also use for building http responses.
import org.springframework.web.bind.annotation.*;//this is for spring web annotations for building resful web services like CRUD.

import jakarta.validation.Valid;//this is used for validating the request body.
import java.util.List;//this is a utility class for handling collections and optional values.
import java.util.Optional;//this is a utility class for handling collections and optional values.

//Controller Class Declaration
@RestController//this annotation shows that this class is a resful web service controller where each method returns a domain object instead of a view.
@RequestMapping("/api/disposal-guidelines")//this sets the base path for all the endpoints in this controller to /api/disposal-guidelines.
public class DisposalGuidelineController {

    @Autowired//this annotation is used to inject the disposal guideline service dependency in the controller.
    private DisposalGuidelineService service;

    @GetMapping(produces = "application/json")//this annotation maps the http get requests to /api/disposal-guideline and specifies that the response will be in jason format.
    public List<DisposalGuideline> getAllDisposalGuidelines() {//this method calls the service to get all disposal guidelines and returns them as a list.
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")//this annotation maps http requests to /api/disposal-guidelines/{id} where the id is a path variable.
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id) {//this annotation binds the method parameter to the value of the id path variable.
        Optional<DisposalGuideline> guideline = service.findById(id);//this line attempts to find the disposal guidline by id.
        return guideline.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());//this line returns the guideline if found, otherwise return a 404 not found response.
    }

    @PostMapping(consumes = "application/json", produces = "application/json")// thsi annotation maps http post request to /api/disposal-guidelines specifying that the request and response bodies are in jason format.
    public ResponseEntity<DisposalGuideline> createDisposalGuideline(@Valid @RequestBody DisposalGuideline guideline) {//this annotion binds the method parameter to the incoming request body and ensures it is valid.
        DisposalGuideline savedGuideline = service.save(guideline);//this line calls the service to save the new disposal guideline.
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGuideline);//this line returns a 201 created response with the saved guideline.
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuideline guideline) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        guideline.setId(id);
        DisposalGuideline updatedGuideline = service.save(guideline);
        return ResponseEntity.ok(updatedGuideline);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}