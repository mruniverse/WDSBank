<?php
require_once('../Classes/Conta.php');
require_once('Client.php');
session_start();

$client = new Client("http://localhost:8080/WDSBank/webresources/Bank/", "8080");

if($_POST['op'] == "logar" && $client->cadastroExistente($_POST['ag'], $_POST['conta']) == "true"){
    consultaDados($client, $_POST['ag'], $_POST['conta']);

    
} else if($_SESSION['result']){
    $result = $_SESSION['result'];
    
    switch($_POST['op']){
        case "transferir":
            $client->transferir($result->num_ag, $result->num_conta, $_POST['ag'], $_POST['conta'], $_POST['valor']);
            consultaDados($client, $result->num_ag, $result->num_conta);
            break;
        case "sacar":
            $client->sacar($result->num_ag, $result->num_conta, $_POST['valor']);
            consultaDados($client, $result->num_ag, $result->num_conta);
            break;
        case "depositar":
            $client->depositar($result->num_ag, $result->num_conta, $_POST['valor']);
            consultaDados($client, $result->num_ag, $result->num_conta);
            break;
        case "alterar":
            $conta = new Conta($_POST['nome'], $_POST['ag'], $_POST['conta'], 0);
            var_dump($conta);
            $client->alterar($conta);
            consultaDados($client, $_POST['ag'], $_POST['conta']);
            break;
        default :
            break;
    }

    
} else{
    echo "ERRO AO LOGAR!";
}


function consultaDados($client, $ag, $conta){
    //    Consulta Dados para exibicao
        $result = $client->consultar($ag, $conta);
        $conta = new Conta($result->nome, $result->num_ag, $result->num_conta, $result->saldo);
        $_SESSION['result'] = $result;
        header("Location: ../ContaIndex.php");
}

?>