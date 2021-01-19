Assumptions and viewpoints

A) This is mainly for Java backend centric
B) Domain:
    1. Subcategory will have id of category.
    2. Inventory will have id of subcategory(having category id again will be repetition hence not kept).
    3. CategoryHolder, SubCategoryHolder and InventoryHolder are temp classes to mimic data base query and value holder.
C) DataBase layer is not present, xxxHolder classes are used to mimic Data base record holders

Test cases written so far is working and can be see at TestResultSnapShot.jpg file, present at root.

Limitation(as time constraints):
1. Could not finish the controller part with HTML interaction 
2. There should be a lock acquired before updating the quantity to handle concurrent update,
   Current qty of the inventory will be used as safeguard check if concurrent access are made.
3. There are some //TODO which can be implemented, but left with time constraints.