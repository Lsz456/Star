<%@ page import="java.util.List" %>
<%@ page import="org.example.entity.Tv" %>
<%@ page import="org.example.entity.Tv_Pending" %><%--
  Created by IntelliJ IDEA.
  User: lsz
  Date: 2023/4/7
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+
                    request.getServerPort()+request.getContextPath()+"/";

    Tv tv = (Tv) request.getAttribute("tv");
    String videoUrl = (String) request.getAttribute("videoUrl");
    String url = (String) request.getAttribute("url");
    List<Tv_Pending> tv_pendingList = (List<Tv_Pending>) request.getAttribute("tv_pendingList");
    Long heightSize = (Long) request.getAttribute("number");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" name="referrer" content="never">
    <title>星辰·电视剧</title>
    <base href="<%=basePath%>" />
    <link rel="stylesheet" type="text/css" href="css/style%20PlayVideoTv.css">
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
                <form action="#" method="get">
                    <input type="text" name="inputContent">
                    <input type="submit" value="全网搜">
                </form>
            </div>
        </div>
        <!-- 导航结束 -->
        <!-- 详情页开始 -->
        <div class="xqy">
            <p class="link"><a href="<%=videoUrl%>">电视剧</a> / <a href="<%=url%><%=tv.getT_id()%>"><%=tv.getT_title()%></a></p>
            <!-- 详情页开始 -->
            <div id="details">
                <!-- 左边开始 -->
                <div class="left">
                    <a href="<%=url%><%=tv.getT_id()%>"><img src="<%=tv.getT_image_url()%>"></a>
                </div>
                <!-- 左边结束 -->
                <!-- 右边开始 -->
                <div class="right">
                    <h2><%=tv.getT_title()%></h2>
                    <p>类型：<a href=""><%=tv.getT_type()%></a></p>
                    <p>主演：<%=tv.getT_star()%></p>
                    <p>总集数：<%=tv.getT_total_number()%></p>
                    <p>上次更新时间：<span><%=tv.getT_Update_time()%></span></p>
                    <div class="introduction">
                        <p>简介：<%=tv.getT_description()%></p><span><a id="vanish" style="cursor: pointer">展开</a></span>
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
                        for (Tv_Pending tp : tv_pendingList){
                    %>
                    <a href="teleplay/play.com?play_Id=<%=tv.getT_id()%>&numInt=<%=tp.getT_p_numInt()%>"><span class="playNow">立即播放</span></a>
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
                        for (Tv_Pending tp : tv_pendingList){
                    %>
                    <li><a href="teleplay/play.com?play_Id=<%=tv.getT_id()%>&numInt=<%=tp.getT_p_numInt()%>">第<%=tp.getT_p_numInt()%>集</a></li>
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
                    List<Tv> tvList = (List<Tv>) request.getAttribute("tvList");
                    for (Tv tv1 : tvList){
                %>
                <div class="videoPush">
                    <span class="BeOver"><%=tv1.getT_total_number()%></span>
<%--                    <span class="Score"><%=tv1.getT_heat()%></span>--%>
                    <a id="img<%=number%>" href="teleplay/video.com?name=<%=tv1.getT_id()%>">
                        <img id="images<%=number%>" class="images" src="<%=tv1.getT_image_url()%>" >
                    </a>
                    <a href="teleplay/video.com?name=<%=tv1.getT_id()%>"><p><%=tv1.getT_title()%></p></a>
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