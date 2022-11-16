package entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import repository.DepartmentRepository;

import java.io.Serializable;

public class DepartmentCodeGenerator implements IdentifierGenerator {
    private DepartmentRepository repository = new DepartmentRepository();
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Department department = (Department) o;
        Department.Type type = department.getType();
        long count = repository.countByType(department.getType());
        return String.format("%c-%d",type.getCode(),count+1);


    }
}
