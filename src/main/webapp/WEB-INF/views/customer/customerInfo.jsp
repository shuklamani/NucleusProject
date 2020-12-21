<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script>
        var subjectObject = {
          "India": {
            "India state 1": ["india state 1 city 1", "india state 1 city 2", "india state 1 city 4"],
            "India state 2": ["india state 2 city 1", "india state 2 city 2"],
            "India state 3": ["india state 3 city 1", "india state 3 city 2"]
          },
          "Australia": {
            "australia state 1": ["australia state 1 city 1", "australia state 1 city 2"],
            "australia state 2": ["australia state 2 city 1", "australia state 2 city 2"]
          }
        }
        window.onload = function() {
          var subjectSel = document.getElementById("country1");
          var topicSel = document.getElementById("state1");
          var chapterSel = document.getElementById("city1");
          for (var x in subjectObject) {
            subjectSel.options[subjectSel.options.length] = new Option(x, x);
          }
          subjectSel.onchange = function() {
            //display correct values
            for (var y in subjectObject[this.value]) {
              topicSel.options[topicSel.options.length] = new Option(y, y);
            }
          }
          topicSel.onchange = function() {
            //display correct values
            var z = subjectObject[subjectSel.value][this.value];
            for (var i = 0; i < z.length; i++) {
              chapterSel.options[chapterSel.options.length] = new Option(z[i], z[i]);
            }
          }
        }
    </script>
   <title>Customer Information</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>

<body class="container-fluid">

     <jsp:include page="/navbar.jsp" />
    <article>
        <form class="font-weight-bold mb-5" action="customer.do">
            <section>
                <div class="row">
                    <a class="col-lg-2 col-md-2 col-6">Customer Information</a>
                    <a href="#" class="col-lg-2 col-md-2 col-6">Loan Information</a>

                </div>
            </section>

            <hr>
            <!--Personal Information-->
            <section>
                <div>
                    <h2 class="mb-lg-3">Personal Information</h2>

                    <div class="row ">
                        <div class="form-group col-lg-4 col-md-6 col-12 col-xl-4 ">
                            <label for="gender">Gender<a class="text-danger">*</a></label>
                            <select class="form-control" id="gender" name="gender" placeholder = "Select One Opion">
                                <option value="M">Male</option>
                                <option value="F">Female</option>

                            </select>
                        </div>

                        <div class="form-group col-lg-6 col-md-6 col-12 col-xl-4 ml-xl-5 pl-5">
                            <label for="fName">First Name<a class="text-danger">*</a></label>
                            <input type="text" class="form-control" id="fName" name="fName" minlength="3" required>
                        </div>
                    </div>

                    <div class="row ">
                        <div class="form-group col-lg-4 col-md-6 col-12 col-xl-4 ">
                            <label for="lName">Last Name<a class="text-danger">*</a></label>
                            <input type="text" class="form-control" id="lName" name="lName" minlength="3" required>
                        </div>

                        <div class="form-group col-lg-6 col-md-6 col-12 col-xl-4 ml-xl-5 pl-5">
                            <label for="name">Full Name<a class="text-danger">*</a></label>
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div>
                    </div>

                    <div class="row ">
                        <div class="form-group col-lg-4 col-md-6 col-12 col-xl-4 ">
                            <label for="country">Nationality</label>
                            <select class="form-control" id="country" name="nationality">
                                <option value="india">India</option>
                                <option value="india">China</option>

                            </select>
                        </div>

                        <div class="form-group col-lg-6 col-md-6 col-12 col-xl-4 ml-xl-5 pl-5">
                            <label for="dob">Date of Birth<a class="text-danger">*</a></label>
                            <input class="form-control" type="date" name="dob" placeholder="dd-mm-yyyy" value="" min="1920-01-01" max="2130-12-31">
                        </div>
                    </div>
                </div>
            </section>
            <hr>

            <!--Employement Details-->
            <section>
                <h2 class="mb-lg-3">Employement Details</h2>
                <div class="row ">
                    <div class="form-group col-lg-4 col-md-6 col-12 col-xl-4 ">
                        <label for="occupation">Occupation Type<a class="text-danger">*</a></label>
                        <select class="form-control" id="occupation" name="occupation" required>
                            <option>Select One Option</option>
                            <option value="selfEmployed">Self Employed</option>
                            <option value="service">Serivce</option>

                        </select>
                    </div>

                    <div class="form-group col-lg-6 col-md-6 col-12 col-xl-4 ml-xl-5 pl-5">
                        <label for="experiece">Total Work Experience</label>
                        <input type="number" class="form-control" id="experience" name="experience" min="0">
                    </div>
                </div>

                <div class="row ">
                    <div class="form-group col-lg-4 col-md-6 col-12 col-xl-4 ">
                        <label for="occupationName">Occupation Name</label>
                        <input type="text" class="form-control" id="occupationName" name="occupationName">
                    </div>
                </div>


            </section>
            <hr>
            <!--Address Details-->
            <section>
                <h2 class="mb-lg-3">Address Details</h2>
                <div class="row ">
                    <div class="form-group col-lg-4 col-md-6 col-12 col-xl-4 ">
                        <label for="houseNo">House No</label>
                        <input type="number" class="form-control" id="houseNo" name="houseNo">

                    </div>

                    <div class="form-group col-lg-6 col-md-6 col-12 col-xl-4 ml-xl-5 pl-5">
                        <label for="country">Country</label>
                        <select class="form-control" id="country1" name="country">
                            <option>Select One Option</option>


                        </select>
                    </div>
                </div>

                <div class="row ">
                    <div class="form-group col-lg-4 col-md-6 col-12 col-xl-4 ">
                        <label for="state">State</label>
                        <select class="form-control" id="state1" name="state">
                            <option>Select One Option</option>

                        </select>
                    </div>
                    <div class="form-group col-lg-6 col-md-6 col-12 col-xl-4 ml-xl-5 pl-5">
                        <label for="city">City</label>
                        <select class="form-control" id="city1" name="city">
                            <option>Select One Option</option>

                        </select>
                    </div>
                </div>

                <div class="row ">
                   <div class="form-group col-lg-4 col-md-6 col-12 col-xl-4 ">
                        <label for="pinCode">Pin Code</label>
                        <input type="number" class="form-control" id="pinCode" name="pinCode">
                    </div>
                </div>


            </section>
            <hr>
            <div class="text-center">
                <input class="btn-primary mr-3" type="submit" value="save" name="submit">
                <input class="btn-primary" type="submit" value="next" name="submit">
            </div>
        </form>
    </article>
</body>
${cust}
${add}

</html>