<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eraky
  Date: 5/26/2019
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- page content -->
<div class="right_col" role="main">
    <div class="">
        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">

                    <div class="x_title">
                        <h2>Form Design <small>different form elements</small></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <br />

                        <!--SignUp Form-->
                        <form:form id="demo-form2" class="form-horizontal form-label-left" modelAttribute="systemUser">


                            <!--First Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">
                                    First Name <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="firstName" type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--Last Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Last Name <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="lastName" type="text" id="last-name" name="last-name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--email-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Email <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="email" type="email" id="email" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--PassWord-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Password <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:password path="password"  id="password" name="Password" required="required" class="form-control col-md-7 col-xs-12"></form:password>
                                </div>
                            </div>

                            <!--Confirm Password-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Confirm Password <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:password path="" id="confirmPassword" name="confirmPassword" required="required" class="form-control col-md-7 col-xs-12"></form:password>
                                </div>
                            </div>

                            <!--Gender-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Gender</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <div id="gender" class="btn-group" data-toggle="buttons">
                                        <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                            <form:radiobutton path="gender" name="gender" value="Male"></form:radiobutton> &nbsp; Male &nbsp;
                                        </label>
                                        <label class="btn btn-primary" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                            <form:radiobutton  path="gender"  name="gender" value="Female"></form:radiobutton> Female
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <!--Date Of Birth-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Date Of Birth <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="dateOfBirth" type="date" id="birthday" class="date-picker form-control col-md-7 col-xs-12" required="required" ></form:input>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Country</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="country" type="text" name="country" id="autocomplete-custom-append" class="form-control col-md-10"/>
                                </div>
                            </div>

                            <div id="inputsWrapper" class="form-group">
                                <div>
                                    <c:forEach items="${user.systemUserPhones}" varStatus="systemUserPhone">
                                        <form:input type="tel"
                                                    class="form-control col-md-7 col-xs-12 multivaluedInput"
                                                    path="systemUserPhones[${systemUserPhone.index}].phoneNumber"
                                                    id="systemUserPhone_${systemUserPhone.index}" value=""/>
                                        <a href="#" class="removeclass">
                                        </a>
                                        <form:errors path="systemUserPhones[${systemUserPhone.index}].phoneNumber"/>
                                    </c:forEach>
                                </div>
                            </div>
                            <div id="addMoreFileId">
                                <a href="#" id="addMoreFileBox" class="btn btn-info">Add field</a><br><br>
                            </div>
                            <div id="lineBreak"></div>

                            <!--Dummy Data-->


                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Default Input</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="" type="text" class="form-control" placeholder="Default Input"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Disabled Input </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="" type="text" class="form-control" disabled="disabled" placeholder="Disabled Input"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Read-Only Input</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" class="form-control" readonly="readonly" placeholder="Read-Only Input">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Text Area Input <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:textarea  path="" class="form-control" rows="3" placeholder="Text Area Input "></form:textarea>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Password</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:password  path="" class="form-control" value="passwordonetwo"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">AutoComplete</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="" type="text" name="country" id="autocomplete-custom-append" class="form-control col-md-10"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Select</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:select  path="" class="form-control">
                                        <form:option value="Spring Option"/>
                                        <option>Choose option</option>
                                        <option>Option one</option>
                                        <option>Option two</option>
                                        <option>Option three</option>
                                        <option>Option four</option>
                                    </form:select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Select Grouped</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:select path=""  class="select2_group form-control">
                                        <optgroup label="Alaskan/Hawaiian Time Zone">
                                            <form:option value="AK">Alaska</form:option>
                                            <form:option value="HI">Hawaii</form:option>
                                        </optgroup>
                                        <optgroup label="Pacific Time Zone">
                                            <option value="CA">California</option>
                                            <option value="NV">Nevada</option>
                                            <option value="OR">Oregon</option>
                                            <option value="WA">Washington</option>
                                        </optgroup>
                                        <optgroup label="Mountain Time Zone">
                                            <option value="AZ">Arizona</option>
                                            <option value="CO">Colorado</option>
                                            <option value="ID">Idaho</option>
                                            <option value="MT">Montana</option>
                                            <option value="NE">Nebraska</option>
                                            <option value="NM">New Mexico</option>
                                            <option value="ND">North Dakota</option>
                                            <option value="UT">Utah</option>
                                            <option value="WY">Wyoming</option>
                                        </optgroup>
                                        <optgroup label="Central Time Zone">
                                            <option value="AL">Alabama</option>
                                            <option value="AR">Arkansas</option>
                                            <option value="IL">Illinois</option>
                                            <option value="IA">Iowa</option>
                                            <option value="KS">Kansas</option>
                                            <option value="KY">Kentucky</option>
                                            <option value="LA">Louisiana</option>
                                            <option value="MN">Minnesota</option>
                                            <option value="MS">Mississippi</option>
                                            <option value="MO">Missouri</option>
                                            <option value="OK">Oklahoma</option>
                                            <option value="SD">South Dakota</option>
                                            <option value="TX">Texas</option>
                                            <option value="TN">Tennessee</option>
                                            <option value="WI">Wisconsin</option>
                                        </optgroup>
                                        <optgroup label="Eastern Time Zone">
                                            <option value="CT">Connecticut</option>
                                            <option value="DE">Delaware</option>
                                            <option value="FL">Florida</option>
                                            <option value="GA">Georgia</option>
                                            <option value="IN">Indiana</option>
                                            <option value="ME">Maine</option>
                                            <option value="MD">Maryland</option>
                                            <option value="MA">Massachusetts</option>
                                            <option value="MI">Michigan</option>
                                            <option value="NH">New Hampshire</option>
                                            <option value="NJ">New Jersey</option>
                                            <option value="NY">New York</option>
                                            <option value="NC">North Carolina</option>
                                            <option value="OH">Ohio</option>
                                            <option value="PA">Pennsylvania</option>
                                            <option value="RI">Rhode Island</option>
                                            <option value="SC">South Carolina</option>
                                            <option value="VT">Vermont</option>
                                            <option value="VA">Virginia</option>
                                            <option value="WV">West Virginia</option>
                                        </optgroup>
                                    </form:select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Select Multiple</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:select path="" class="select2_multiple form-control" multiple="multiple">
                                        <option>Choose option</option>
                                        <option>Option one</option>
                                        <option>Option two</option>
                                        <option>Option three</option>
                                        <option>Option four</option>
                                        <option>Option five</option>
                                        <option>Option six</option>
                                    </form:select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Tag Input</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="" id="tags_1" type="text" class="tags form-control" value="social, adverts, sales" />
                                    <div id="suggestions-container" style="position: relative; float: left; width: 250px; margin: 10px;"></div>
                                </div>
                            </div>








                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Check Box</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">

                                    <div class="checkbox">
                                        <label>
                                            <form:checkbox path="" class="flat" value="test" checked="false" label="UnChecked" />
                                        </label>
                                    </div>


                                    <div class="checkbox">
                                        <label>
                                            <form:checkbox path="" class="flat" value="test" checked="true" label="Checked"/>
                                        </label>
                                    </div>


                                </div>
                            </div>


                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Check Box</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">

                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path=""  class="flat" value="test"  label="UnChecked" />
                                        </label>
                                    </div>


                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="" checked="true" class="flat" value="test" label="Checked"/>
                                        </label>
                                    </div>


                                </div>
                            </div>


                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Switch</label>
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <div class="">
                                        <label>
                                            <form:checkbox value="true" path=""  class="js-switch" checked="true" /> Checked
                                        </label>
                                    </div>

                                    <div class="">
                                        <label>
                                            <form:checkbox  value="false" path=""  class="js-switch" /> Unchecked
                                        </label>
                                    </div>

                                </div>
                            </div>


















                            <div class="ln_solid"></div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <button class="btn btn-primary" type="button">Cancel</button>
                                    <button class="btn btn-primary" type="reset">Reset</button>
                                    <button type="submit" class="btn btn-success">Submit</button>
                                </div>
                            </div>






                        </form:form>
                        <!--SignUp Of Login Form-->
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>