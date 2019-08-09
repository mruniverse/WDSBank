<?php Class Conta{
    private $nome;
    private $ag;
    private $conta;
    private $saldo;
    
    function __construct($nome, $ag, $conta, $saldo){
        $this->nome = $nome;
        $this->ag = $ag;
        $this->conta = $conta;
        $this->saldo = $saldo;
    }

    function getSaldo() {
        return $this->saldo;
    }

    function setSaldo($saldo) {
        $this->saldo = $saldo;
    }

        function getNome() {
        return $this->nome;
    }

    function getAg() {
        return $this->ag;
    }

    function getConta() {
        return $this->conta;
    }

    function setNome($nome) {
        $this->nome = $nome;
    }

    function setAg($ag) {
        $this->ag = $ag;
    }

    function setConta($conta) {
        $this->conta = $conta;
    }    
}?>
