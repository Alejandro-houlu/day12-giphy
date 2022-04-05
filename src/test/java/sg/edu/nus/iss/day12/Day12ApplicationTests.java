package sg.edu.nus.iss.day12;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import sg.edu.nus.iss.day12.Services.GiphyImplementation;

@SpringBootTest
class Day12ApplicationTests {

	@Autowired
	private GiphyImplementation gService;

	@Test
	void shouldLoad10Images() {
		List<String> gifs = gService.getSearchResult("dog");
		//assertEquals(10, gifs.size(), "Default number of gifs");
		assertEquals(10, gifs.size(), "Default number of gifs");
	}

}
