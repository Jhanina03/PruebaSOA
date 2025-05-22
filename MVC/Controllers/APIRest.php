<?php
require_once('../Models/CRUD.php');
require_once('../Models/CRUDestudiante.php');
$opc = $_SERVER['REQUEST_METHOD'];
$database = new CRUDestudiante();
switch ($opc) {
    case 'GET':
        $data = [];
        if (isset($_GET['cedula'])) {
            $res = $database->selectOne([$_GET['cedula']]);
        } else {
            $res = $database->select([]);
        }
        print_r($res);
        break;
    case 'POST':
        $json = file_get_contents("php://input");
        $data = json_decode($json, true);
        $req = [
            $data['cedula'],
            $data['nombre'],
            $data['apellido'],
            $data['direccion'],
            $data['telefono']
        ];
        $res = $database->insert($req);
        print_r($res);
        break;
    case 'PUT':
        $cedula = $_GET['cedula'];
        $json = file_get_contents("php://input");
        $data = json_decode($json, true);
        $req = [
            $data['nombre'],
            $data['apellido'],
            $data['direccion'],
            $data['telefono']
        ];
        $res = $database->update($req, $cedula);
        print_r($res);
        break;
    case 'DELETE':
        $req = $_GET['cedula'];
        $res = $database->delete($req);
        print_r($res);
        break;
    default:
        print_r("Method not supported");
        break;
}
