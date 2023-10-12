
<%@ page import="step.learning.dto.models.SignupFormModel" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String regData = (String) request.getAttribute( "reg-data" ) ;
    SignupFormModel formModel = (SignupFormModel) request.getAttribute( "reg-model" ) ;
    Map<String, String> validationErrors =
            formModel == null
                    ? new HashMap<String, String>()
                    : formModel.getValidationErrorMessages() ;
    String loginClass = regData == null ? "validate" : (validationErrors.containsKey("login") ? "invalid" : "valid" );
    String emailClass = regData == null ? "validate" : (validationErrors.containsKey("email") ? "invalid" : "valid" );
    String birthdateClass = regData == null ? "validate" : (validationErrors.containsKey("birthdate") ? "invalid" : "valid" );
    String nameClass = regData == null ? "validate" : (validationErrors.containsKey("name") ? "invalid" : "valid" );
    String phoneClass = regData == null ? "validate" : (validationErrors.containsKey("phone") ? "invalid" : "valid" );
    String passwordClass = regData == null ? "validate" : (validationErrors.containsKey("password") ? "invalid" : "valid" );
    String repeatClass = regData == null ? "validate" : (validationErrors.containsKey("repeat") ? "invalid" : "valid" );
    String isAgreeClass = regData == null ? "validate" : (validationErrors.containsKey("isAgree") ? "invalid" : "valid" );
%>
<h2>User registration</h2>
<p>

</p>
<div class="row">
    <form class="col s12" method="post">
        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">person</i>
                <input name="reg-login" id="icon_prefix" type="text" class="<%=loginClass%>" value = "<%=formModel == null ? "" : formModel.getLogin()%>">
                <label for="icon_prefix">Login</label>
                <% if( validationErrors.containsKey("login") ) { %>
                <span class="helper-text" data-error="<%= validationErrors.get("login") %>"></span>
                <% } %>

            </div>
            <div class="input-field col s6">
                <i class="material-icons prefix">email</i>
                <input name="reg-email" id="icon_email" type="text" class="<%=emailClass%>" value = "<%=formModel == null ? "" : formModel.getEmail()%>">
                <label for="icon_email">Email</label>
                <% if( validationErrors.containsKey("email") ) { %>
                <span class="helper-text" data-error="<%= validationErrors.get("email") %>"></span>
                <% } %>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">child_friendly</i>
                <input name="reg-birthdate" id="icon-birthdate"  type="date" class="<%=birthdateClass%>" value = "<%=formModel == null ? "" : formModel.getBirthdate()%>">
                <label for="icon-birthdate">Birth date</label>
                <% if( validationErrors.containsKey("birthdate") ) { %>
                <span class="helper-text" data-error="<%= validationErrors.get("birthdate") %>"></span>
                <% } %>
            </div>
            <div class="input-field col s6">
                <i class="material-icons prefix">badge</i>
                <input name="reg-name" id="icon_badge" type="text" class="<%=nameClass%>" value = "<%=formModel == null ? "" : formModel.getName()%>" >
                <label for="icon_badge">Real name</label>
                <% if( validationErrors.containsKey("name") ) { %>
                <span class="helper-text" data-error="<%= validationErrors.get("name") %>"></span>
                <% } %>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">password</i>
                <input name="reg-password" id="icon_password" type="text" class="<%=passwordClass%>" value = "<%=formModel == null ? "" : formModel.getPassword()%>">
                <label for="icon_password">Password</label>
                <% if( validationErrors.containsKey("password") ) { %>
                <span class="helper-text" data-error="<%= validationErrors.get("password") %>"></span>
                <% } %>
            </div>
            <div class="input-field col s6">
                <i class="material-icons prefix">repeat</i>
                <input name="reg-repeat" id="icon_repeatPassword" type="text" class="<%=repeatClass%>" value = "<%=formModel == null ? "" : formModel.getRepeat()%>">
                <label for="icon_repeatPassword">Repeat password</label>
                <% if( validationErrors.containsKey("repeat") ) { %>
                <span class="helper-text" data-error="<%= validationErrors.get("repeat") %>"></span>
                <% } %>

            </div>
        </div>
        <div class="row">

        </div>

        <div class="row">
            <div class="input-field col s2">
                <i class="material-icons prefix">phone</i>
                <input name="reg-phone" id="icon_telephone" type="tel" class="<%=phoneClass%>" value = "<%=formModel == null ? "" : formModel.getPhone()%>">
                <label for="icon_telephone">Telephone</label>
                <% if( validationErrors.containsKey("phone") ) { %>
                <span class="helper-text" data-error="<%= validationErrors.get("phone") %>"></span>
                <% } %>
            </div>
            <div class="input-field col s2">
                <i class="material-icons prefix">fact_check</i>
                <label>
                    <input name="reg-agree" type="checkbox" class="<%=isAgreeClass%>" value = "<%=formModel == null ? "" : formModel.getAgree()%>" />
                    <span>OK</span>

                </label>
                <% if( validationErrors.containsKey("isAgree") ) { %>
                <span class="helper-text" data-error="<%= validationErrors.get("isAgree") %>"></span>
                <% } %>
            </div>

            <div class="input-field col s8 right-align">
                <button class="waves-effect waves-light btn pink">
                    <i class="material-icons right">how_to_reg</i>Register</button>
            </div>
        </div>
    </form>
</div>

