<?php
if (isset($_POST['id']) && $_POST['id']!="") {
	$id = $_POST['id'];
	$url = "http://localhost:8080/WDSBank/webresources/Bank/".$id;
	
	$client = curl_init($url);
	curl_setopt($client,CURLOPT_RETURNTRANSFER,true);
	$response = curl_exec($client);
	
	$result = json_decode($response);
        
	echo "<table>";
	echo "<tr><td>Order ID:</td><td>$result->nome</td></tr>";
	echo "<tr><td>Amount:</td><td>$result->num_ag</td></tr>";
	echo "<tr><td>Response Code:</td><td>$result->num_conta</td></tr>";
	echo "<tr><td>Response Desc:</td><td>$result->saldo</td></tr>";
	echo "</table>";
}
    ?>
