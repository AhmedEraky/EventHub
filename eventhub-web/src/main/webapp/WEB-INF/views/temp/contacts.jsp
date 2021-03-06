<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="${contextPath}/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="${contextPath}/resources/vendors/nprogress/nprogress.css" rel="stylesheet">
        <link href="${contextPath}/resources/build/css/custom.min.css" rel="stylesheet">
        <title>Contacts</title>


    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">
                        <div class="navbar nav_title" style="border: 0;">
                            <a href="index" class="site_title"><i class="fa fa-paw"></i> <span>Gentelella Alela!</span></a>
                        </div>

                        <div class="clearfix"></div>

                        <!-- menu profile quick info -->
                        <div class="profile clearfix">
                            <div class="profile_pic">
                                <img src="${contextPath}/resources/images/img.jpg" alt="..." class="img-circle profile_img">
                            </div>
                            <div class="profile_info">
                                <span>Welcome,</span>
                                <h2>John Doe</h2>
                            </div>
                        </div>
                        <!-- /menu profile quick info -->

                        <br />

                        <!-- sidebar menu -->
                        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                            <div class="menu_section">
                                <h3>General</h3>
                                <ul class="nav side-menu">
                                    <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="index">Dashboard</a></li>
                                            <li><a href="index2">Dashboard2</a></li>
                                            <li><a href="index3">Dashboard3</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-edit"></i> Forms <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="form">General Form</a></li>
                                            <li><a href="form_advanced">Advanced Components</a></li>
                                            <li><a href="form_validation">Form Validation</a></li>
                                            <li><a href="form_wizards">Form Wizard</a></li>
                                            <li><a href="form_upload">Form Upload</a></li>
                                            <li><a href="form_buttons">Form Buttons</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-desktop"></i> UI Elements <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="general_elements">General Elements</a></li>
                                            <li><a href="media_gallery">Media Gallery</a></li>
                                            <li><a href="typography">Typography</a></li>
                                            <li><a href="icons">Icons</a></li>
                                            <li><a href="glyphicons">Glyphicons</a></li>
                                            <li><a href="widgets">Widgets</a></li>
                                            <li><a href="invoice">Invoice</a></li>
                                            <li><a href="inbox">Inbox</a></li>
                                            <li><a href="calendar">Calendar</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-table"></i> Tables <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="tables">Tables</a></li>
                                            <li><a href="tables_dynamic">Table Dynamic</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="chartjs">Chart JS</a></li>
                                            <li><a href="chartjs2">Chart JS2</a></li>
                                            <li><a href="morisjs">Moris JS</a></li>
                                            <li><a href="echarts">ECharts</a></li>
                                            <li><a href="other_charts">Other Charts</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-clone"></i>Layouts <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="fixed_sidebar">Fixed Sidebar</a></li>
                                            <li><a href="fixed_footer">Fixed Footer</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <div class="menu_section">
                                <h3>Live On</h3>
                                <ul class="nav side-menu">
                                    <li><a><i class="fa fa-bug"></i> Additional Pages <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="e_commerce">E-commerce</a></li>
                                            <li><a href="projects">Projects</a></li>
                                            <li><a href="project_detail">Project Detail</a></li>
                                            <li><a href="contacts">Contacts</a></li>
                                            <li><a href="profile">Profile</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="page_403">403 Error</a></li>
                                            <li><a href="page_404">404 Error</a></li>
                                            <li><a href="page_500">500 Error</a></li>
                                            <li><a href="plain_page">Plain Page</a></li>
                                            <li><a href="login">Login Page</a></li>
                                            <li><a href="pricing_tables">Pricing Tables</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-sitemap"></i> Multilevel Menu <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="#level1_1">Level One</a>
                                            <li><a>Level One<span class="fa fa-chevron-down"></span></a>
                                                <ul class="nav child_menu">
                                                    <li class="sub_menu"><a href="level2">Level Two</a>
                                                    </li>
                                                    <li><a href="#level2_1">Level Two</a>
                                                    </li>
                                                    <li><a href="#level2_2">Level Two</a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li><a href="#level1_2">Level One</a>
                                            </li>
                                        </ul>
                                    </li>                  
                                    <li><a href="javascript:void(0)"><i class="fa fa-laptop"></i> Landing Page <span class="label label-success pull-right">Coming Soon</span></a></li>
                                </ul>
                            </div>

                        </div>
                        <!-- /sidebar menu -->

                        <!-- /menu footer buttons -->
                        <div class="sidebar-footer hidden-small">
                            <a data-toggle="tooltip" data-placement="top" title="Settings">
                                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                            </a>
                            <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                            </a>
                            <a data-toggle="tooltip" data-placement="top" title="Lock">
                                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                            </a>
                            <a data-toggle="tooltip" data-placement="top" title="Logout" href="login">
                                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                            </a>
                        </div>
                        <!-- /menu footer buttons -->
                    </div>
                </div>

                <!-- top navigation -->
                <div class="top_nav">
                    <div class="nav_menu">
                        <nav>
                            <div class="nav toggle">
                                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                            </div>

                            <ul class="nav navbar-nav navbar-right">
                                <li class="">
                                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <img src="${contextPath}/resources/images/img.jpg" alt="">John Doe
                                        <span class=" fa fa-angle-down"></span>
                                    </a>
                                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                                        <li><a href="javascript:;"> Profile</a></li>
                                        <li>
                                            <a href="javascript:;">
                                                <span class="badge bg-red pull-right">50%</span>
                                                <span>Settings</span>
                                            </a>
                                        </li>
                                        <li><a href="javascript:;">Help</a></li>
                                        <li><a href="login"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                                    </ul>
                                </li>

                                <li role="presentation" class="dropdown">
                                    <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                        <i class="fa fa-envelope-o"></i>
                                        <span class="badge bg-green">6</span>
                                    </a>
                                    <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                                        <li>
                                            <a>
                                                <span class="image"><img src="${contextPath}/resources/images/img.jpg" alt="Profile Image" /></span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a>
                                                <span class="image"><img src="${contextPath}/resources/images/img.jpg" alt="Profile Image" /></span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a>
                                                <span class="image"><img src="${contextPath}/resources/images/img.jpg" alt="Profile Image" /></span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a>
                                                <span class="image"><img src="${contextPath}/resources/images/img.jpg" alt="Profile Image" /></span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <div class="text-center">
                                                <a>
                                                    <strong>See All Alerts</strong>
                                                    <i class="fa fa-angle-right"></i>
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <!-- /top navigation -->

                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Contacts Design</h3>
                            </div>

                            <div class="title_right">
                                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="Search for...">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="button">Go!</button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="clearfix"></div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="x_panel">
                                    <div class="x_content">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12 col-xs-12 text-center">
                                                <ul class="pagination pagination-split">
                                                    <li><a href="#">A</a></li>
                                                    <li><a href="#">B</a></li>
                                                    <li><a href="#">C</a></li>
                                                    <li><a href="#">D</a></li>
                                                    <li><a href="#">E</a></li>
                                                    <li>...</li>
                                                    <li><a href="#">W</a></li>
                                                    <li><a href="#">X</a></li>
                                                    <li><a href="#">Y</a></li>
                                                    <li><a href="#">Z</a></li>
                                                </ul>
                                            </div>

                                            <div class="clearfix"></div>

                                            <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                                                <div class="well profile_view">
                                                    <div class="col-sm-12">
                                                        <h4 class="brief"><i>Digital Strategist</i></h4>
                                                        <div class="left col-xs-7">
                                                            <h2>Nicole Pearson</h2>
                                                            <p><strong>About: </strong> Web Designer / UX / Graphic Artist / Coffee Lover </p>
                                                            <ul class="list-unstyled">
                                                                <li><i class="fa fa-building"></i> Address: </li>
                                                                <li><i class="fa fa-phone"></i> Phone #: </li>
                                                            </ul>
                                                        </div>
                                                        <div class="right col-xs-5 text-center">
                                                            <img src="${contextPath}/resources/images/img.jpg" alt="" class="img-circle img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 bottom text-center">
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <p class="ratings">
                                                                <a>4.0</a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star-o"></span></a>
                                                            </p>
                                                        </div>
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                                                </i> <i class="fa fa-comments-o"></i> </button>
                                                            <button type="button" class="btn btn-primary btn-xs">
                                                                <i class="fa fa-user"> </i> View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                                                <div class="well profile_view">
                                                    <div class="col-sm-12">
                                                        <h4 class="brief"><i>Digital Strategist</i></h4>
                                                        <div class="left col-xs-7">
                                                            <h2>Nicole Pearson</h2>
                                                            <p><strong>About: </strong> Web Designer / UI. </p>
                                                            <ul class="list-unstyled">
                                                                <li><i class="fa fa-building"></i> Address: </li>
                                                                <li><i class="fa fa-phone"></i> Phone #: </li>
                                                            </ul>
                                                        </div>
                                                        <div class="right col-xs-5 text-center">
                                                            <img src="${contextPath}/resources/images/user.png" alt="" class="img-circle img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 bottom text-center">
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <p class="ratings">
                                                                <a>4.0</a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star-o"></span></a>
                                                            </p>
                                                        </div>
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                                                </i> <i class="fa fa-comments-o"></i> </button>
                                                            <button type="button" class="btn btn-primary btn-xs">
                                                                <i class="fa fa-user"> </i> View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                                                <div class="well profile_view">
                                                    <div class="col-sm-12">
                                                        <h4 class="brief"><i>Digital Strategist</i></h4>
                                                        <div class="left col-xs-7">
                                                            <h2>Nicole Pearson</h2>
                                                            <p><strong>About: </strong> Web Designer / UI. </p>
                                                            <ul class="list-unstyled">
                                                                <li><i class="fa fa-building"></i> Address: </li>
                                                                <li><i class="fa fa-phone"></i> Phone #: </li>
                                                            </ul>
                                                        </div>
                                                        <div class="right col-xs-5 text-center">
                                                            <img src="${contextPath}/resources/images/user.png" alt="" class="img-circle img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 bottom text-center">
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <p class="ratings">
                                                                <a>4.0</a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star-o"></span></a>
                                                            </p>
                                                        </div>
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                                                </i> <i class="fa fa-comments-o"></i> </button>
                                                            <button type="button" class="btn btn-primary btn-xs">
                                                                <i class="fa fa-user"> </i> View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                                                <div class="well profile_view">
                                                    <div class="col-sm-12">
                                                        <h4 class="brief"><i>Digital Strategist</i></h4>
                                                        <div class="left col-xs-7">
                                                            <h2>Nicole Pearson</h2>
                                                            <p><strong>About: </strong> Web Designer / UI. </p>
                                                            <ul class="list-unstyled">
                                                                <li><i class="fa fa-building"></i> Address: </li>
                                                                <li><i class="fa fa-phone"></i> Phone #: </li>
                                                            </ul>
                                                        </div>
                                                        <div class="right col-xs-5 text-center">
                                                            <img src="${contextPath}/resources/images/user.png" alt="" class="img-circle img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 bottom text-center">
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <p class="ratings">
                                                                <a>4.0</a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star-o"></span></a>
                                                            </p>
                                                        </div>
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                                                </i> <i class="fa fa-comments-o"></i> </button>
                                                            <button type="button" class="btn btn-primary btn-xs">
                                                                <i class="fa fa-user"> </i> View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                                                <div class="well profile_view">
                                                    <div class="col-sm-12">
                                                        <h4 class="brief"><i>Digital Strategist</i></h4>
                                                        <div class="left col-xs-7">
                                                            <h2>Nicole Pearson</h2>
                                                            <p><strong>About: </strong> Web Designer / UX / Graphic Artist / Coffee Lover </p>
                                                            <ul class="list-unstyled">
                                                                <li><i class="fa fa-building"></i> Address: </li>
                                                                <li><i class="fa fa-phone"></i> Phone #: </li>
                                                            </ul>
                                                        </div>
                                                        <div class="right col-xs-5 text-center">
                                                            <img src="${contextPath}/resources/images/img.jpg" alt="" class="img-circle img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 bottom text-center">
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <p class="ratings">
                                                                <a>4.0</a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star-o"></span></a>
                                                            </p>
                                                        </div>
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                                                </i> <i class="fa fa-comments-o"></i> </button>
                                                            <button type="button" class="btn btn-primary btn-xs">
                                                                <i class="fa fa-user"> </i> View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                                                <div class="well profile_view">
                                                    <div class="col-sm-12">
                                                        <h4 class="brief"><i>Digital Strategist</i></h4>
                                                        <div class="left col-xs-7">
                                                            <h2>Nicole Pearson</h2>
                                                            <p><strong>About: </strong> Web Designer / UI. </p>
                                                            <ul class="list-unstyled">
                                                                <li><i class="fa fa-building"></i> Address: </li>
                                                                <li><i class="fa fa-phone"></i> Phone #: </li>
                                                            </ul>
                                                        </div>
                                                        <div class="right col-xs-5 text-center">
                                                            <img src="${contextPath}/resources/images/user.png" alt="" class="img-circle img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 bottom text-center">
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <p class="ratings">
                                                                <a>4.0</a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star-o"></span></a>
                                                            </p>
                                                        </div>
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                                                </i> <i class="fa fa-comments-o"></i> </button>
                                                            <button type="button" class="btn btn-primary btn-xs">
                                                                <i class="fa fa-user"> </i> View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                                                <div class="well profile_view">
                                                    <div class="col-sm-12">
                                                        <h4 class="brief"><i>Digital Strategist</i></h4>
                                                        <div class="left col-xs-7">
                                                            <h2>Nicole Pearson</h2>
                                                            <p><strong>About: </strong> Web Designer / UI. </p>
                                                            <ul class="list-unstyled">
                                                                <li><i class="fa fa-building"></i> Address: </li>
                                                                <li><i class="fa fa-phone"></i> Phone #: </li>
                                                            </ul>
                                                        </div>
                                                        <div class="right col-xs-5 text-center">
                                                            <img src="${contextPath}/resources/images/user.png" alt="" class="img-circle img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 bottom text-center">
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <p class="ratings">
                                                                <a>4.0</a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star-o"></span></a>
                                                            </p>
                                                        </div>
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                                                </i> <i class="fa fa-comments-o"></i> </button>
                                                            <button type="button" class="btn btn-primary btn-xs">
                                                                <i class="fa fa-user"> </i> View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                                                <div class="well profile_view">
                                                    <div class="col-sm-12">
                                                        <h4 class="brief"><i>Digital Strategist</i></h4>
                                                        <div class="left col-xs-7">
                                                            <h2>Nicole Pearson</h2>
                                                            <p><strong>About: </strong> Web Designer / UI. </p>
                                                            <ul class="list-unstyled">
                                                                <li><i class="fa fa-building"></i> Address: </li>
                                                                <li><i class="fa fa-phone"></i> Phone #: </li>
                                                            </ul>
                                                        </div>
                                                        <div class="right col-xs-5 text-center">
                                                            <img src="${contextPath}/resources/images/user.png" alt="" class="img-circle img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 bottom text-center">
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <p class="ratings">
                                                                <a>4.0</a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star-o"></span></a>
                                                            </p>
                                                        </div>
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                                                </i> <i class="fa fa-comments-o"></i> </button>
                                                            <button type="button" class="btn btn-primary btn-xs">
                                                                <i class="fa fa-user"> </i> View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                                                <div class="well profile_view">
                                                    <div class="col-sm-12">
                                                        <h4 class="brief"><i>Digital Strategist</i></h4>
                                                        <div class="left col-xs-7">
                                                            <h2>Nicole Pearson</h2>
                                                            <p><strong>About: </strong> Web Designer / UI. </p>
                                                            <ul class="list-unstyled">
                                                                <li><i class="fa fa-building"></i> Address: </li>
                                                                <li><i class="fa fa-phone"></i> Phone #: </li>
                                                            </ul>
                                                        </div>
                                                        <div class="right col-xs-5 text-center">
                                                            <img src="${contextPath}/resources/images/user.png" alt="" class="img-circle img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 bottom text-center">
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <p class="ratings">
                                                                <a>4.0</a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star"></span></a>
                                                                <a href="#"><span class="fa fa-star-o"></span></a>
                                                            </p>
                                                        </div>
                                                        <div class="col-xs-12 col-sm-6 emphasis">
                                                            <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                                                </i> <i class="fa fa-comments-o"></i> </button>
                                                            <button type="button" class="btn btn-primary btn-xs">
                                                                <i class="fa fa-user"> </i> View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /page content -->

                <!-- footer content -->
                <footer>
                    <div class="pull-right">
                        Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
                    </div>
                    <div class="clearfix"></div>
                </footer>
                <!-- /footer content -->
            </div>
        </div>

        <!-- jQuery -->
        <script src="${contextPath}/resources/vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="${contextPath}/resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="${contextPath}/resources/vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="${contextPath}/resources/vendors/nprogress/nprogress.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="${contextPath}/resources/build/js/custom.min.js"></script>
    </body>
</html>