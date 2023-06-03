<%@ page import="org.example.entity.Film" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/4/7
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/";

    Film film = (Film) request.getAttribute("film");
    String videoUrl = (String) request.getAttribute("videoUrl");
    String url = (String) request.getAttribute("url");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" name="referrer" content="never">
    <title>星辰·电影</title>
    <base href="<%=basePath%>" />
    <link rel="stylesheet" type="text/css" href="css/style%20PlayVideoFilm.css">
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
            <p class="link"><a href="<%=videoUrl%>">电影</a> / <a href="<%=url%><%=film.getF_id()%>"><%=film.getF_title()%></a></p>
            <!-- 详情页开始 -->
            <div id="details">
                <!-- 左边开始 -->
                <div class="left">
                    <a href="<%=url%><%=film.getF_id()%>"><img src="<%=film.getF_images()%>"></a>
                </div>
                <!-- 左边结束 -->
                <!-- 右边开始 -->
                <div class="right">
                    <h2><%=film.getF_title()%></h2>
                    <p>类型：<a href=""><%=film.getF_area().equals("null") ? film.getF_type() : film.getF_area()%></a></p>
                    <p><%=film.getF_director().length() > 1 ? "导演：" + film.getF_director() : ""%></p>
                    <p>主演：<%=film.getF_star()%></p>
                    <p>年代：<a href=""><%=film.getF_year()%></a></p>
                    <p>上次更新：<span><%=film.getF_update_time()%></span></p>
                    <div class="introduction">
                        <p>简介：<%=film.getF_Introduction()%></p><span style="top: <%=film.getF_director().length() > 1 ? 304 : 279%>px;"><a id="vanish" style="cursor: pointer">展开</a></span>
                        <script type="text/javascript">
                            $("#vanish").click(function() {
                                if ($("#vanish").text() == "展开"){
                                    $("#vanish").text("收起")
                                    $(".introduction").attr("style","height:120px");
                                }else {
                                    $("#vanish").html("展开")
                                    $(".introduction").attr("style","height:26px");
                                }
                            })
                        </script>
                    </div>
                    <a href="film/play.com?name=<%=film.getF_id()%>"><span class="playNow">立即播放</span></a>
                </div>
                <!-- 右边结束 -->
            </div>
            <!-- 详情页结束 -->
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
                <p class="like">猜你喜欢</p>
                <%
                    int number = 1;
                    List<Film> films = (List<Film>) request.getAttribute("films");
                    for (Film movie : films){
                %>
                <div class="videoPush">
<%--                    <span class="BeOver"></span>--%>
<%--                    <span class="Score"><%=movie.getF_score()%></span>--%>
                    <a id="img<%=number%>" href="film/video.com?name=<%=movie.getF_id()%>">
                        <img id="images<%=number%>" class="images" src="<%=movie.getF_images()%>" >
                    </a>
                    <a href="film/video.com?name=<%=movie.getF_id()%>"><p><%=movie.getF_title()%></p></a>
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