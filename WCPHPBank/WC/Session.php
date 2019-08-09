<?php
require_once('../Classes/Conta.php');
require_once('Client.php');

$client = new Client("http://localhost:8080/WDSBank/webresources/Bank/", "8080");

if($client->cadastroExistente($_POST['ag'], $_POST['conta']) == "true"){
    $result = $client->consultar($_POST['ag'], $_POST['conta']);
    $conta = new Conta($result->nome, $result->num_ag, $result->num_conta, $result->saldo);
    
    $_POST['conta'] = $conta;
    
    require '../ContaIndex.php';
}

//	echo "<table>";
//	echo "<tr><td><h1>Bem vindo </td><td><h1>$result->nome<h1></td></tr>";
//	echo "</table>";





?>