package services;

import entities.Departement;
import entities.Equipement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.DepartementRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartementService {

    private final DepartementRepository departmentRepository;

    public List<Departement> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Departement> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Departement saveDepartment(Departement department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Optional<Departement> findByNom(String nom) {
        return departmentRepository.findByNom(nom);
    }

    public List<Departement> searchDepartments(String keyword) {
        return departmentRepository.searchByKeyword(keyword);
    }

    public Long getActiveEmployeesCount(Long departmentId) {
        return departmentRepository.countActiveEmployeesByDepartment(departmentId);
    }

    public void deleteById(Long id) {

    }

    public List<Departement> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<Departement> findById(Long id) {
        return departmentRepository.findById( id);
    }

    public Departement save(@Valid Departement departement) {
       return departmentRepository.save();
    }

    public List<Equipement> getEquipementsByDepartement(Long id) {
        return getEquipementsByDepartement(id);
    }
}