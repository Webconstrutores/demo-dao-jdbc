package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: Seller findById ===");
		System.out.println();
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		System.out.println("=== Test 2: Seller findByDepartment ===");
		System.out.println();
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println();
		System.out.println("=== Test 3: Seller findByAll ===");
		System.out.println();
		
		List<Seller> lista = sellerDao.findAll();
		for(Seller dep : lista) {
			System.out.println(dep);
		}
	}

}
