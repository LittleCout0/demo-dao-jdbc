package application;

import entities.Department;
import entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import utils.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        int repeatCount = 30;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("=".repeat(repeatCount) + "TEST 1: seller findById" + "=".repeat(repeatCount));
        SellerDao sellerDaoTest1 = DaoFactory.createSellerDao();
        Seller seller = sellerDaoTest1.findById(3);
        System.out.println("Seller found: " + seller);
        System.out.println();

        System.out.println("=".repeat(repeatCount) + "TEST 2: seller findByDepartment" + "=".repeat(repeatCount));
        SellerDao sellerDaoTest2 = DaoFactory.createSellerDao();
        List<Seller> sellersTest2 = sellerDaoTest2.findByDepartment(new Department(2, "Electronics"));
        System.out.println("Seller(s) founded by " + sellersTest2.get(0).getDepartment().getName() + " Department:");
        sellersTest2
                .stream()
                .map(Seller::getName)
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("=".repeat(repeatCount) + "TEST 3: seller findAll" + "=".repeat(repeatCount));
        SellerDao sellerDaoTest3 = DaoFactory.createSellerDao();
        List<Seller> sellersTest3 = sellerDaoTest3.findAll();
        System.out.println("All sellers available: " + sellersTest3.size());
        System.out.println();

        System.out.println("=".repeat(repeatCount) + "TEST 4: seller insert" + "=".repeat(repeatCount));
        SellerDao sellerDaoTest4 = DaoFactory.createSellerDao();
        Seller seller4 = new Seller(null, "Greg", "greg@gmail.com", 4000.0,
                LocalDate.parse("01/03/1990", dtf), new Department(2, "Electronics"));
        sellerDaoTest4.insert(seller4);
        System.out.println("Seller " + seller4.getName() + " inserted! New id = " + seller4.getId());
        System.out.println();

        System.out.println("=".repeat(repeatCount) + "TEST 5: seller update" + "=".repeat(repeatCount));
        SellerDao sellerDaoTest5 = DaoFactory.createSellerDao();
        Seller seller5 = sellerDaoTest5.findById(1);
        seller5.setName(Util.generateRandomString());
        sellerDaoTest5.update(seller5);
        System.out.println("Seller " + seller5.getName() + " updated! Id = " + seller5.getId());
        System.out.println();

        System.out.println("=".repeat(repeatCount) + "TEST 6: seller delete" + "=".repeat(repeatCount));
        SellerDao sellerDao6 = DaoFactory.createSellerDao();
        Seller sellerLastAdded = sellerDao6.findAll()
                .stream()
                .max(Comparator.comparing(Seller::getId))
                .get();
        sellerDao6.deleteById(sellerLastAdded.getId());
        System.out.println("Seller " + sellerLastAdded.getName() + " deleted! Id = " + sellerLastAdded.getId());
        System.out.println();

    }
}
