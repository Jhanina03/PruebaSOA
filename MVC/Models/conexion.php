<?php
class conexion
{
    public function conectar($host, $db, $user, $pssw, $port)
    {
        $opc = array(PDO::MYSQL_ATTR_INIT_COMMAND, 'SET NAMES utf8');
        try {
            $con = new PDO("mysql:host=" . $host . ";port=" . $port . ";dbname=" . $db, $user, $pssw, $opc);
            return $con;
        } catch (\Throwable $th) {
            die("Error en la conexión " . $th->getMessage());
        }
    }
}
