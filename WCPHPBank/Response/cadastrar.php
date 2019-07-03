<?php
if (isset($_POST['nome'], $_POST['ag'], $_POST['conta'])){
    $nome = $_POST['nome'];
    $ag = $_POST['ag'];
    $conta = $_POST['conta'];
        
    $curl = curl_init();
    curl_setopt_array($curl, array(
      CURLOPT_PORT => "8080",
      CURLOPT_URL => "http://localhost:8080/WDSBank/webresources/Bank/",
      CURLOPT_RETURNTRANSFER => true,
      CURLOPT_ENCODING => "",
      CURLOPT_MAXREDIRS => 10,
      CURLOPT_TIMEOUT => 30,
      CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
      CURLOPT_CUSTOMREQUEST => "PUT",
      CURLOPT_POSTFIELDS => 
        "{\"nome\" : \"$nome\","
        . "\"num_ag\" : $ag,"
        . "\"num_conta\" : $conta}",
      CURLOPT_HTTPHEADER => array(
        "cache-control: no-cache",
        "content-type: application/json",
        "x-api-key: whateveriyouneedinyourheader"),
    ));

    $response = curl_exec($curl);
    $err = curl_error($curl);

    curl_close($curl);

    if ($err){
      echo "cURL Error #:" . $err;
    } 
    else{
      echo $response;
    }        
}
?>