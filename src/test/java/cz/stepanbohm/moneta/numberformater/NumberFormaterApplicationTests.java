package cz.stepanbohm.moneta.numberformater;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberFormaterApplicationTests {

	@Autowired
	NumberFormater numberFormater;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void exampleValue() {
		// Given
		Long number = 43256791L;
		Long formatedNumber = numberFormater.formatNumberLong(number);
		
		assertEquals(Long.valueOf(11331545), formatedNumber);
	}
	
	@Test
	public void firtNineDigits() {
		// Given
		Long number = 123456789L;
		Long formatedNumber = numberFormater.formatNumberLong(number);
		
		assertEquals(Long.valueOf(824712323), formatedNumber);
	}

}
