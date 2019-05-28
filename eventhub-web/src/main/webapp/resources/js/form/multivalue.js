$(document).ready(function () {
    var inputsWrapper = $("#inputsWrapper"); //Input boxes wrapper ID
    var addButton = $("#addMoreFileBox"); //Add button ID

    var x = inputsWrapper.length; //initlal text box count
    var fieldCount = 0; //to keep track of text box added

//on add input button click
    $(addButton).click(function (e) {
//max input box allowed
        fieldCount++; //text box added increment
        //add input box
        var div = document.createElement("div");
        var input = document.createElement("input");
        input.setAttribute("type", "tel");
        input.setAttribute("class", "form-control col-md-7 col-xs-12 multivaluedInput");
        input.setAttribute("id", "systemUserPhone_" + fieldCount);
        input.setAttribute("name", "systemUserPhones[" + fieldCount + "].phoneNumber");
        var anchor = document.createElement("a");
        anchor.setAttribute("href", "#");
        anchor.setAttribute("class", "removeclass");
        anchor.innerHTML = "Remove";
        div.appendChild(input);
        div.appendChild(anchor);
        $(inputsWrapper).append(div);
        x++; //text box increment

        $("#addMoreFileId").show();
        $('addMoreFileBox').html("Add field");
        return false;
    });
    $("body").on("click", ".removeclass", function (e) { //user click on remove text
        if (x > 1) {
            $(this).parent('div').remove(); //remove text box
            x--; //decrement textbox

            $("#addMoreFileId").show();
            $("#lineBreak").html("");
            // Adds the "add" link again when a field is removed.
            $('addMoreFileBox').html("Add field");

            //resets fields names numbering
            var fieldInputArray = document.getElementsByClassName("multivaluedInput");
            for (i = 0; i <= fieldInputArray.length; i++) {
                var fieldInput = fieldInputArray[i];
                fieldInput.setAttribute("name", "systemUserPhones[" + i + "].phoneNumber");
            }
        }
        return false;
    });
});
