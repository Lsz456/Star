<%@ page import="org.example.entity.Film" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/4/13
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/";

    Film film = (Film) request.getAttribute("film");
    String url = (String) request.getAttribute("url");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" name="referrer" content="never">
    <title>星辰·电影</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="css/style%20Play.css">
    <script src="js/jquery-3.4.1.js"></script>
</head>
<body>
<div class="box">
    <!-- 导航开始 -->
    <div class="navigation">
        <div class="option">
            <a href="HomePage/main.com"><img src="images/Star.png" class="stars" alt="星辰影院"></a>
            <a href="HomePage/main.com">首页</a>
            <a href="film/check.com">电影</a>
            <a href="cartoon/check.com">动漫</a>
            <a href="teleplay/check.com">电视剧</a>
            <a href="#">历史记录</a>
            <form action="HomePage/find.com" method="get">
                <input type="text" name="content">
                <input type="submit" value="全网搜">
            </form>
        </div>
    </div>
    <!-- 导航结束 -->
    <!-- 播放页开始 -->
    <div class="xqy">
        <!--播放开始-->
        <div class="play">
            <iframe id="video" src="<%=url%><%=film.getF_url()%>"
                    allowfullscreen="true" allowtransparency="true"></iframe>
            <%--<iframe id="video" src="https://yparse.7te.cc/index.php?url=<%=film.getF_url()%>?vfm=f_191_360y&amp;fv=p_09_01"
                    allowfullscreen="true" allowtransparency="true"></iframe>--%>
        </div>
        <!--播放结束-->
        <!-- 简介开始 -->
        <div class="intro">
            <div class="switchRoutes">
                <span><a href="">< 上一集</a></span>
                <span class="interval"><a href="">下一集 ></a></span>
                <span id="spacing" class="interval">切换线路</span>
                <ul id="conceal" style="display: none">
                    <li><a href="film/play.com?name=<%=film.getF_id()%>">线路1</a></li>
                    <li><a href="film/switchRoutes.com?name=<%=film.getF_id()%>">线路2</a></li>
                </ul>
            </div>
            <h2><%=film.getF_title()%></h2>
            <p><%=film.getF_year()%> / <%=film.getF_area().equals("null") ? film.getF_type() : film.getF_area()%><span id="vanish" style="cursor: pointer">展开 ﹀</span></p>
            <div class="introduce">
                <p>主演：<%=film.getF_star()%></p>
                <p><%=film.getF_director().length() > 1 ? "导演：" + film.getF_director() : ""%></p>
                <p>类型：<%=film.getF_area().equals("null") ? film.getF_type() : film.getF_area()%></p>
                <p>简介：<%=film.getF_Introduction()%>
                    <script type="text/javascript">
                        let number = null;
                        $('#spacing').click(function(){
                            if(number == null){
                                $('#conceal').attr("style","display:")
                                number = 1;
                            }else{
                                $('#conceal').attr("style","display:none")
                                number = null;
                            }
                        })
                        $("#vanish").click(function() {
                            if ($("#vanish").text() == "展开 ﹀"){
                                $("#vanish").text("收起 ︿")
                                $(".introduce").attr("style","height:220px");
                                $(".intro").attr("style","height:284px");
                                $(".xqy").attr("style","height:926px");
                                $(".box").attr("style","height:1148px");
                            }else {
                                $("#vanish").html("展开 ﹀")
                                $(".introduce").attr("style","height:0px");
                                $(".intro").attr("style","height:90px");
                                $(".xqy").attr("style","height:732px");
                                $(".box").attr("style","height:960px");
                            }
                        })
                    </script>
            </div>
        </div>
        <!-- 简介结束 -->
    </div>
    <!-- 播放页结束 -->
    <!-- 版权开始 -->
    <div class="copyright">
        <p>
            版权所有&copy;全都是人才工作室&nbsp;&nbsp;联系邮箱：ll1084122002@163.com<br />
            <span><a href="https://www.itrust.org.cn/search_k.php" target="blank">中国互联网诚信联盟</a></span>
            <span><a href="https://www.12377.cn/jbzn.html?tab=4" target="blank">中国互联网举报中心</a></span>
            <span><a href="https://www.12377.cn/node_548446.htm" target="blank">网络举报APP下载</a></span>
            <span><a href="https://www.12377.cn/" target="blank">网上有害信息举报举报专区</a></span><br />
            本站所有视频和图片均来自互联网收集而来，若本站收录得节目无意冒犯了贵司版权，请及时联系我们：ll1084122002@163.com，确认后，我们会尽快删除。
        </p>
    </div>
    <!-- 底部结束 -->
</div>
</body>
</html>
