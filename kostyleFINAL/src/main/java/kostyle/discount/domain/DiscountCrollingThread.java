package kostyle.discount.domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kostyle.search.domain.SearchVO;

public class DiscountCrollingThread extends Thread {
   //키워드
   public static String DISURL ="DISURL";
   public static String NEWURL = "NEWURL";
   public static String ONEPLUS = "1+1";
   private String crollUrl;
   private String shopUrl;
   private String s_sname;
   private int pagecount = 0;
   private List<DiscountVO> resultVOList;
   
   public DiscountCrollingThread(String keyword, ShopDiscountVO sdVO){
      if(keyword.equals(DISURL)){
         this.crollUrl = sdVO.getS_discounturl();
      }else if(keyword.equals(NEWURL)){
         this.crollUrl = sdVO.getS_newsaleurl();
      }else{
         //System.out.println("keyword값 맞지않음! 쓰레드에러!");
      }
      System.out.println("crollUrl : "+ crollUrl);
      this.shopUrl = sdVO.getS_shopurl();
      this.s_sname = sdVO.getS_sname();
      resultVOList = new ArrayList<DiscountVO>();
   }

   public List<DiscountVO> getResultVOList() {
      return resultVOList;
   }

   //이전의 closet은 한상품이라서 list에 한줄씩담지않고 stringBuffer로 몽땅 한곳에 넣고 검사했었고, 여기서는 한줄씩 list에 쪼개어담아서 검출하낟.
   @Override
   public void run() {
   //   while(running){
      System.out.println("============"+getName()+"쓰레드 시작============");
      String crollUrl = this.crollUrl;
      String shopUrl = this.shopUrl;
      
         //검색 페이지면 마지막 페이지 숫자 삭제
         if(crollUrl.indexOf("&page="+pagecount) != -1){
            crollUrl = crollUrl.substring(0, crollUrl.length() - 7);
         }
         
         //검색 페이지 처리
         pagecount ++;
         crollUrl = crollUrl + "&page=" + pagecount;      
         
         List<Integer> startLiRowNum = new ArrayList<Integer>(); // 물품 시작 box 줄 모음
         List<Integer> endLiRowNum = new ArrayList<Integer>(); // 물품 끝 box 줄 모음
         List<String> product_NameList = new ArrayList<String>(); //최종 물품이름목록
         List<String> product_BeforeSalePriceList = new ArrayList<String>();//최종 물품가격목록
             List<String> product_AfterSalePriceList = new ArrayList<String>();//최종 물품가격목록
             List<Integer> product_discountRateList = new ArrayList<Integer>(); //할인율
             List<String> product_onePlusOneList = new ArrayList<String>(); // 1+1할인인지
         List<String> product_LinkList = new ArrayList<String>();//최종 물품링크목록
         List<String> product_ImgLinkList = new ArrayList<String>(); //최종 물품이름목록
         List<String> rowList = new ArrayList<String>();   //페이지row 저장
         
         URL url =null;
         BufferedReader br =null;
         try {
            url = new URL(crollUrl);
            //System.out.println("연결중....url = " + crollUrl);
            URLConnection conn = url.openConnection(); 
         //   br = new BufferedReader(new InputStreamReader(url.openStream()));
             br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
             String code;
            //StringBuffer sb = new StringBuffer();

            while((code=br.readLine())!=null){
               rowList.add(code);
               ////System.out.println(code);
            }
         }catch (Exception e) {
               e.printStackTrace();
         }finally{
                  //System.out.println("코드추출완료");
         }
         
           // 물품 하나 시작 태그 인식
             String startLI = "<li id";
             String startClass = "xans-record"; // 쇼핑몰 물품 박스 class 이름
         
          // 물품 하나 끝 태그 인식
             String endLI = "</li>"; // 이건 row 전체값이 </li>이여야 한다.
      
             // 물품 바로가기 링크 페이지 인식
             String productLink[] = { "a href=\"/product/detail", "a href=\"/shop/view" };
             String product_NameCheck = "[가-힣]"; // 물품 이미지 검색 (한글 있으면 true 리턴)
             int productImgLinkRowNum = 0;// 이미지 src 담겨있는 열 검사결과

             String Not_product_NameCheck = "[^가-힣]"; // 물품 이름 추출 최대길이 10, 물품 금액은
                                              // 한글 4글자 이하, 물품 설명은 한글
                                              // 10자 이하 한글 검사 있으면
                                              // false리턴
             int productLinkRowNum = 0; // 결과값 저장

             //검색한 하나의 상품을 Box형태로 모으기
             for (int i = 0; i < rowList.size(); i++) {
                String row = rowList.get(i);
                int startlicheck = -1;
                int startliclasscheck = -1;
                startlicheck = row.indexOf(startLI);
                startliclasscheck = row.indexOf(startClass);

                if (startlicheck != -1 && startliclasscheck != -1) {
                   startLiRowNum.add(i);
                } else if (row.trim().equals(endLI) && startLiRowNum.size() > 0) {
                   if (startLiRowNum.get(0) < i) {
                      endLiRowNum.add(i);
                   }
                }            
             }
             
             //검색한 상품이 없을때 재귀함수 중지
             if(startLiRowNum.size() == 0 && endLiRowNum.size() == 0 ){
                System.out.println("-------검색끝 " + (pagecount-1) + " 개 페이지 검색-------");
                return;
             }else if(pagecount == 2){ //느려서 최대9페이지까지만 받아옴
                System.out.println("페이지 초과");
                return;
             }
//----------------------------------------  myWayThread Start--------------------------
             List<StringBuffer> sbList = new ArrayList<StringBuffer>(); //상품하나 ==하나의 stirngBuffer(string하나처럼 한문장으로 뭉치기.)
             
             
             //상품하나하나를 각각의 스트링버퍼에 담기. //rowList에 전체코드 들어있음. 인덱스를 기준으로 한상품씩 스트링버퍼로 합칠것.
             for (int i = 0; i < startLiRowNum.size(); i++) {
                   int startrow = startLiRowNum.get(i);
                   int endrow = endLiRowNum.get(i);      
                   StringBuffer sb = new StringBuffer();
                  
                   
                   for(int j=startrow; j<=endrow; j++){
                      sb.append(rowList.get(j));
                      ////System.out.println("rowList.get("+j+"):  "+rowList.get(j));
                      ////System.out.println("sb("+j+"):  "+sb);
                      
                      if(j == endrow){//마지막에 한번만 sbList(상품하나가 하나의 sb인목록)에 추가
                         sbList.add(sb);
                       //  //System.out.println(j+"번째 sbList에 추가된 sb내용: "+sb);
                      }
                   }
                   ////System.out.println("sbList의 ("+i+")번째 sb:  "+sbList.get(i));
             }        
                   
            //한 상품마다 원하는 값 추출.
             //뽑을값:  상품url, 이미지url, 상품할인전가격. 할인후가격, 이름
             // DiscountVO vo  = new DiscountVO(product_LinkList.get(i), product_ImgLinkList.get(i), product_BeforeSalePriceList.get(i), "2원", product_NameList.get(i));          
           for(int i=0; i<sbList.size(); i++){
              String prdUrl = "";
              String imgUrl = "";
              Map<String,Object> priceMap;
              String beforePrice ="";
              String afterPrice="";
              int discountRate=0;
              String onePlusOne="";
              String prdName="";
              StringBuffer sb = sbList.get(i);
              
              //상품Url찾기
              prdUrl = findPrdUrl(sb);
              //이미지Url찾기
              imgUrl = findImgUrl(sb, prdUrl);
              //상품명 추출
              prdName = findprdName(sb, prdUrl);
              
              //prdName과 imgUrl추출 전에 prdUrl에 shopUrl을붙이면 이미지url이 안찾아져서 여기서붙인다. 
              prdUrl = addShopUrl(prdUrl);
              imgUrl = addShopUrl(imgUrl);

              
              //가격찾기 (할인전/ 할인후/할인율) // beforePrice  afterPrice discountRate
              priceMap = findPrice(sb, shopUrl);
              beforePrice = (String)priceMap.get("beforePrice");
              afterPrice = (String)priceMap.get("afterPrice");
              
              System.out.println("discountRate: "+priceMap.get("discountRate"));
              if(priceMap.get("discountRate") != null){
                 discountRate = (Integer)priceMap.get("discountRate");
              }
              if(priceMap.get("onePlusOne") != ""){
                 onePlusOne = (String)priceMap.get("onePlusOne");
              }

              
              
     //result.add(new SearchVO(thumbnail.get(i), prdUrl.get(i), prdPrice.get(i), prdName.get(i), colorList.get(i)));
   //public DiscountVO(String sale_prdUrl, String sale_imgUrl, String sale_beforeDiscountprice,
               //String sale_afterDiscountprice, int sale_discountRate, String sale_name,String s_sname)           
        //리스트<VO객체>에 넣기!
              resultVOList.add(new DiscountVO(prdUrl, imgUrl, beforePrice, afterPrice, discountRate,onePlusOne, prdName, s_sname));
           }
           //System.out.println("");
           //System.out.println("");
           //System.out.println("resultVOList: "+resultVOList);
           run(); //재귀함수로 다음페이지도 돌아가도록.
   //   }while
   }//function
   
   public String findPrdUrl(StringBuffer sb){
        String prdUrl = "";
   //상품url뽑기
        String pattern ="(/product/detail[^\"]*|/shop/view[^\"]*)";
      //  //System.out.println("indexof로 정규표현식이 뽑히나? : "+sb.indexOf(pattern));
        
        Pattern p = Pattern.compile(pattern); 
        Matcher matcher = p.matcher(sb);

       //while(matcher.find()){//여러개다뽑으면 while+스트링버퍼. 리턴도 스트링버퍼로.
       if(matcher.find()){//첫번째 것만 뽑을거니 if에 String하나로.
           prdUrl = matcher.group() ; //어우헷갈... 여기서 그룹1은  ([^>\"']+) 이다.  그룹(0)은 매칭된 전체.)
       }

     
       ////System.out.println("찾은 상품 prdUrl: "+prdUrl);
       
       return prdUrl;
   }
   
   /*
파라미터 sb: <li id="anchorBoxId_30137" class="item xans-record-">                <div class="box">                    <span class="chk"><input type="checkbox" class="ProductCompareClass xECPCNO_30137 displaynone"/></span>                    <a href="/product/detail.html?product_no=30137&cate_no=345&display_group=1" name="anchorBoxName_30137"><img src="//ggsing.com/web/product/medium/201601/30137_shop1_335264.jpg" alt="" class="thumb"/></a>                    <p class="name">                        <a href="/product/detail.html?product_no=30137&cate_no=345&display_group=1"><span style="font-size:12px;color:#000000;font-weight:bold;"><b>코팅 기모스키니</b></span></a><br/>                           </p>                    <ul class="xans-element- xans-product xans-product-listitem"><li class=" xans-record-"><strong class="title displaynone review_판매가"><span style="font-size:12px;color:#000000;font-weight:bold;">판매가</span> :</strong> <span style="font-size:12px;color:#000000;font-weight:bold;">8,800원</span><span id="span_product_tax_type_text" style=""> </span></li></ul><div class="crema-product-reviews-count" data-product-id="30137" data-format="리뷰 : {{{count}}}"></div>                    <p class="button">                        <span class="bag"><img src="http://img.echosting.cafe24.com/design/skin/default/product/btn_list_cart.gif" alt="장바구니넣기" onclick="" class="displaynone"/></span>                        <span class="option"><img src="http://img.echosting.cafe24.com/design/skin/default/product/btn_list_option.gif" alt="옵션보기" onclick="" onmouseout="" class="displaynone" id="btn_preview_listmain30137"/></span>                    </p>                </div>            </li>
파라미터 prdUrla href="/product/detail.html?product_no=30137&cate_no=345&display_group=1
    * 
    */
   public String findImgUrl(StringBuffer sb, String prdUrl){
      String imgUrl = "";
      int prdIndex = sb.indexOf(prdUrl);
      int endIndex = sb.indexOf("</a>");
      String subString = sb.substring(prdIndex, endIndex);
//      //System.out.println("파라미터 prdUrl: " +prdUrl);
//      //System.out.println("자른문자열: "+subString);
      
//       String pattern ="<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>";
       String pattern ="<img[^>]*src=[\"']?([^>\"']+)[.jpg|.gif|.png]{1}";
        Pattern p = Pattern.compile(pattern); 
        Matcher matcher = p.matcher(subString);

     //while(matcher.find()){//여러개다뽑으면 while+스트링버퍼. 리턴도 스트링버퍼로.
     if(matcher.find()){//첫번째 것만 뽑을거니 if에 String하나로.
         imgUrl = matcher.group() ; //어우헷갈... 여기서 그룹1은  ([^>\"']+) 이다.  그룹(0)은 매칭된 전체.)
         int colonIndex = imgUrl.indexOf("\"");
         imgUrl = imgUrl.substring(colonIndex+1);
     }
     ////System.out.println("찾은 상품 imgUrl: "+imgUrl);
     
      return imgUrl;
   }   
      
   //prdUrl이나 imgUrl의 맨앞에쇼핑몰도메인이없으면 shopurl을 앞에 붙여주어야함. "a href=\"/product/detail", "a href=\"/shop/view" 
   public String addShopUrl(String url){
        if(url.indexOf("/product/detail") ==0 ){
           url = shopUrl+url;
        }else if(url.indexOf("/shop/view") == 0){
           url = shopUrl+url;
        }
        return url;
   }
   
   //가격추출(할인전, 할인후, 할인율)  +( 1+1할인여부) 4가지 / beforePrice  afterPrice discountRate onePlusOne
   public Map<String,Object> findPrice(StringBuffer sb, String shopUrl){
      Map<String,Object> priceMap = new HashMap<String, Object>();       // beforePrice  afterPrice discountRate
      List <String> tempList = new ArrayList<String>();

      
      String tagRegex ="<[^>]*>";
      String priceRegex = "(\\d{1,3})(,\\d{3})*(,\\d{2})0"; //[원]?  //약간문제: 천원단위이상만 출력가능.
      //String priceRegex = "((\\d{1,3})(,\\d{3})*(,\\d{2})0|(\\d{1,2}0))";
      //String priceRegex = "^(\\d{1,3})(,\\d{3})*(,\\d{2})0|^(\\d{1,2}0)";

      //모든 태그 <>를 지운 후에 텍스트 값 중에서 가격에대한 정규표현식을 써보자.
      String subString = sb.toString().replaceAll(tagRegex, "").trim();
      ////System.out.println(subString);
       Pattern p = Pattern.compile(priceRegex); 
      Matcher matcher = p.matcher(subString);
      while(matcher.find()){
      //     //System.out.println("matcher.find()");
           tempList.add(matcher.group());
           //System.out.println(matcher.group());
        }
        
      // calDiscountRate함수에 tempList를넣고 Map을반환 (key: ) beforePrice  afterPrice discountRate  onePlusOne
        if(tempList.size() ==2){
           //System.out.println("tempList.size() == 2");
           priceMap = makePriceMap(tempList);
           
        }else if(tempList.size() == 1){ //priceMap직접초기화(index를맞추기위해 빈곳에는 공백을 추가.)
           //System.out.println("tempList.size() == 1");
           priceMap.put("beforePrice","");
           priceMap.put("afterPrice", tempList.get(0)+"원");
           priceMap.put("discountRate", 0);
           if(shopUrl.indexOf("hotping") != -1){
              priceMap.put("onePlusOne", ONEPLUS);
           }else{
              priceMap.put("onePlusOne", "");
           }
        }else if(tempList.size() == 3){ //이러면 세번째값이 얼마할인인지(두금액의 차)에대해 나오는 값인데 필요없음.
           tempList.remove(2);
           priceMap = makePriceMap(tempList);
           
        }
        //System.out.println("findPrice의 반환 priceMap: "+priceMap);

      return priceMap;
   }
   //가격 두개 대소비교 + 할인율계산함수호출해서 맵완성하기
   public Map<String,Object> makePriceMap(List priceList){
      Map<String,Object> priceMap = new HashMap<String,Object>();
      String tempStr1=(String)priceList.get(0);
      String tempStr2=(String)priceList.get(1);
      
      
      Pattern patternImg = Pattern.compile("[^\\d]"); //img 태그 src 추출 정규표현식
      String val1 =((String)priceList.get(0)).replaceAll("[^\\d]", "");
      String val2= ((String)priceList.get(1)).replaceAll("[^\\d]", "");

      int valInt1 = Integer.parseInt(val1);
      int valInt2 = Integer.parseInt(val2);

   //   //System.out.println("변환한 valInt1|valInt2|할인율 :  "+valInt1+" | "+valInt2+" | "+ calDiscountRate(valInt1, valInt2));
      
      //할인율 (A-B)/A*100과 큰수와 작은수를 판별해서 Map에넣어야.
       if(valInt1 >= valInt2){
          priceMap.put("beforePrice", tempStr1+"원"); 
          priceMap.put("afterPrice", tempStr2+"원");
          priceMap.put("discountRate", calDiscountRate(valInt1, valInt2));
       }else{
          priceMap.put("beforePrice", tempStr2+"원"); 
          priceMap.put("afterPrice", tempStr1+"원");
          priceMap.put("discountRate", calDiscountRate(valInt1, valInt2));
       }
   //   //System.out.println("makePriceMap리턴 "+priceMap );
      return priceMap;
   }
   
   //실제 할인율계산 함수
   public static int calDiscountRate(int val1, int val2){
      double a=val1;
      double b=val2;
      
      if(a >= b){
         double rDouble = ((a-b)/a)*100;
         int rInt = (int)rDouble;
      //   //System.out.println("a>=b 반환할인율: "+rInt);
         return rInt;
      }else{
         double rDouble = (((b-a)/b)*100);
         int rInt = (int)rDouble;
      //   //System.out.println("a < b반환할인율: "+rInt);
         return rInt;
      }
   }
   
   //일반할인이아닌 1+1할인여부(핫핑, String sale+onePlusOne)
   
   
   //상품명추출
   //클래스이름이 name인 p태그의 내용을 긁은후, 모든태그<>,"상품명"글자를 지우면 구하고자하는 '상품명'이 나온다.
   public String findprdName(StringBuffer sb, String prdUrl){
      //System.out.println("prdName 파라미터sb : "+sb);
      String prdName = "";
//      String pNameRegex = "(<p class=\"name\">)[^(</p>)]*(</p>)";  --> 주의:  틀린코드이다. [^문자문자문자]에서는 문자들중 하나만 인식한다.(06/09)
      String pNameRegex = "(<p class=\"name\">)((?!</p).)*</p>"; //(?!</p).*가 아닌 ((?!</p).)* 이다!   전자는(?!</p)한번만인식후 .* 여러글자이기때문.
      String removeRegex = "(<[^>]*>|상품명|:)";
//      String removeRegex = "(<[^>]*>|상품명|:|<br>[.]*)"; //상품명 뒤의 br태그이후를 지울지말지
      
       Pattern p = Pattern.compile(pNameRegex); 
        Matcher matcher = p.matcher(sb);
     //while(matcher.find()){//여러개다뽑으면 while+스트링버퍼. 리턴도 스트링버퍼로.
        if(matcher.find()){//첫번째 p태그 = p태그 내에  뽑을거니 if에 String하나로.
           prdName = matcher.group() ; //p태그뽑기
            
           prdName = prdName.replaceAll(removeRegex, "").trim();
            Pattern ifP = Pattern.compile(removeRegex);
            Matcher ifMatcher = ifP.matcher(prdName);
            
            if(ifMatcher.find()){
           //    //System.out.println("removeRegex 진입");
               prdName = matcher.group();
            }
        }
        
        //System.out.println("찾은 상품 pNameTag: "+prdName);
        
       //마지막a태그를 자르고나서, p태그에 한것과 비슷하게 <>모든태그를지우고 상품명과 :와 <br>의 뒤롤 지우려고했었다. 그런데 스타일난다는 상품명을 링크<a><span가아닌 일반<span>에 넣어둠. 예외발생.
       /*   String prdName = "";
          int prdIndex = sb.lastIndexOf(prdUrl);
          //System.out.println("sb.lastIndexOf(prdUrl): "+sb.indexOf(prdUrl));
          //제일큰시작값,제일작은끝값 66girls:only230,(382-430)/ stylenanda:(100-112),(382-617) / ggsing:230,427(완전일치) /loveloveme: only80,(309-737) / hotping:only261,668(완전일치) / dejou:only201,414(완전일치)
          int endIndex = sb.lastIndexOf("</a>");
          //System.out.println("sb.indexOf('</a>' ): "+ sb.lastIndexOf("</a>"));
          String subString = sb.substring(prdIndex, endIndex);
          ////System.out.println("파라미터 prdUrl: " +prdUrl);
          //System.out.println("자른문자열: "+subString);*/
        
        
      //실패한방법. sb에서 indexOf를할때 아예 '두번째'로 prdUrl과 일치하는 곳을 찾고싶었다. 불가능. 두번째인자는 생각외로 '몇번째로 일치하는 것'이 아니라, 말그대로 문자열의 인덱스이다.
   /*   //System.out.println("sb길이: "+sb.length());
      //System.out.println("prdUrl길이: "+prdUrl.length());
      // prdUrl길이 : 66girls:73 / stylenanda:74, / ggsing:73 /loveloveme:73  / hotping: 72 / dejou:71 (end url제일작은값보다 70정도 앞으로 땡겨서써도 될듯)
      //System.out.println("파라미터sb : "+sb);
      String prdName = "";
      int prdIndex = sb.indexOf(prdUrl, 270);
      //System.out.println("sb.indexOf(prdUrl): "+sb.indexOf(prdUrl));
      //System.out.println("sb.indexOf(prdUrl,2): "+sb.indexOf(prdUrl,270));
      //제일큰시작값,제일작은끝값 66girls:only230,(382-430)/ stylenanda:(100-112),(382-617) / ggsing:230,427(완전일치) /loveloveme: only80,(309-737) / hotping:only261,668(완전일치) / dejou:only201,414(완전일치)
      int endIndex = sb.indexOf("</a>",750);
      //System.out.println("sb.indexOf('</a>', ): "+ sb.indexOf("</a>"));
      //System.out.println("sb.indexOf('</a>',2 ): "+ sb.indexOf("</a>",750));
      String subString = sb.substring(prdIndex, endIndex);
      //System.out.println("파라미터 prdUrl: " +prdUrl);
      //System.out.println("자른문자열: "+subString);*/
      
      return prdName;
   }
   
   
/*   
   public static void main(String[] args) {
      //MywayThread thread = new MywayThread("http://66girls.co.kr/product/list.html?cate_no=306", "66girls.co.kr/", "66걸즈");
      //MywayThread thread = new MywayThread("http://www.stylenanda.com/product/list03.html?cate_no=613", "www.stylenanda.com/", "스타일난다");   //discount에 상품이없어서 일단 newUrl로
      //DiscountCrollingThread thread = new DiscountCrollingThread("http://ggsing.com/product/list.html?cate_no=345", "ggsing.com/", "고고싱");
      //MywayThread thread = new MywayThread("http://loveloveme.com/product/list.html?cate_no=884", "loveloveme.com/",);
      //MywayThread thread = new MywayThread("http://hotping.co.kr/product/list.html?cate_no=42", "hotping.co.kr/");
      //MywayThread thread = new MywayThread("http://www.dejou.co.kr/product/list.html?cate_no=34", "www.dejou.co.kr/");  //판매가격이 하나만 나올때도있음
      //MywayThread thread = new MywayThread("http://imvely.com/product/list.html?cate_no=72", "imvely.com/"); //discount자체가없어서 newUrl
   
      thread.start();
   }
*/   
   
   
   
   
}//class