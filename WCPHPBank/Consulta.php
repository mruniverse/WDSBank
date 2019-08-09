<?php require_once './Classes/Conta.php'; session_start(); ?>
<?php $result = $_SESSION['result']?>
<?php $conta = new Conta($result->nome, $result->num_ag, $result->num_conta, $result->saldo)?>
<!DOCTYPE html>
<html>
    <body>
        <h2>Bem Vindo <?php echo $conta->getNome() ?></h2>

        <fieldset>
            <legend>Dados do cliente</legend>
            <p>Nome: <?php echo $conta->getNome() ?></p>
            <p>Agencia: <?php echo $conta->getAg() ?></p>
            <p>Conta: <?php echo $conta->getConta() ?></p>
            <p>Saldo:  R$ <?php echo $conta->getSaldo() ?></p>
        </fieldset>
        <br><br>
        <form action="/ContaIndex.php" method="post">
            <input type="submit" value="Voltar">
        </form>
    </body>
</html>
