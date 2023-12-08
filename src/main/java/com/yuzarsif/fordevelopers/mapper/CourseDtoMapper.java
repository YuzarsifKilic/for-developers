package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.CourseDto;
import com.yuzarsif.fordevelopers.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseDtoMapper {

    CourseDtoMapper MAPPER = Mappers.getMapper(CourseDtoMapper.class);

    CourseDto mapToCourseDto(Course course);
}
