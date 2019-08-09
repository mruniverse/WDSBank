<?php require_once './Classes/Conta.php'; session_start(); ?>
<?php $result = $_SESSION['result']?>
<?php $conta = new Conta($result->nome, $result->num_ag, $result->num_conta, $result->saldo)?>
<!DOCTYPE html>
<html>
    <body>
        <h2>Bem Vindo <?php echo $conta->getNome() ?></h2>

        <fieldset>
            <legend>Saldo: R$ <?php echo $conta->getSaldo() ?></legend>

            <form action="/Consulta.php" method="post">
                <input type="submit" value="Consultar Dados">
            </form>
            <br>
            <form action="/Alterar.php" method="post">
                <input type="submit" value="Alterar Conta">
            </form>
            <br>
            <form action="/Deposito.php" method="post">
                <input type="submit" value="Depositar">
            </form>
            <br>
            <form action="/Saque.php" method="post">
                <input type="submit" value="Sacar">
            </form>
            <br>
            <form action="/Transferencia.php" method="post">
                <input type="submit" value="Transferir">
            </form>
        </fieldset>
        <br><br>
        <form action="/index.html" method="post">
            <input type="submit" value="Exit">
        </form>
    </body>
</html>
