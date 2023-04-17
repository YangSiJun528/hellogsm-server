package kr.hellogsm.back_v2.domain.application.entity.grade;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 학생의 입학 중학교 성적을 저장하는 Entity입니다.
 *
 * @author 양시준
 * @since 1.0.0
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "middle_school_grade")
@ToString
public class MiddleSchoolGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "middle_school_grade_id")
    private Long id;

    @Lob
    @Column(name = "middle_school_grade_text")
    private String middleSchoolGradeText;

}

