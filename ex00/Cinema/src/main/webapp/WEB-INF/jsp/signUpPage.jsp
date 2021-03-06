<!DOCTYPE html>
<html>

<head>
    <title>FWA | SIGN UP</title>
</head>

<style>
    body {font-family: Arial, Helvetica, sans-serif;}
    * {box-sizing: border-box}

    /* Full-width input fields */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }

    input[type=text]:focus, input[type=password]:focus {
        background-color: #ddd;
        outline: none;
    }

    hr {
        border: 1px solid #f1f1f1;
        margin-bottom: 25px;
    }

    /* Set a style for all buttons */
    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }

    button:hover {
        opacity:1;
    }

    /* Extra styles for the cancel button */
    .cancelbtn {
        padding: 14px 20px;
        background-color: #f44336;
        text-decoration:none;
        color: #f1f1f1;
    }

    /* Float cancel and signup buttons and add an equal width */
    .cancelbtn, .signupbtn {
        float: left;
        width: 50%;
    }

    /* Add padding to container elements */
    .container {
        padding: 16px;
    }

    /* Clear floats */
    .clearfix::after {
        content: "";
        clear: both;
        display: table;
    }

    /* Change styles for cancel button and signup button on extra small screens */
    @media screen and (max-width: 300px) {
        .cancelbtn, .signupbtn {
            width: 100%;
        }
    }
</style>
<body>

<form method="post" action="/signUp" style="border:1px solid #ccc">
    <div class="container">
        <h1>Sign Up</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <input type="text" placeholder="Enter Your First Name" name="first_name" required>

        <input type="text" placeholder="Enter Your Last Name" name="last_name" required>

        <input type="text" placeholder="Enter Your Email" name="email" required>

        <input type="text" placeholder="Enter Phone Number" name="phone_number" required>

        <input type="password" placeholder="Enter Password" name="password" required>

        <div class="clearfix">
            <div class="w3-padding" align="center" style="width: auto">
                <button type="submit" class="signupbtn" style="width: 100%">Sign Up</button>
            </div>
        </div>
    </div>
</form>

</body>
</html>