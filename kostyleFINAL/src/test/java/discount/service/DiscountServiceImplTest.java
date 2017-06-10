package discount.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kostyle.discount.service.DiscountService;
import kostyle.discount.service.DiscountServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DiscountServiceImplTest {
	@Inject
	DiscountService service;
	
	@Test
	public void testDiscountCrollingTest(){
		service.discountUrlCrolling();
	}
	
	@Test
	public void testNewSaleCrollingTest(){
		service.newSaleUrlCrolling();
	}
	
}
