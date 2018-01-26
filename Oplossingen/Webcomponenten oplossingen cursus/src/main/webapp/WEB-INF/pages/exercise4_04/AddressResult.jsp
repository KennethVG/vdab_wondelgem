<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Show Address</title>
</head>
<body>
   <h1>Show Address</h1>
   We registered your address: <br/>
   Name: ${address.firstName} &nbsp; ${address.lastName}
   <br /> Street + number: ${address.street} &nbsp; ${address.number}
   <br /> Zipcode + city: ${address.zipCode} &nbsp; ${address.city}
   <br /> Country: ${address.country}
   <br /> Phone: ${address.phone}
   <br /> Email: ${address.email}
   <br />
</body>
</html>
