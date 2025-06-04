package dto;

import jakarta.validation.constraints.NotBlank;

public class SolutionUpdateDTO {
    @NotBlank
    private String solution;

    public String getSolution() { return solution; }
    public void setSolution(String solution) { this.solution = solution; }
}
