package controllers;

import services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    // GET - Statistiques générales
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getStatistiques() {
        try {
            Map<String, Object> stats = dashboardService.getStatistiquesGenerales();
            return new ResponseEntity<>(stats, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - Statistiques des équipements
    @GetMapping("/stats/equipements")
    public ResponseEntity<Map<String, Object>> getStatistiquesEquipements() {
        try {
            Map<String, Object> stats = dashboardService.getStatistiquesEquipements();
            return new ResponseEntity<>(stats, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - Statistiques des interventions
    @GetMapping("/stats/interventions")
    public ResponseEntity<Map<String, Object>> getStatistiquesInterventions() {
        try {
            Map<String, Object> stats = dashboardService.getStatistiquesInterventions();
            return new ResponseEntity<>(stats, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }}
