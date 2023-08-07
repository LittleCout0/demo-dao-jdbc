package application;

import entities.Department;
import entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        int repeatCount = 30;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("=".repeat(repeatCount) + "TEST 1: seller findById" + "=".repeat(repeatCount));
        SellerDao sellerDaoTest1 = DaoFactory.createSellerDao();
        Seller seller = sellerDaoTest1.findById(3);
        System.out.println(seller);

        System.out.println("=".repeat(repeatCount) + "TEST 2: seller findByDepartment" + "=".repeat(repeatCount));
        SellerDao sellerDaoTest2 = DaoFactory.createSellerDao();
        List<Seller> sellersTest2 = sellerDaoTest2.findByDepartment(new Department(2, "Electronics"));
        sellersTest2.forEach(System.out::println);
        System.out.println("Instances Department: " + Department.getNumOfInstances());

        System.out.println("=".repeat(repeatCount) + "TEST 3: seller findAll" + "=".repeat(repeatCount));
        SellerDao sellerDaoTest3 = DaoFactory.createSellerDao();
        List<Seller> sellersTest3 = sellerDaoTest3.findAll();
        sellersTest3.forEach(System.out::println);
        System.out.println("Instances Department: " + Department.getNumOfInstances());

        System.out.println("=".repeat(repeatCount) + "TEST 4: seller insert" + "=".repeat(repeatCount));
        SellerDao sellerDaoTest4 = DaoFactory.createSellerDao();
        Seller seller4 = new Seller(null, "Greg", "greg@gmail.com", 4000.0,
                LocalDate.parse("01/03/1990", dtf), new Department(2, "Electronics"));
        sellerDaoTest4.insert(seller4);
        System.out.println("Inserted! New id = " + seller4.getId());
    }
}
