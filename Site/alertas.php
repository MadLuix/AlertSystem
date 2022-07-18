
<html>
<head>
<title>Alertas</title>
<meta charset="utf-8">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<style>
    body{color: #000000; background-color: #adadad; font-family: arial; text-align: left;}
    .w3-sidebar{
        background-color: #476cd0;
        color: #ffffff;
    }
    h2{
        color: #fff;
    }
    .conteudo{
        margin-left: 12%;
        margin-top: 2%;
        
    }
    table, th, td{
        border: 2px solid #000000;
        border-collapse: collapse;
        padding: 3px;
        
    }
    tr:nth-child(even) {background-color: #ffffff;}
    tr:nth-child(odd) {background-color: #9fa8aa;}
    tr:first-child{background-color: #648eff;}
    .header {
        padding: 10px;
        text-align: center;
        background: #212222;
        color: white;
        font-size: 30px;
}
</style>
<?php
    $host = "localhost";
    $db = "bd_unicsul";
    $user = "user1324";
    $pass = "6FIGpeVA(cHB@!m(";
    $con = mysqli_connect($host, $user, $pass, $db);
    if (mysqli_connect_errno()){
        echo "Não foi possível a conexão com o BD: ". mysqli_connect_error();
    }
    $resultado = mysqli_query($con, "SELECT * FROM alertas");
    ?>
<body>
    <div class="w3-sidebar  w3-bar-block" style="width:10%">
    <h3 class="w3-bar-item" style="border-bottom: solid 2px #ffffff;">Opções</h3>
    <a href="index.html" class="w3-bar-item w3-button">Menu principal</a>
    <a href="alertas.php" class="w3-bar-item w3-button">Alertas</a>
    <a href="#" class="w3-bar-item w3-button">Configurações</a>
    <a href="#" class="w3-bar-item w3-button">Sair</a>
</div>

    
    <div class="header">
  <h1>Alertas</h1>

</div>
    <div class="conteudo">
        <table>
            <tr>
                <td>ID</td>
                <td>Data</td>
                <td>Cidade</td>
                <td>Tipo</td>
                <td>Bloco</td>
                <td>Andar</td>
                <td>Local</td>
                <td>CPF</td> 
                <td>Mensagem</td>            
            </tr>
            <?php while($dado = mysqli_fetch_array($resultado))
                {
            echo "<tr>";
            echo "<td>" . $dado['id_alerta'] . "</td>";
            echo "<td>" . $dado['data_alerta'] . "</td>";
            echo "<td>" . $dado['area_alerta'] . "</td>";
            echo "<td>" . $dado['tipo_alerta'] . "</td>";
            echo "<td>" . $dado['bloco_alerta'] . "</td>";
            echo "<td>" . $dado['andar_alerta'] . "</td>";
            echo "<td>" . $dado['local_alerta'] . "</td>";
            echo "<td>" . $dado['user_alerta'] . "</td>";
            echo "<td>" . $dado['msg_alerta'] . "</td>";
            echo "</tr>";
            }
            ?>
        </table>
        
    </div>


  
