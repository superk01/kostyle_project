package discount.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kostyle.discount.domain.TempShopVO;
import kostyle.discount.persistence.DiscountDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DiscountDAOImplTest {

   @Inject
   private DiscountDAO dao;
   
   
   private static Logger logger = LoggerFactory.getLogger(DiscountDAOImplTest.class);

   
   //DB에서 부족한 세일관련한 부분만 update로 채워넣기. null허용
   @Test
   public void testAddSaleUrlInfoShop(){
      TempShopVO vo = new TempShopVO();
      
      try {
         //66걸즈
      vo.setS_num("s_01");
         vo.setS_discounturl("http://66girls.co.kr/product/list.html?cate_no=306");
         vo.setS_newsaleurl("http://66girls.co.kr/product/list.html?cate_no=76");
         dao.addSaleUrlInfoShop(vo);
         //스타일난다
               vo.setS_num("s_02");
      vo.setS_discounturl("http://www.stylenanda.com/product/list03.html?cate_no=57");
      vo.setS_newsaleurl("http://www.stylenanda.com/product/list03.html?cate_no=613"); 
      dao.addSaleUrlInfoShop(vo);
   //고고싱
      vo.setS_num("s_03");
      vo.setS_discounturl("http://ggsing.com/product/list.html?cate_no=345&page=1");
      vo.setS_newsaleurl("http://ggsing.com/product/list_sale.html?cate_no=254");
      dao.addSaleUrlInfoShop(vo);
      
      //러브러브미
      vo.setS_num("s_04");
      vo.setS_discounturl("http://loveloveme.com/product/list.html?cate_no=884");
      vo.setS_newsaleurl("http://loveloveme.com/product/list.html?cate_no=612");
      dao.addSaleUrlInfoShop(vo);
      
      //핫핑
      vo.setS_num("s_05");
      vo.setS_discounturl("http://hotping.co.kr/product/list.html?cate_no=42");
      vo.setS_newsaleurl("http://hotping.co.kr/product/list.html?cate_no=25");
      dao.addSaleUrlInfoShop(vo);
      
      //더데이즈
      vo.setS_num("s_06");
      vo.setS_discounturl("http://www.dejou.co.kr/product/list.html?cate_no=34");
      vo.setS_newsaleurl(""); //없음
      dao.addSaleUrlInfoShop(vo);
      
      //임블리
      vo.setS_num("s_07");
      vo.setS_discounturl(""); //없음
      vo.setS_newsaleurl("http://imvely.com/product/list.html?cate_no=72");
      dao.addSaleUrlInfoShop(vo);
      
      
/*      vo.setS_num("s_08");
      vo.setS_discounturl("");
      vo.setS_newsaleurl("");
      
      vo.setS_num("s_09");
      vo.setS_discounturl("");
      vo.setS_newsaleurl("");
                
         dao.addSaleUrlInfoShop(vo);*/
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}//class