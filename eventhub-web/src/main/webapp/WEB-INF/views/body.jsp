<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div role="main" class="container">
    <div class="jumbotron">

        <h1><spring:message code="app.page.header"/></h1>
        <p class="lead"><spring:message code="app.page.body"/></p>


        <div class="dropdown">
            <button class="btn btn-danger dropdown-toggle" type="button" id="dropdownMenuButton"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="app.theme.title"/></button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">

                <a class="dropdown-item" href="?theme=cerulean"><spring:message code="app.theme.cerulean"/></a> 
                <a class="dropdown-item" href="?theme=cosmo"><spring:message code="app.theme.cosmo"/></a>
                <a class="dropdown-item" href="?theme=cyborg"><spring:message code="app.theme.cyborg"/></a>
                <a class="dropdown-item" href="?theme=darkly"><spring:message code="app.theme.darkly"/></a>
                <a class="dropdown-item" href="?theme=flatly"><spring:message code="app.theme.flatly"/></a>
                <a class="dropdown-item" href="?theme=journal"><spring:message code="app.theme.journal"/></a>
                <a class="dropdown-item" href="?theme=litera"><spring:message code="app.theme.litera"/></a>
                <a class="dropdown-item" href="?theme=lumen"><spring:message code="app.theme.lumen"/></a>
                <a class="dropdown-item" href="?theme=lux"><spring:message code="app.theme.lux"/></a>
                <a class="dropdown-item" href="?theme=materia"><spring:message code="app.theme.materia"/></a>
                <a class="dropdown-item" href="?theme=minty"><spring:message code="app.theme.minty"/></a>
                <a class="dropdown-item" href="?theme=pulse"><spring:message code="app.theme.pulse"/></a>
                <a class="dropdown-item" href="?theme=sandstone"><spring:message code="app.theme.sandstone"/></a>
                <a class="dropdown-item" href="?theme=simplex"><spring:message code="app.theme.simplex"/></a>
                <a class="dropdown-item" href="?theme=sketchy"><spring:message code="app.theme.sketchy"/></a>
                <a class="dropdown-item" href="?theme=slate"><spring:message code="app.theme.slate"/></a>
                <a class="dropdown-item" href="?theme=solar"><spring:message code="app.theme.solar"/></a>
                <a class="dropdown-item" href="?theme=spacelab"><spring:message code="app.theme.spacelab"/></a>
                <a class="dropdown-item" href="?theme=superhero"><spring:message code="app.theme.superhero"/></a>
                <a class="dropdown-item" href="?theme=united"><spring:message code="app.theme.united"/></a>
                <a class="dropdown-item" href="?theme=yeti"><spring:message code="app.theme.yeti"/></a>

            </div>
        </div>
        <hr/>
        <!-- Dropdown for selecting language -->
        <div class="dropdown" style="float: <spring:message code="app.dir.test"/>;" >
            <button class="btn btn-danger dropdown-toggle" type="button" id="dropdownMenuButton"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="app.lang.title"/></button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="?lang=en"><spring:message code="app.lang.english"/></a> 
                <a class="dropdown-item" href="?lang=hi"><spring:message code="app.lang.hindi"/></a>
                <a class="dropdown-item" href="?lang=cn"><spring:message code="app.lang.chinese"/></a>
                <a class="dropdown-item" href="?lang=ar"><spring:message code="app.lang.arabic"/></a>
            </div>
        </div>

        <form:form modelAttribute="user" action="persist.htm" method="POST" enctype="multipart/form-data">		
            <fieldset>
                <legend>Legend</legend>
                <div class="form-group row">
                    <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="text" readonly="" class="form-control-plaintext" id="staticEmail" value="email@example.com">
                    </div>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <form:input type="email" path="email" class="form-control" aria-describedby="emailHelp" placeholder="Enter email"/>
                    <form:errors path="email"/>
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <form:password path="password" class="form-control" placeholder="Password"/>
                    <form:errors path="password"/>
                </div>
                <div class="form-group">
                    <label for="exampleIntegerEntry">Number Entry</label>
                    <form:input type="number" min="0" path="number" class="form-control" placeholder="Enter Number"/>
                    <form:errors path="number"/>

                </div>
                <div class="form-group">
                    <label for="exampleSelect1">Example select</label>
                    <form:select path="listSelectOne" class="form-control">
                        <form:option value="1">1</form:option>
                        <form:option value="2">2</form:option>
                        <form:option value="3">3</form:option>
                        <form:option value="4">4</form:option>
                        <form:option value="5">5</form:option>
                    </form:select>
                    <form:errors path="listSelectOne"/>

                </div>
                <div class="form-group">
                    <label for="exampleSelect2">Example multiple select</label>
                    <form:select path="listMultipleSelect" multiple="true" class="form-control">
                        <form:option value="1">1</form:option>
                        <form:option value="2">2</form:option>
                        <form:option value="3">3</form:option>
                        <form:option value="4">4</form:option>
                        <form:option value="5">5</form:option>
                    </form:select>
                    <form:errors path="listMultipleSelect"/>

                </div>
                <div class="form-group">
                    <label for="exampleTextarea">Example textarea</label>
                    <form:textarea path="textArea" class="form-control" rows="3"/>
                    <form:errors path="textArea"/>

                </div>
                <div class="form-group">
                    <label for="exampleInputFile">Attachment input</label>
                    <input type="file" name="attachment" class="form-control-file" aria-describedby="fileHelp">

                    <small id="fileHelp" class="form-text text-muted">This is some placeholder block-level help text for the above input. It's a bit lighter and easily wraps to a new line.</small>
                </div>
                <fieldset class="form-group">
                    <legend>Radio buttons</legend>
                    <div class="form-check">
                        <label class="form-check-label">
                            <form:radiobutton  path="radio" class="form-check-input" name="form:optionsRadios" value="form:option1" checked=""/>
                            Option one is this and that?be sure to include why it's great
                        </label>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <form:radiobutton  path="radio" class="form-check-input" name="form:optionsRadios" value="form:option2"/>
                            Option two can be something else and selecting it will deselect form:option one
                        </label>
                    </div>
                    <div class="form-check disabled">
                        <label class="form-check-label">
                            <form:radiobutton  class="form-check-input" path="radio" name="form:optionsRadios" value="form:option3" disabled="true"/>
                            Option three is disabled
                        </label>
                    </div>
                    <form:errors path="radio"/>
                </fieldset>
                <fieldset class="form-group">
                    <legend>Checkboxes</legend>
                    <div class="form-check">
                        <label class="form-check-label">
                            <form:checkbox class="form-check-input" path="checkbox" value="checkBox1" checked=""/>
                            Option one is this and that?be sure to include why it's great
                        </label>
                    </div>
                    <div class="form-check disabled">
                        <label class="form-check-label">
                            <form:checkbox class="form-check-input" path="checkbox" value="checkBox2" disabled="true"/>
                            Option two is disabled
                        </label>
                    </div>
                    <form:errors path="checkbox"/>
                </fieldset>

                <div class="form-group">
                    <fieldset disabled="">
                        <label class="control-label" for="disabledInput">Disabled input</label>
                        <form:input class="form-control" path="disabledInput" type="text" value="Disabled Input" placeholder="Disabled input here..." disabled="true"/>
                        <form:errors path="disabledInput"/>
                    </fieldset>
                </div>

                <div class="form-group">
                    <fieldset>
                        <label class="control-label" for="readOnlyInput">Readonly input</label>
                        <form:input class="form-control" path="readOnlyInput" type="text" value="Readonly Input" placeholder="Readonly input here?" readonly="true"/>
                        <form:errors path="readOnlyInput"/>
                    </fieldset>
                </div>

                <div class="form-group has-success">
                    <label class="form-control-label" for="inputSuccess1">Valid input</label>
                    <form:input type="text" path="validInput" value="correct value" class="form-control is-valid"/>
                    <form:errors path="validInput"/>
                    <div class="valid-feedback">Success! You've done it.</div>
                </div>

                <div class="form-group has-danger">
                    <label class="form-control-label" for="inputDanger1">Invalid input</label>
                    <form:input type="text" path="invalidInput" value="wrong value" class="form-control is-invalid"/>
                    <form:errors path="invalidInput"/>
                    <div class="invalid-feedback">Sorry, that username's taken. Try another?</div>
                </div>

                <div class="form-group">
                    <label class="col-form-label col-form-label-lg" for="inputLarge">Large input</label>
                    <form:input path="largeInput" class="form-control form-control-lg" type="text" placeholder=".form-control-lg"/>
                    <form:errors path="largeInput"/>
                </div>

                <div class="form-group">
                    <label class="col-form-label col-form-label-sm" for="inputSmall">Small input</label>
                    <form:input path="smallInput" class="form-control form-control-sm" type="text" placeholder=".form-control-sm"/>
                    <form:errors path="smallInput"/>
                </div>

                <div class="custom-control custom-switch">
                    <form:checkbox path="isSelected" class="custom-control-input" checked="false"/>
                    <label class="custom-control-label" for="customSwitch1">Toggle this switch element</label>
                    <form:errors path="isSelected"/>
                </div>
                <div class="form-group">
                    <form:select path="customSelect" class="custom-select">
                        <form:option value="0" selected="">Open this select menu</form:option>
                        <form:option value="1">One</form:option>
                        <form:option value="2">Two</form:option>
                        <form:option value="3">Three</form:option>
                    </form:select>
                    <form:errors path="customSelect"/>
                </div>
                <div class="form-group">
                    <div class="input-group mb-3">
                        <div class="custom-file">
                            <input type="file" name="customFile" class="custom-file-input"/>
                            <label class="custom-file-label" for="inputGroupFile02">Choose file</label>
                        </div>
                        <div class="input-group-append">
                            <span class="input-group-text" id="">Upload</span>
                        </div>
                    </div>
                </div>

                <label for="startE">Event Start date:</label>

                <form:input path="event_startDate" type="date" id="event_start_date" name="event-start"/>

                <label for="endE">Event End date:</label>

                <form:input path="event_endDate" type="date" id="event_end_date" name="event-end"/>

                <br/>
                <label for="startS">Session Start date:</label>

                <form:input path="session_startDate" type="datetime-local" id="session_start_date" name="session-start"/>

                <label for="endS">Session End date:</label>

                <form:input path="session_endDate" type="datetime-local" id="session_end_date" name="event-end"/>


                <input type="submit" class="btn btn-primary">Submit</button>
            </fieldset>
        </form:form>




    </div>
</div>