<?php Class Client{
     private $url;
     private $port;
             
     function __construct($url, $port) {
         $this->url = $url;
         $this->port = $port;
     }
     
     function getUrl() {
         return $this->url;
     }

     function getPort() {
         return $this->port;
     }

     function setUrl($url) {
         $this->url = $url;
     }

     function setPort($port) {
         $this->port = $port;
     }
//        ======================================================================
    function cadastrar(Conta $c){
        $nome = $c->getNome();
        $ag = $c->getAg();
        $conta = $c->getConta();
        
        $curl = curl_init();
        curl_setopt_array($curl, array(
            CURLOPT_PORT => $this->port,
            CURLOPT_URL => $this->url,
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
              "x-api-key: whateveriyouneedinyourheader"
            ),
        ));
        
        $response = curl_exec($curl);
        $err = curl_error($curl);
        curl_close($curl);

        if ($err){
            echo "cURL Error #:" . $err;
        }
        else{
             return $response;
        }        
    }
//        ======================================================================
    function consultar($ag, $conta){
        $url = $this->url . $ag . $conta;
        
        $curl = curl_init();
        curl_setopt_array($curl, array(
          CURLOPT_PORT => $this->port,
          CURLOPT_URL => $url,
          CURLOPT_RETURNTRANSFER => true,
          CURLOPT_ENCODING => "",
          CURLOPT_MAXREDIRS => 10,
          CURLOPT_TIMEOUT => 30,
          CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
          CURLOPT_CUSTOMREQUEST => "GET",
          CURLOPT_HTTPHEADER => array(
            "Accept: */*",
            "Accept-Encoding: gzip, deflate",
            "Cache-Control: no-cache",
            "Connection: keep-alive",
            "Host: localhost:8080",
            "Postman-Token: 8fd0ae91-20ab-4f41-9448-7baf82909af5,ab620b24-252d-4edf-aa1a-451a3e5984aa",
            "User-Agent: PostmanRuntime/7.15.2",
            "cache-control: no-cache"
          ),
        ));

        $response = curl_exec($curl);
        $err = curl_error($curl);

        curl_close($curl);

        if ($err) {
          echo "cURL Error #:" . $err;
        } else {
          return json_decode($response);
        }
    }
//        ======================================================================
    function cadastroExistente($ag, $conta){
        $url = $this->url . "CadastroExistente/$ag/$conta";
        
        $curl = curl_init();
        curl_setopt_array($curl, array(
          CURLOPT_PORT => $this->port,
          CURLOPT_URL => $url,
          CURLOPT_RETURNTRANSFER => true,
          CURLOPT_ENCODING => "",
          CURLOPT_MAXREDIRS => 10,
          CURLOPT_TIMEOUT => 30,
          CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
          CURLOPT_CUSTOMREQUEST => "GET",
          CURLOPT_HTTPHEADER => array(
            "Accept: */*",
            "Accept-Encoding: gzip, deflate",
            "Cache-Control: no-cache",
            "Connection: keep-alive",
            "Host: localhost:8080",
            "Postman-Token: 32c56631-e7ed-4646-8bea-81a63c71f553,60101778-85a3-40be-9a49-fbb6026cf2f3",
            "User-Agent: PostmanRuntime/7.15.2",
            "cache-control: no-cache"
          ),
        ));

        $response = curl_exec($curl);
        $err = curl_error($curl);

        curl_close($curl);

        if ($err) {
          echo "cURL Error #:" . $err;
        } else {
          return $response;
        }
    }
//        ======================================================================
    function alterar(Conta $c){
        $nome = $c->getNome();
        $ag = $c->getAg();
        $conta = $c->getConta();
        
        $curl = curl_init();
        curl_setopt_array($curl, array(
            CURLOPT_PORT => $this->port,
            CURLOPT_URL => $this->url,
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_ENCODING => "",
            CURLOPT_MAXREDIRS => 10,
            CURLOPT_TIMEOUT => 30,
            CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
            CURLOPT_CUSTOMREQUEST => "POST",
            CURLOPT_POSTFIELDS =>
              "{\"nome\" : \"$nome\","
              . "\"num_ag\" : $ag,"
              . "\"num_conta\" : $conta}",
            CURLOPT_HTTPHEADER => array(
              "cache-control: no-cache",
              "content-type: application/json",
              "x-api-key: whateveriyouneedinyourheader"
            ),
        ));
        
        $response = curl_exec($curl);
        $err = curl_error($curl);
        curl_close($curl);

        if ($err){
            echo "cURL Error #:" . $err;
        }
        else{
             return $response;
        }        
    }
//        ======================================================================
    function depositar($ag, $conta, $valor){
        $url = $this->url . "deposito/$ag/$conta/$valor";
        
        $curl = curl_init();
        curl_setopt_array($curl, array(
          CURLOPT_PORT => $this->port,
          CURLOPT_URL => $url,
          CURLOPT_RETURNTRANSFER => true,
          CURLOPT_ENCODING => "",
          CURLOPT_MAXREDIRS => 10,
          CURLOPT_TIMEOUT => 30,
          CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
          CURLOPT_CUSTOMREQUEST => "POST",
          CURLOPT_HTTPHEADER => array(
            "Accept: */*",
            "Accept-Encoding: gzip, deflate",
            "Cache-Control: no-cache",
            "Connection: keep-alive",
            "Content-Length: ",
            "Host: localhost:8080",
            "Postman-Token: beb88b66-df2b-4c7b-a160-fe40af031871,5e36fde8-41a9-45d1-8a19-4b1334c3c27f",
            "User-Agent: PostmanRuntime/7.15.2",
            "cache-control: no-cache"
          ),
        ));

        $response = curl_exec($curl);
        $err = curl_error($curl);

        curl_close($curl);

        if ($err) {
          echo "cURL Error #:" . $err;
        } else {
          return $response;
        }
    }
//        ======================================================================
    function sacar($ag, $conta, $valor){
        $url = $this->url . "saque/$ag/$conta/$valor";
        
        $curl = curl_init();
        curl_setopt_array($curl, array(
          CURLOPT_PORT => $this->port,
          CURLOPT_URL => $url,
          CURLOPT_RETURNTRANSFER => true,
          CURLOPT_ENCODING => "",
          CURLOPT_MAXREDIRS => 10,
          CURLOPT_TIMEOUT => 30,
          CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
          CURLOPT_CUSTOMREQUEST => "POST",
          CURLOPT_HTTPHEADER => array(
            "Accept: */*",
            "Accept-Encoding: gzip, deflate",
            "Cache-Control: no-cache",
            "Connection: keep-alive",
            "Content-Length: ",
            "Host: localhost:8080",
            "Postman-Token: beb88b66-df2b-4c7b-a160-fe40af031871,5e36fde8-41a9-45d1-8a19-4b1334c3c27f",
            "User-Agent: PostmanRuntime/7.15.2",
            "cache-control: no-cache"
          ),
        ));

        $response = curl_exec($curl);
        $err = curl_error($curl);

        curl_close($curl);

        if ($err) {
          echo "cURL Error #:" . $err;
        } else {
          return $response;
        }
    }
    
    function transferir($ag1, $conta1, $ag2, $conta2, $valor){
        $url = $this->url . "transferencia/$ag1/$conta1/$ag2/$conta2/$valor";
        
        $curl = curl_init();
        curl_setopt_array($curl, array(
          CURLOPT_PORT => $this->port,
          CURLOPT_URL => $url,
          CURLOPT_RETURNTRANSFER => true,
          CURLOPT_ENCODING => "",
          CURLOPT_MAXREDIRS => 10,
          CURLOPT_TIMEOUT => 30,
          CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
          CURLOPT_CUSTOMREQUEST => "POST",
          CURLOPT_HTTPHEADER => array(
            "Accept: */*",
            "Accept-Encoding: gzip, deflate",
            "Cache-Control: no-cache",
            "Connection: keep-alive",
            "Content-Length: ",
            "Host: localhost:8080",
            "Postman-Token: 0b162388-8f89-4db9-aa24-a306b6e258ed,53df0e10-6c5f-4bf4-9144-d4bbc5712b99",
            "User-Agent: PostmanRuntime/7.15.2",
            "cache-control: no-cache"
          ),
        ));

        $response = curl_exec($curl);
        $err = curl_error($curl);

        curl_close($curl);

        if ($err) {
          echo "cURL Error #:" . $err;
        } else {
          return $response;
        }
        
    }
}

