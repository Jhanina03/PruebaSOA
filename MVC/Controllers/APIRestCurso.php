<?php
require_once('../Models/CRUD.php');
require_once('../Models/CRUDCurso.php');
$opc = $_SERVER['REQUEST_METHOD'];
$database = new CRUDCurso();
switch ($opc) {
    case 'GET':
        $data = [];
            $res = $database->select([]);
        print_r($res);
        break;
    case 'POST':
        $json = file_get_contents("php://input");
        $data = json_decode($json, true);
        $req = [
            $data['id_estudiante'],
            $data['id_curso']
        ];
        $res = $database->insert($req);
        print_r($res);
        break;
    default:
        print_r("Method not supported");
        break;
}
