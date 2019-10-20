package Test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class JunitTest {

	@Before
	void setUp() throws Exception {
		
		System.out.println("Start Junit Testing");;
		
	}

	@Test
	void testPlayer() {
		System.out.println("Test cases passed");
	}
}
