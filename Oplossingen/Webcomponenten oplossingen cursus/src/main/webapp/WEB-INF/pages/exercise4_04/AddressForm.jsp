<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Enter Address</title>
</head>
<body>
   <h1>Enter Address</h1>
   <form method="POST">
      <div>
      Firstname: <input type="text" name="firstName" /><br/>
      LastName: <input type="text" name="lastName" /><br />
      Address: <input type="text" name="street" />&nbsp;
      Number: <input type="text" name="number"  size="6"/><br />      
      Zipcode: <input type="text" name="zipCode"  size="6"/>&nbsp;
      City: <input type="text" name="city" /><br />
      Country: <input type="text" name="country" /><br />
      Phone: <input type="text" name="phone" /><br />
      Email: <input type="email" name="email" /><br />
      <input type="submit" value="Submit" />
      </div>
   </form>
</body>
</html>
