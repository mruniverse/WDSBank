<?php $conta = $_POST['conta']?>
<!DOCTYPE html>
<html>
    <body>
        <h2>Bem Vindo <?php echo $conta->getNome() ?></h2>

        <fieldset>
            <legend>Saldo: R$ <?php echo $conta->getSaldo() ?></legend>

            <form action="/Consulta.php" method="post">
                <input type="hidden" value="<?php $conta?>" name="conta">
                <input type="submit" value="Consultar Dados">
            </form>
            <br>
            <form action="/WC/Session.php" method="post">
                <input type="submit" value="Alterar Conta">
            </form>
            <br>
            <form action="/WC/Session.php" method="post">
                <input type="submit" value="Depositar">
            </form>
            <br>
            <form action="/WC/Session.php" method="post">
                <input type="submit" value="Sacar">
            </form>
            <br>
            <form action="/WC/Session.php" method="post">
                <input type="submit" value="Transferir">
            </form>
        </fieldset>
        <br><br>
        <form action="/index.html" method="post">
            <input type="submit" value="Exit">
        </form>
    </body>
</html>
