package entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TypeDepartmentConverter implements AttributeConverter<Department.Type, Character> {

    @Override
    public Character convertToDatabaseColumn(Department.Type type) {
        return type.getCode();
    }

    @Override
    public Department.Type convertToEntityAttribute(Character code) {
        return Department.Type.toType(code);
    }
}
