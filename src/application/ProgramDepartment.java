package application;

import db.DB;
import entities.Department;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import utils.Util;

import java.util.Comparator;
import java.util.List;

public class ProgramDepartment {
    public static void main(String[] args) {
        int repeatCount = 30;

        System.out.println("=".repeat(repeatCount) + "TEST 1: department findById" + "=".repeat(repeatCount));
        DepartmentDao departmentDao1 = DaoFactory.createDepartmentDao();
        Department department1 = departmentDao1.findById(1);
        System.out.println("Department found: " + department1.getName());
        System.out.println();

        System.out.println("=".repeat(repeatCount) + "TEST 2: department findAll" + "=".repeat(repeatCount));
        DepartmentDao departmentDao2 = DaoFactory.createDepartmentDao();
        List<Department> departments = departmentDao2.findAll();
        departments.stream().map(Department::getName).forEach(System.out::println);
        System.out.println();

        System.out.println("=".repeat(repeatCount) + "TEST 3: department Insert" + "=".repeat(repeatCount));
        DepartmentDao departmentDao3 = DaoFactory.createDepartmentDao();
        Department department3 = new Department(null, Util.generateRandomString());
        departmentDao3.insert(department3);
        System.out.println("Department " + department3.getName() + " inserted! New Id " + department3.getId());
        System.out.println();

        System.out.println("=".repeat(repeatCount) + "TEST 4: department update" + "=".repeat(repeatCount));
        DepartmentDao departmentDao4 = DaoFactory.createDepartmentDao();
        Department department4 = departmentDao4.findById(1);
        department4.setName(Util.generateRandomString());
        departmentDao4.update(department4);
        System.out.println("Department " + department4.getName() + " updated! Id = " + department4.getId());
        System.out.println();

        System.out.println("=".repeat(repeatCount) + "TEST 5: department delete" + "=".repeat(repeatCount));
        DepartmentDao departmentDao5 = DaoFactory.createDepartmentDao();
        Department departmentLastAdded = departmentDao5.findAll()
                .stream()
                .max(Comparator.comparing(Department::getId))
                .get();

        departmentDao5.deleteById(departmentLastAdded.getId());
        System.out.println("Department " + departmentLastAdded.getName() + " deleted! Id " + departmentLastAdded.getId());
        System.out.println();

        DB.closeConnection();
    }
}
