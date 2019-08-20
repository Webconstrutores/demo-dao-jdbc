package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
		
		System.out.println();
		System.out.println("=== Test 4: Seller Insert ===");
		System.out.println();
		
		Seller newSeller = new Seller(null, "Greg", "greg@gamil.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		
		System.out.println();
		System.out.println("=== Test 5: Seller Update ===");
		System.out.println();
		
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update Completed!");
		
		System.out.println();
		System.out.println("=== Test 6: Seller Delete ===");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		Boolean boo = true;
		while(boo) {
			System.out.print("Enter id for delete Seller: ");
			Integer id = sc.nextInt();
			if(id != null && sellerDao.findById(id) != null) {
				sellerDao.deleteById(id);
				boo = false;
				System.out.println("Seller id ("+id+") deleted!");
				System.out.println();
			} else {
				System.out.println("Seller not found!");
				System.out.println();
			}
			
		}
		
		sc.close();
		
		
	}

}
