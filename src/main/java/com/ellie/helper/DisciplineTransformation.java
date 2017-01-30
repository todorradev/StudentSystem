package com.ellie.helper;

import com.ellie.dto.DisciplineDTO;
import com.ellie.entity.Discipline;

public class DisciplineTransformation {
    /**
     * Convert discipline entity to discplineDTO
     *
     * @param discipline - which will be transform
     * @return disciplineDTO
     */
    public static DisciplineDTO transformDisciplineToDisciplineDTO(Discipline discipline) {
        DisciplineDTO disciplineDTO = new DisciplineDTO();

        disciplineDTO.setDisciplineName(discipline.getDisciplineName());
        disciplineDTO.setGrade(discipline.getGrade());
        disciplineDTO.setId(discipline.getId());
        disciplineDTO.setSemester(discipline.getSemester());
        disciplineDTO.setStudent(discipline.getStudent());

        return disciplineDTO;
    }

    /**
     * Convert disciplineDTO entity to discipline
     *
     * @param disciplineDTO - which will be transform
     * @return discipline
     */
    public static Discipline transformDisciplineDtoToDiscipline(DisciplineDTO disciplineDTO) {
        Discipline discipline = new Discipline();

        discipline.setId(disciplineDTO.getId());
        discipline.setDisciplineName(disciplineDTO.getDisciplineName());
        discipline.setGrade(disciplineDTO.getGrade());
        discipline.setSemester(disciplineDTO.getSemester());
        discipline.setStudent(disciplineDTO.getStudent());

        return discipline;
    }
}
