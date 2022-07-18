 <?php
    include 'DatabaseConfig.php';

    $con = mysqli_connect($host, $user, $pass, $db);

    $Campus = $_POST['CampusSQL'];
    $Bloco = $_POST['BlocoSQL'];
    $Andar = $_POST['AndarSQL'];
    $Sala = $_POST['SalaSQL'];
    $Tipo = $_POST['TipoSQL'];
    $RGM = '12345678998';
    $MSG = $_POST['MSGSQL'];
    $res = mysqli_query($con, 'SELECT MAX(id_alerta)+1 as mid FROM alertas')or die(mysqli_error($con));
    $data = date("d.m.y");
    $idt = mysqli_fetch_assoc($res);
    $id = $idt['mid'];
        
    $Query = "INSERT INTO alertas (id_alerta, data_alerta, area_alerta, tipo_alerta, bloco_alerta, andar_alerta, local_alerta, user_alerta, msg_alerta) values ('$id','$data','$Campus','$Tipo','$Bloco','$Andar','$Sala','$RGM','$MSG')";

    if(mysqli_query($con,$Query))
    {
        echo 'Alerta criado com sucesso';
    }
    else
    {
        echo 'Algo deu errado, tente novamente';
    }
    
 mysqli_close($con);
    
?>
