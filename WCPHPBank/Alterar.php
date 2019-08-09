<?php require_once './Classes/Conta.php'; session_start(); ?>
<?php $result = $_SESSION['result']?>
<?php $conta = new Conta($result->nome, $result->num_ag, $result->num_conta, $result->saldo)?>
<!DOCTYPE html>
<html>
    <body>
        <h2>Bem Vindo <?php echo $conta->getNome() ?></h2>

        <form action="/WC/Session.php" method="post">
          <fieldset>
            <legend>Alterar Cadastro:</legend>
            Name:<br>
            <input type="text" name="nome">
            <br>
            Agency:<br>
            <input type="number" name="ag">
            <br>
            Account:<br>
            <input type="number" name="conta">
            <br><br>
            <input type="hidden" name="op" value="alterar">
            <input type="submit" value="Submit">
          </fieldset>
        </form>
    </body>
</html>
