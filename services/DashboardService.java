package services;

import java.util.Map;

public interface DashboardService {
    Map<String, Object> getStatistiquesInterventions();

    Map<String, Object> getStatistiquesGenerales();

    Map<String, Object> getStatistiquesEquipements();
}
