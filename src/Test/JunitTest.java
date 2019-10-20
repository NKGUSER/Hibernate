package Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.SoccerService;
import com.config;


// @Extendwith provided in Junit5 in place of @Runwith where multiple class can 
// configured.

@RunWith(SpringRunner.class)

// SpringRunner help you getting Spring Test context framework, Application context
// @MockBean provided by this class.

@SpringBootTest(classes = config.class)

// bootstrap with Spring Boot’s support” (e.g. load application.properties)
// webEnvironment attribute allows specific “web environments” 
// to be configured for the test.
// Load Specific configuration 
// TestRestTemplate is now availble as Bean

public class JunitTest {

	// Use of MockitoJunitRunner help you init the Object Mocked with @Mock
	// it is a validation framework, static "when" method, but don't complete 
	//the stubbing with a matching thenReturn, thenThrow or then, it throw an error
	// Likewise the case of "verify" and doReturn, doThrow, doAnswer, thenReturn
	// thenThrow, then etc....
	
	@Mock
	SoccerService SS;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		System.out.println("Start Junit Testing");;	
	}

	@Test
	public void testPlayer() {
		List<String> list = new ArrayList<>();
		list.add("Nitin");
		Mockito.when(SS.getAllTeamPlayers(2)).thenReturn(list);
		
		List<String> l = SS.getAllTeamPlayers(2);
		
		System.out.println("Test cases passed");
	}
}
