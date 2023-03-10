import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BankAccountTest {

	@Test
	public void test() {
		BankAccount acc= new BankAccount(); 
		acc.deposit(50); 
		assertEquals(acc.balance,50);
	}

}
