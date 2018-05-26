/**
 * 
 */

 function loginlogout(){

    var login = false;

    var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var jsn = JSON.parse(this.responseText);

                login = jsn.session[0].state;
                
                if(login == "true"){
                    document.getElementById("navbar").innerHTML +=
                    "<li class=\"navlink2\"><a href=\"http://localhost:8080/NerdAirways/logout\">Logout</a></li>" +
                    "<li class=\"navlink2\"><a href=\"account.html\">Mein Konto</a></li>";
                }
                
                if(login == "false"){
                    document.getElementById("navbar").innerHTML +=
                    "<form action=\"http://localhost:8080/NerdAirways/login\" method=\"post\">" +
                    "<li class=\"navlink2\"><input class=\"rightinput inputs\" type=\"password\" name=\"pw\" placeholder=\"Passwort...\"> </li>" +
                    "<li class=\"navlink2\"><input class=\"rightinput inputs\" type=\"text\" name=\"username\" placeholder=\"Benutzername...\"> </li>" +
                    "<li class=\"navlink2\"><input type=\"submit\" name=\"Login\" value=\"Login\"></li>" + 
                    "<li class=\"navlink2\"><a href=\"signup.html\">Registrieren</a></li>" +
                    "</form>";
                }
            }
        }
        xhttp.open("GET", "http://localhost:8080/NerdAirways/sessionstate", true);
        xhttp.send();
    
   
 }