<%@ page import="org.example.service.FilmService" %>
<%@ page import="javax.annotation.Resource" %>
<%@ page import="org.example.entity.Film" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.service.imp.FilmServiceImpl" %>
<%@ page import="org.example.entity.Anime" %>
<%@ page import="org.example.entity.Tv" %><%--
  Created by IntelliJ IDEA.
  User: Lsz
  Date: 2023/4/7
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 动态资源路径 http://localhost:8080/Star/
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" name="referrer" content="never">
    <title>Stars星辰</title>
    <base href="<%=basePath%>" />
    <link rel="stylesheet" type="text/css" href="css/style.css">
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
        <!-- 正片开始 -->
        <!-- 电影开始 -->
        <script type="text/javascript">
            $(document).ready(function (){
                for (let i = 1; i < 15; i++) {
                    $("#img"+[i]).on({
                        mouseenter : function () {
                            $("#images"+[i]).before('<img class="TopImg" src="images/playButton.png">')
                        },
                        mouseleave : function () {
                            $(".TopImg").remove();
                        }
                    })
                }
            })
        </script>
        <div class="positive">
            <p class="film"><a href="film/check.com">电影</a></p>
            <%
            List<Film> lists = (List<Film>) request.getAttribute("films");
            int number = 1;
            for (Film film : lists){
            %>
            <div class="videoPush">
<%--                <span class="BeOver"></span>--%>
<%--                <span class="Score"><%=film.getF_score()%></span>--%>
                <a id="img<%=number%>" href="film/video.com?name=<%=film.getF_id()%>">
                    <img id="images<%=number%>" class="images" src="<%=film.getF_images()%>">
                </a>
                <a href="film/video.com?name=<%=film.getF_id()%>"><p><%=film.getF_title()%></p></a>
            </div>
            <%
                    number++;
                }
            %>
        </div>
        <!-- 电影结束 -->
        <!-- 动漫开始 -->
        <script type="text/javascript">
            $(document).ready(function (){
                for (let i = 15; i < 29; i++) {
                    $("#img"+[i]).on({
                        mouseenter : function () {
                            $("#images"+[i]).before('<img class="TopImg" src="images/playButton.png">')
                        },
                        mouseleave : function () {
                            $(".TopImg").remove();
                        }
                    })
                }
            })
        </script>
        <div class="positive">
            <p class="anime"><a href="cartoon/check.com">动漫</a></p>
            <%
                List<Anime> animeList = (List<Anime>) request.getAttribute("animeList");
                for (Anime anime : animeList) {
            %>
            <div class="videoPush">
                <span class="BeOver">更新至<%=anime.getA_total_number()%>集</span>
<%--                <span class="Score"><%=anime.getA_score()%></span>--%>
                <a id="img<%=number%>" href="cartoon/video.com?name=<%=anime.getA_id()%>">
                    <img id="images<%=number%>" class="images" src="<%=anime.getA_image_url()%>">
                </a>
                <a href="cartoon/video.com?name=<%=anime.getA_id()%>"><p><%=anime.getA_title()%></p></a>
            </div>
            <%
                number++;
                }
            %>
        </div>
        <!-- 动漫结束 -->
        <!-- 电视剧开始 -->
        <script type="text/javascript">
            $(document).ready(function (){
                for (let i = 29; i < 43; i++) {
                    $("#img"+[i]).on({
                        mouseenter : function () {
                            $("#images"+[i]).before('<img class="TopImg" src="images/playButton.png">')
                        },
                        mouseleave : function () {
                            $(".TopImg").remove();
                        }
                    })
                }
            })
        </script>
        <div class="positive">
            <p class="tv"><a href="">电视剧</a></p>
            <%
                List<Tv> tvList = (List<Tv>) request.getAttribute("tvList");
                for(Tv tv : tvList) {
            %>
            <div class="videoPush">
                <span class="BeOver"><%=tv.getT_total_number()%></span>
<%--                <span class="Score"><%=tv.getT_heat()%></span>--%>
                <a id="img<%=number%>" href="teleplay/video.com?name=<%=tv.getT_id()%>">
                    <img id="images<%=number%>" class="images" src="<%=tv.getT_image_url()%>">
                </a>
                <a href="teleplay/video.com?name=<%=tv.getT_id()%>"><p><%=tv.getT_title()%></p></a>
            </div>
            <%
                number++;
                }
            %>
        </div>
        <!-- 电视剧结束 -->
        <!-- 正片结束 -->
        <!-- 底部开始 -->
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
