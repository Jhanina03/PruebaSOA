<?php
abstract class CRUD
{
    protected PDO $conexion;
    public function __construct() {
        require_once('../Models/conexion.php');
        require_once('../Models/config.php');
        $this->conexion = (new conexion())->conectar($host, $db, $user, $pssw, $port);
    }

    abstract public function select(array $data);
    abstract public function insert(array $data);
    abstract public function update(array $data, $key);
    abstract public function delete($key);
    
}
