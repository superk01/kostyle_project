<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Scrolling Tabs Plugin Demo</title>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="../../../resources/css/closet/jquery.scrolling-tabs.css" rel="stylesheet" type="text/css">

<style>
.container { margin:150px auto;}
</style>
</head>

<body>


<div class="container">


<!-- Nav tabs -->
<ul class="nav nav-tabs" role="tablist">
  <li role="presentation" class="active"><a href="#tab1" role="tab" data-toggle="tab">Tab Number 1</a></li>
  <li role="presentation"><a href="#tab2" role="tab" data-toggle="tab">Tab Number 2</a></li>
  <li role="presentation"><a href="#tab3" role="tab" data-toggle="tab">Tab Number 3</a></li>
  <li role="presentation"><a href="#tab4" role="tab" data-toggle="tab">Tab Number 4</a></li>
  <li role="presentation"><a href="#tab5" role="tab" data-toggle="tab">Tab Number 5</a></li>
  <li role="presentation"><a href="#tab6" role="tab" data-toggle="tab">Tab Number 6</a></li>
</ul>

<!-- Tab panes -->
<div class="tab-content">
  <div role="tabpanel" class="tab-pane active" id="tab1"><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam congue laoreet magna. Nulla gravida est enim, at scelerisque ex fringilla vel. Quisque dolor mi, pulvinar eget eros non, condimentum placerat lorem. Proin quis dui molestie eros venenatis blandit vitae ut augue. Cras viverra nibh a augue congue, eget eleifend metus gravida. Etiam dui metus, pharetra vel efficitur at, convallis sed eros. Morbi mattis venenatis ipsum eget dignissim.</p></div>
  <div role="tabpanel" class="tab-pane" id="tab2"><p>Praesent rhoncus, ligula sed euismod accumsan, urna libero porttitor sem, in lacinia arcu massa ut enim. Nullam pellentesque tincidunt orci eu malesuada. Nam arcu sem, maximus nec arcu in, pellentesque lacinia nunc. Mauris elementum tellus enim. Duis mi justo, viverra et leo sit amet, consectetur finibus arcu. Donec semper ipsum et rhoncus dapibus. Praesent pulvinar nisi in orci tempus auctor. In scelerisque nibh a gravida convallis. Nunc malesuada felis eros, quis varius erat eleifend scelerisque. Ut auctor orci ut magna blandit tempus. In gravida diam erat, non gravida purus ullamcorper vitae. Cras gravida iaculis varius.</p></div>
  <div role="tabpanel" class="tab-pane" id="tab3"><p>Integer nulla lorem, pellentesque eget eros malesuada, semper bibendum felis. Proin quis est egestas, ultrices purus tempor, aliquet erat. Nullam molestie, neque at hendrerit semper, dui lacus eleifend arcu, quis mattis augue leo condimentum dui. Nunc vehicula eleifend risus vitae luctus. Sed sed sem nibh. Nam sit amet massa ullamcorper, iaculis felis id, ullamcorper libero. Aenean aliquet orci quis nisi interdum faucibus. Maecenas sollicitudin, nunc vitae tempus feugiat, arcu elit egestas diam, sit amet maximus neque turpis ac quam. Curabitur at ligula eget turpis pellentesque vestibulum eu id ante. Cras eget turpis mauris. Vestibulum vitae quam elit. Suspendisse bibendum at ipsum nec tempor. Ut in tristique nibh. Aliquam erat volutpat. In hac habitasse platea dictumst.</p></div>
  <div role="tabpanel" class="tab-pane" id="tab4"><p>Vivamus tempor viverra enim, commodo faucibus quam porta sed. Sed et varius nunc. Fusce cursus sem nec tellus accumsan, sed laoreet nisi vulputate. Praesent varius quis turpis in aliquam. Phasellus nisl velit, porttitor eget risus sed, interdum elementum nibh. Praesent eget ante bibendum quam suscipit accumsan sit amet eu nisi. Ut eget facilisis risus. Proin molestie lorem ut interdum finibus. Sed pretium ut sapien at dictum. Sed sit amet dolor tincidunt turpis tincidunt ultricies et et neque.</p></div>
  <div role="tabpanel" class="tab-pane" id="tab5"><p>Nam non augue a lorem tempor sodales. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Quisque ullamcorper lobortis rhoncus. Morbi nec dui vitae odio ultricies posuere ac nec turpis. Vestibulum efficitur lectus sem, sed volutpat quam congue at. Nulla quis aliquam ex. Vestibulum eget felis consectetur, efficitur risus non, dapibus tellus. Aliquam ac gravida dui. Donec vel est a arcu tristique egestas id vitae neque. Nullam varius odio eget leo porttitor, pharetra rhoncus quam dignissim..</p></div>
  <div role="tabpanel" class="tab-pane" id="tab6"><p>Nam non augue a lorem tempor sodales. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Quisque ullamcorper lobortis rhoncus. Morbi nec dui vitae odio ultricies posuere ac nec turpis. Vestibulum efficitur lectus sem, sed volutpat quam congue at. Nulla quis aliquam ex. Vestibulum eget felis consectetur, efficitur risus non, dapibus tellus. Aliquam ac gravida dui. Donec vel est a arcu tristique egestas id vitae neque. Nullam varius odio eget leo porttitor, pharetra rhoncus quam dignissim..</p></div>

</div>
</div>


<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="/SRC2/sctab/jquery.scrolling-tabs.js"></script>

<script>
$('.nav-tabs').scrollingTabs();
</script>

</body>
</html>
