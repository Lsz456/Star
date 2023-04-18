<%@ page import="org.example.entity.Anime" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/4/7
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+
                    request.getServerPort()+request.getContextPath()+"/";

    List<Anime> animeList = (List<Anime>) request.getAttribute("animeList");
    Integer beginNum = (Integer) request.getAttribute("beginNum");
    Integer dataPage = (Integer) request.getAttribute("dataPage");
    Integer insertNum;
    if (beginNum == dataPage){
        insertNum = beginNum - 4;
    }else if (beginNum == dataPage - 1){
        insertNum = beginNum - 3;
    }else{
        insertNum = beginNum - 2;
    }
    Integer previousPage = (Integer) request.getAttribute("previousPage");
    Integer nextPage = (Integer) request.getAttribute("nextPage");
    Integer[] array = new Integer[5];
    for (int i = 0; i < array.length; i++) {
        if(beginNum < 5){
            array[i] = i + 1;
        }else {
            array[i] = insertNum++;
        }
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" name="referrer" content="never">
    <title>星辰·动漫</title>
    <base href="<%=basePath%>" />
    <link rel="stylesheet" type="text/css" href="css/style%20Anime.css">
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
                    <input type="text" name="search">
                    <input type="submit" value="全网搜">
                </form>
            </div>
        </div>
        <!-- 导航结束 -->
        <!-- 正片开始 -->
        <!-- 动漫开始 -->
        <div class="anime">
            <!-- 查询开始 -->
            <div class="find">
                <span>已选择：最新-动漫</span>
                <p style="cursor: pointer"><a id="vanish">展开</a></p>
                <script type="text/javascript">
                    $("#vanish").click(function() {
                        if ($(".vanish").hasClass("vanish")){
                            $("#vanish").text("收起")
                            $(".vanish").removeClass(" vanish");
                            $(".find").attr("style","height:120px");
                            $(".box").attr("style","height:1200px");
                            $(".anime").attr("style","height:968px");
                        }else {
                            $(".rbj").addClass(" vanish");
                            $("#vanish").html("展开")
                            $(".find").attr("style","height:0px");
                            $(".box").attr("style","height:1080px");
                            $(".anime").attr("style","height:848px");
                        }
                    })
                </script>
                <div class="rbj vanish">
                    <ul>
                        <li class="backGauge">按剧情：</li>
                        <li><a href="">情感</a></li>
                        <li><a href="">科幻</a></li>
                        <li><a href="">热血</a></li>
                        <li><a href="">推理</a></li>
                        <li><a href="">搞笑</a></li>
                        <li><a href="">冒险</a></li>
                        <li><a href="">萝莉</a></li>
                        <li><a href="">校园</a></li>
                        <li><a href="">动作</a></li>
                        <li><a href="">机战</a></li>
                        <li><a href="">运动</a></li>
                        <li><a href="">战争</a></li>
                        <li><a href="">少年</a></li>
                    </ul>
                </div>
                <div class="rbj vanish">
                    <ul>
                        <li class="backGauge">按地区：</li>
                        <li><a href="">中国</a></li>
                        <li><a href="">日本</a></li>
                        <li><a href="">欧美</a></li>
                        <li><a href="">其他</a></li>
                    </ul>
                </div>
                <div class="rbj vanish">
                    <ul>
                        <li class="backGauge">按年份：</li>
                        <li><a href="">2023</a></li>
                        <li><a href="">2022</a></li>
                        <li><a href="">2021</a></li>
                        <li><a href="">2020</a></li>
                        <li><a href="">2019</a></li>
                        <li><a href="">2018</a></li>
                        <li><a href="">2017</a></li>
                        <li><a href="">2016</a></li>
                        <li><a href="">2015</a></li>
                        <li><a href="">2014</a></li>
                        <li><a href="">2013</a></li>
                        <li><a href="">2012</a></li>
                    </ul>
                </div>
            </div>
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
                <%
                    int number = 1;
                    for (Anime anime : animeList){
                %>
                <div class="videoPush">
                    <span class="BeOver">更新至<%=anime.getA_total_number()%>集</span>
<%--                    <span class="Score"><%=anime.getA_score()%></span>--%>
                    <a id="img<%=number%>" href="cartoon/video.com?name=<%=anime.getA_id()%>">
                        <img id="images<%=number%>" class="images" src="<%=anime.getA_image_url()%>">
                    </a>
                    <a href="cartoon/video.com?name=<%=anime.getA_id()%>"><p><%=anime.getA_title()%></p></a>
                </div>
                <%
                        number++;
                    }
                %>
                <!-- 动漫结束 -->
                <!--下一页开始-->
                <div class="nextPage">
                    <ul>
                        <li><a href="cartoon/nextPage.com?beginNum=1">首页</a></li>
                        <%
                            if (previousPage == 0){
                        %>
                        <li><a href="cartoon/nextPage.com?beginNum=1">上一页</a></li>
                        <%
                        }else{
                        %>
                        <li><a href="cartoon/nextPage.com?beginNum=<%=previousPage%>">上一页</a></li>
                        <%
                            }
                            for (int i = 0; i < array.length; i++) {
                                if (beginNum == array[i]){

                        %>
                        <li><a style="color: #fdf751" href="cartoon/nextPage.com?beginNum=<%=array[i]%>"><%=array[i]%></a></li>
                        <%
                                }else{
                        %>
                        <li><a href="cartoon/nextPage.com?beginNum=<%=array[i]%>"><%=array[i]%></a></li>
                        <%
                                }
                            }
                            if (nextPage > dataPage){
                        %>
                        <li><a href="cartoon/nextPage.com?beginNum=<%=dataPage%>">下一页</a></li>
                        <%
                        }else {
                        %>
                        <li><a href="cartoon/nextPage.com?beginNum=<%=nextPage%>">下一页</a></li>
                        <%
                            }
                        %>
                        <li><a href="cartoon/nextPage.com?beginNum=<%=dataPage%>">尾页</a></li>
                    </ul>
                </div>
                <!--下一页结束-->
            </div>
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
    </div>
</body>
</html>
