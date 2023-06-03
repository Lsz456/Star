<%@ page import="java.util.List" %>
<%@ page import="org.example.entity.Anime" %>
<%@ page import="org.example.entity.Anime_Pending" %><%--
  Created by IntelliJ IDEA.
  User: lsz
  Date: 2023/4/7
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/";

    Anime anime = (Anime) request.getAttribute("anime");
    List<Anime_Pending> anime_pendingList = (List<Anime_Pending>) request.getAttribute("anime_pendingList");
    String videoUrl = (String) request.getAttribute("videoUrl");
    String url = (String) request.getAttribute("url");
    Long heightSize = (Long) request.getAttribute("number");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" name="referrer" content="never">
    <title>星辰·动漫</title>
    <base href="<%=basePath%>" />
    <link rel="stylesheet" type="text/css" href="css/style%20PlayVideoAnime.css">
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
        <!-- 详情页开始 -->
        <div class="xqy">
            <p class="link"><a href="<%=videoUrl%>">动漫</a> / <a href="<%=url%><%=anime.getA_id()%>"><%=anime.getA_title()%></a></p>
            <!-- 详情页开始 -->
            <div id="details">
                <!-- 左边开始 -->
                <div class="left">
                    <a href="<%=url%><%=anime.getA_id()%>"><img src="<%=anime.getA_image_url()%>"></a>
                </div>
                <!-- 左边结束 -->
                <!-- 右边开始 -->
                <div class="right">
                    <h2><%=anime.getA_title()%></h2>
                    <p>类型：<a href=""><%=anime.getA_type()%></a></p>
                    <p>总集数：<%=anime.getA_total_number()%></p>
                    <p>上次更新时间：<span><%=anime.getA_update_time()%></span></p>
                    <div class="introduction">
                        <p>简介：<%=anime.getA_description()%></p><span><a id="vanish" style="cursor: pointer">展开</a></span>
                        <script type="text/javascript">
                            $("#vanish").click(function() {
                                if ($("#vanish").text() == "展开"){
                                    $("#vanish").text("收起")
                                    $(".introduction").attr("style","height:196px");
                                }else {
                                    $("#vanish").html("展开")
                                    $(".introduction").attr("style","height:26px");
                                }
                            })
                        </script>
                    </div>
                    <%
                        for (Anime_Pending ap : anime_pendingList){
                    %>
                    <a href="cartoon/play.com?play_Id=<%=anime.getA_id()%>&numInt=<%=ap.getA_p_numInt()%>"><span class="playNow">立即播放</span></a>
                    <%
                            break;
                        }
                    %>
                </div>
                <!-- 右边结束 -->
            </div>
            <!-- 详情页结束 -->
            <%--HD播放开始--%>
            <div class="anthology" style="height: <%=heightSize%>px">
                <h3>HD播放</h3>
                <ul>
                    <%
                        for (Anime_Pending ap : anime_pendingList){
                    %>
                    <li><a href="cartoon/play.com?play_Id=<%=anime.getA_id()%>&numInt=<%=ap.getA_p_numInt()%>">第<%=ap.getA_p_numInt()%>集</a></li>
                    <%
                        }
                    %>
                </ul>
            </div>
            <%--HD播放结束--%>
            <!-- 猜你喜欢开始 -->
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
                <h3 class="like">猜你喜欢</h3>
                <%
                    int number = 1;
                    List<Anime> anime1 = (List<Anime>) request.getAttribute("animeList");
                    for (Anime anime2 : anime1){
                %>
                <div class="videoPush">
                    <span class="BeOver">更新至<%=anime2.getA_total_number()%>集</span>
<%--                    <span class="Score"><%=anime2.getA_score()%></span>--%>
                    <a id="img<%=number%>" href="cartoon/video.com?name=<%=anime2.getA_id()%>">
                        <img id="images<%=number%>" class="images" src="<%=anime2.getA_image_url()%>" >
                    </a>
                    <a href="cartoon/video.com?name=<%=anime2.getA_id()%>"><p><%=anime2.getA_title()%></p></a>
                </div>
                <%
                        number++;
                    }
                %>
            <!-- 猜你喜欢结束 -->
            </div>
            <!-- 详情页结束 -->
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
        </div>
        <!-- 底部结束 -->
    </div>
</body>
</html>