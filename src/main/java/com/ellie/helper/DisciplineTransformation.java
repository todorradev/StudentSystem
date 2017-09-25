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
        disciplineDTO.setId(discipline.getId());

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

        return discipline;
    }
}
