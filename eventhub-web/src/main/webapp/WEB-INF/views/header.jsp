
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <a class="navbar-brand" href="#"><spring:message code="app.title"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active"><a class="nav-link" href="#"><spring:message code="app.nav.home"/> <span class="sr-only"></span></a></li>
        </ul>
    </div>
</nav>