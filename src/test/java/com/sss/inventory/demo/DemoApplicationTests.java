package com.sss.inventory.demo;

import com.sss.inventory.demo.dao.CategoryHolder;
import com.sss.inventory.demo.dao.InventoryDao;
import com.sss.inventory.demo.dao.InventoryHolder;
import com.sss.inventory.demo.dao.SubCategoryHolder;
import com.sss.inventory.demo.domain.Inventory;
import com.sss.inventory.demo.exception.CategoryMismatchException;
import com.sss.inventory.demo.exception.ConcurrentUpdateException;
import com.sss.inventory.demo.service.InventoryService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {

	@Autowired
	private InventoryDao inventoryDao;

	@Autowired
	private InventoryService inventoryService;


	@Before
	void prepareData(){
		CategoryHolder.init();
		SubCategoryHolder.init();
		InventoryHolder.init();
	}



	@Test
	void addAnInventorySuccessTest() throws Exception{
		/*
		Given an intenvototy item, add it to a category with inventory details
		 */
		prepareData();

		inventoryService.createInventory(14,120, 1113, "NIKE WOMAN SHOES", 500);
		assertEquals(inventoryDao.getInventoryQty(1113), 500);

		inventoryService.createInventory(14,120, 1114, "PUMA SHOES", 70);
		assertEquals(inventoryDao.getInventoryQty(1114), 70);


	}

	@Test
	void addAnInventoryCategoryMismatchTest() throws Exception{
		/*
		Given an intenvototy item, add it to a wrong category with inventory details
		 */
		prepareData();

		Exception exception = assertThrows(CategoryMismatchException.class, () -> {
			inventoryService.createInventory(11,120, 1113, "NIKE WOMAN SHOES", 500);
		});

	}

	@Test
	void updateInvotoryQtySuccessTest() throws Exception{
		/*
		Given an intenvototy item, update its qty
		 */

		prepareData();

		inventoryService.createInventory(14,120, 1113, "NIKE WOMAN SHOES", 500);
		assertEquals(inventoryDao.getInventoryQty(1113), 500);
		inventoryService.updateInventoryQty(1113, 500, 700);
		assertEquals(inventoryDao.getInventoryQty(1113), 700);

	}

	@Test
	void updateInvotoryQtyFailsForConcurrentupdateTest() throws Exception{
		/*
		Given an intenvototy item, update its qty, failes as two  users tried
		 */
		prepareData();

		inventoryService.createInventory(14,120, 1113, "NIKE WOMAN SHOES", 500);
		assertEquals(inventoryDao.getInventoryQty(1113), 500);
		inventoryService.updateInventoryQty(1113, 500, 700);

		Exception exception = assertThrows(ConcurrentUpdateException.class, () -> {
			inventoryService.updateInventoryQty(1113, 500, 800); // this must fail
		});

		assertEquals(inventoryDao.getInventoryQty(1113), 700);

	}

	@Test
	void getInventoryTest() throws Exception{
		/*
		Given an intenvototy id, return inventory
		 */
		prepareData();

		Inventory inventory = inventoryService.getInventory(1111);
		assertNotNull(inventory);
		assertEquals(inventory.getQuantity(), 10);


		inventory = inventoryService.getInventory(928737);
		assertNull(inventory);

	}

	@Test
	void getAllInventoryTest() throws Exception{
		/*
		Given an intenvototy id, return inventory
		 */
		prepareData();

		Set<Inventory> inventories = inventoryService.getAllInventory();

		assertNotNull(inventories);
		assertEquals(inventories.size(), 2);

	}


}
