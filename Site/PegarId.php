<?php
include 'DatabaseConfig.php';
$con = mysqli_connect($host, $user, $pass, $db);

$id = mysqli_query($con, "SELECT MAX(id.Alerta)+1 FROM alertas");

$data = date("d.m.y");


 <?php
    include 'DatabaseConfig.php';

    $con = mysqli_connect($host, $user, $pass, $db);

    $S_Campus = 'CampusSQL';
    $S_Bloco = 'BlocoSQL';
    $S_Andar = 'AndarSQL';
    $S_Sala = 'SalaSQL';
    $S_Tipo = 'TipoSQL';
    $S_RGM = '324651321';
    $S_MSG = 'MSGSQL';
    $res = mysqli_query($con, 'SELECT MAX(id_alerta)+1 as mid FROM alertas')or die(mysqli_error($con));
    $data = date("d.m.y");
    $id = mysqli_fetch_assoc($res);

    echo $id['mid'];
?>


















?>