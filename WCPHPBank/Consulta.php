<?php $conta = $_POST['conta']?>
<?php var_dump($conta)?>
<!DOCTYPE html>
<html>
    <body>
        <h2>Bem Vindo <?php echo $conta->getNome() ?></h2>

        <fieldset>
            <legend>Dados do cliente</legend>
            <p>Nome: <?php echo $conta->getNome() ?></p>
            <br>
            <p>Agencia: <?php echo $conta->getAg() ?></p>
            <br>
            <p>Conta: <?php echo $conta->getConta() ?></p>
            <br>
            <p>Saldo:  R$ <?php echo $conta->getSaldo() ?></p>
        </fieldset>
        <br><br>
        <form action="/ContaIndex.php" method="post">
            <input type="submit" value="Voltar">
        </form>
    </body>
</html>
