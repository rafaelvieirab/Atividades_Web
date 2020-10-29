package br.ufc.crateus.atividade5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufc.crateus.atividade5.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Query(value = "SELECT * "
			+ "FROM employers "
				+ "WHERE office ilike %:office% "
				+ "ORDER BY id ASC "
				+ "LIMIT :limit",
			nativeQuery = true)
	List<Employee> findTopNByOfficeByOrderAsc(@Param("office") String office, @Param("limit") int limit);
}
